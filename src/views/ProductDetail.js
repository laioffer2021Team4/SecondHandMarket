import React, {Component} from 'react';
import ProductInfo from "./ProductInfo";
import ProductImage from "./ProductImage";
import UserInfo from "./UserInfo";
import "react-image-gallery/styles/css/image-gallery.css";
import { Container, Row, Col } from "shards-react";
import axios from "axios";
import authHeader from "../auth/authHeader";
const API_URL = "http://localhost:8080/api/product/";

class ProductDetail extends Component {

  state = {
    productInfo: null,
    isLoading: true
  }

  // get productId ?

  // fetch data from db
  componentDidMount() {
    const productId = this.props.match.params.productId;
    axios.get(API_URL + `detail/${productId}`, {headers: authHeader()})
      .then(response => {
        console.log('response -> ', response);
        this.setState({
          productInfo: response.data,
          isLoading: false
        })
      })
      .catch(err => {
        console.log('err -> ', err);
      })
  }

  render() {
    const {productInfo, isLoading} = this.state;
    return (
      isLoading || !productInfo ?
        null
        :
      <Container fluid className="main-content-container px-4" style={{width: '100%', padding: '3rem 4rem'}}>
        <div style={{ display: 'flex', justifyContent: 'center' }}>
          <h1>{productInfo.title}</h1>
        </div>

        <hr />

        <Row>
          <Col sm="12" md="4" lg="5">
            <ProductImage images={productInfo.image}/>
          </Col>
          <Col sm="12" md="4" lg="5">
            <ProductInfo info={productInfo}/>
          </Col>
          <Col sm="12" md="4" lg="2">
            <UserInfo userInfo={productInfo.customer}/>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default ProductDetail;
