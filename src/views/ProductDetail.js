import React, {Component} from 'react';
import ProductInfo from "./ProductInfo";
import ProductImage from "./ProductImage";
import UserInfo from "./UserInfo";
import "react-image-gallery/styles/css/image-gallery.css";
import { Container, Row, Col } from "shards-react";

class ProductDetail extends Component {

  // get productId ?

  // fetch data from db

  render() {
    return (
      <Container fluid className="main-content-container px-4" style={{width: '100%', padding: '3rem 4rem'}}>
        <div style={{ display: 'flex', justifyContent: 'center' }}>
          <h1>Product Title</h1>
        </div>

        <hr />

        <Row>
          <Col sm="12" md="4" lg="5">
            <ProductImage />
          </Col>
          <Col sm="12" md="4" lg="5">
            <ProductInfo />
          </Col>
          <Col sm="12" md="4" lg="2">
            <UserInfo />
          </Col>
        </Row>
      </Container>
    );
  }
}

export default ProductDetail;