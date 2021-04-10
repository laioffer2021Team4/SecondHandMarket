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

  logout(email) {
    localStorage.removeItem("user");
    return axios.post(API_URL + "logout", {
      email
    })
  }

  register(email, password, firstname, lastname, street, city, state, zipcode) {
    return axios.post(API_URL + "register", {
      email,
      password,
      firstname,
      lastname,
      street,
      city,
      state,
      zipcode
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AuthService();
