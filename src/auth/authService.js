import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(email, password) {
    return axios
      .post(API_URL + "login", {
        email,
        password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(email, password, firstname, lastname, street, city, state, zip) {
    return axios.post(API_URL + "register", {
      email,
      password,
      firstname,
      lastname,
      street,
      city,
      state,
      zip
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AuthService();
