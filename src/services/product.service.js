import axios from "axios";
import authHeader from "../auth/authHeader";
const API_URL = "http://localhost:8080/api/product/";

class ProductService {

  addProduct(title, street, city, state, zipcode, price, description, condition, uuids) {
    const email = JSON.parse(localStorage.getItem('user')).email;
    return axios.post(API_URL + "add", {
      email,
      title,
      street,
      city,
      state,
      zipcode,
      price,
      description,
      condition,
      uuids
    }, {
      headers: authHeader()
    })
  }

  getAllMyProducts() {
    const email = JSON.parse(localStorage.getItem('user')).email;
    return axios.get(API_URL + "products/" + email, {headers: authHeader()})
  }
}

export default new ProductService();
