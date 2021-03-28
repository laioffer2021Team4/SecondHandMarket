package com.laioffer.SecondHandMarket.clients;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Service
@PropertySource("classpath:application.properties")
@Repository
public class AmazonS3Client {
    private AmazonS3 s3client;
    @Value("${s3.endpointUrl}")
    private String endpointUrl;
    @Value("${s3.bucketName}")
    private String bucketName;
    @Value("${s3.accessKeyId}")
    private String accessKeyId;
    @Value("${s3.secretKey}")
    private String secretKey;
    @Value("${s3.region}")
    private String region;
    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials
                = new BasicAWSCredentials(this.accessKeyId, this.secretKey);
        this.s3client = AmazonS3ClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
    public String uploadFile(MultipartFile multipartFile)
            throws Exception {
        String fileUrl = "";
        File file = convertMultiPartToFile(multipartFile);
        String fileName = generateFileName(multipartFile);
        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
        uploadFileTos3bucket(fileName, file);
        file.delete();
        return fileUrl;
    }

    public S3Object getFileFromS3Bucket(String fileUrl) {
        return s3client.getObject(bucketName, getFileNameFromFileURL(fileUrl));
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        s3client.deleteObject(bucketName, getFileNameFromFileURL(fileUrl));
        return "Successfully deleted";
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(bucketName, fileName, file);
    }


    private File convertMultiPartToFile(MultipartFile file)
            throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" +   Objects.requireNonNull(multiPart.getOriginalFilename()).replace(" ", "_");
    }

    private String getFileNameFromFileURL(String fileUrl) {
        return fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
    }
}
