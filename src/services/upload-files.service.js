import http from "../http-common";
import authHeader from "../auth/authHeader";
const API_URL = "http://localhost:8080/api/";
const user = JSON.parse(localStorage.getItem('user'));

class UploadFilesService {
  upload(file, onUploadProgress) {
    let formData = new FormData();

    formData.append("file", file);

    return http.post(API_URL + "upload", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
        "Authorization": 'Bearer ' + user.accessToken
      },
      onUploadProgress,
    });
  }

  getFiles() {
    return http.get(API_URL + "files", {
      headers: authHeader()
    });
  }
}

export default new UploadFilesService();
