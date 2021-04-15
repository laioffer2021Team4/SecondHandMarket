import React from "react";
import ProductService from "../services/product.service";
import withAuth from "../components/auth/withAuth.js"

import {
  Container,
  Row,
  Col,
  Card,
  CardBody,
  Button
} from "shards-react";

class SearchResult extends React.Component {
  constructor(props) {
    super(props);
    this.listAllSearchResults = this.listAllSearchResults.bind(this);
    this.redirectToProductDetail = this.redirectToProductDetail.bind(this);
    this.state = {
      resultList: []
    }
  }

  componentDidMount() {
    const {keyword} = this.props.location.state
    this.listAllSearchResults(keyword);
  }

  listAllSearchResults(keyword) {
    ProductService.searchProductByKeyword(keyword)
      .then(response => {
        let responseList = response.data.map((post, idx) => {
          return {
            title: post.title,
            uuid: post.uuid,
            productId: post.productId
          }
        });
        this.setState({
          resultList: responseList
        });
      })
      .catch(e => {
        console.log(e);
      });
  }

  redirectToProductDetail(productId, e) {
    e.preventDefault();
    this.props.history.push({
      pathname:"/product-detail",
      state:{
        productId: productId
      }
    });
  }

  render() {
    const { resultList } = this.state;
    return (
      <Container fluid className="main-content-container px-4">
        <div style={{margin:"10px 0 0 20px"}}>
          {/*page title: My Posts*/}
          <div className="page-header py-4">
            <h3>Search result for "{this.props.location.state.keyword}"</h3>
          </div>

          {/*posts*/}
          <Row>
            {resultList.map((post, idx) => (
              <Col lg="3" md="6" sm="12" className="mb-4" key={idx}>
                <Card className="card-post card-post--1">
                  <div
                    className="card-post__image"
                    style={{ backgroundImage: "url(http://localhost:8080/api/images/" + post.uuid +")" }}
                  />
                  <CardBody>
                    <h5 className="card-title">
                      {post.title}
                    </h5>
                    <Button variant="primary" onClick={(e) => this.redirectToProductDetail(post.productId, e)}>View Details</Button>
                  </CardBody>
                </Card>
              </Col>
            ))}
          </Row>
        </div>
      </Container>
    );
  }
}

export default withAuth(SearchResult);
