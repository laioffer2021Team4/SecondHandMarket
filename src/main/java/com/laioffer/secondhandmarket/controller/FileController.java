package com.laioffer.secondhandmarket.controller;


import com.laioffer.secondhandmarket.payload.response.FileInfoResponse;
import com.laioffer.secondhandmarket.storage.StorageFileNotFoundException;
import com.laioffer.secondhandmarket.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FileController {

    private final StorageService storageService;
    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfoResponse>> getListFiles() {

        List<FileInfoResponse> fileInfoResponses = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "serveFile", path.getFileName().toString()).build().toString();
            return new FileInfoResponse(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfoResponses);

    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    public ResponseEntity<FileInfoResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = storageService.store(file);
            logger.info("Upload File UUID: " + fileName);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new FileInfoResponse(file.getOriginalFilename(), fileName));
        } catch (Exception e) {
            logger.error("Store File Error:" + e.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                    new FileInfoResponse("Could not upload the file: " + file.getOriginalFilename(), ""));
        }
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<byte[]> getImageFile(@PathVariable String fileName) {
        try {
            byte[] media = storageService.getByteArrayFromFile(fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(media.length);

            return new ResponseEntity<>(media, headers, HttpStatus.OK);
        } catch (IOException ex) {
            logger.error("Get Image Error:" + ex.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                   new byte[0]);
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}