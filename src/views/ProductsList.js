/* eslint jsx-a11y/anchor-is-valid: 0 */

import React from "react";
import AddIcon from '@material-ui/icons/Add';
import withAuth from "../components/auth/withAuth.js"
import ProductService from "../services/product.service";
import UploadService from "../services/upload-files.service";

import {
  Container,
  Row,
  Col,
  Card,
  CardBody
} from "shards-react";

class ProductPosts extends React.Component {
  constructor(props) {
    super(props)
    this.listAllMyProducts = this.listAllMyProducts.bind(this);
    this.state = {
      // First list of posts.
      PostsListOne: []
    };
  }

  componentDidMount() {
    this.listAllMyProducts();
  }

  listAllMyProducts() {
    ProductService.getAllMyProducts()
      .then(response => {
        let productList = response.data.map((post, idx) => {
          return {
            title: post.title,
            uuid: post.uuid
          }
        });
        this.setState({
          PostsListOne: productList
        });
        // ToDo make Byte[] work
        // this.state.PostsListOne.map((post, idx) => (
        //   UploadService.getImage(post.uuid)
        //     .then(response => {
        //       post.backgroudImage = "data:image/png;base64," +  response.data
        //     })
        // ))
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const {  PostsListOne   } = this.state;
    return (
      <Container fluid className="main-content-container px-4">
        <div style={{margin:"10px 0 0 20px"}}>
          {/*page title: My Posts*/}
          <div className="page-header py-4">
            <h3>My Posts</h3>
          </div>

          {/*posts*/}
          <Row>
          {PostsListOne.map((post, idx) => (
              <Col lg="3" md="6" sm="12" className="mb-4" key={idx}>
                <Card className="card-post card-post--1">
                  <div
                    className="card-post__image"
                    style={{ backgroundImage: "url(http://localhost:8080/api/images/" + post.uuid +")" }}
                  />
                  <CardBody>
                    <h5 className="card-title">
                      <a href="#" className="text-fiord-blue">
                        {post.title}
                      </a>
                    </h5>
                  </CardBody>
                </Card>
              </Col>
            ))}

            <Col lg="3" md="6" sm="12" className="mb-4" >
              <Card className="card-post card-post--1">
                <div className="card-post__image" style={{ display:"flex", justifyContent:"center" }}>
                  <a href="/post-new-product">
                    <AddIcon style={{ fontSize: "100px", marginTop:"50px" }}/>
                  </a>
                </div>
                <CardBody>
                  <h5 style={{textAlign:"center"}}>
                    Add new post
                  </h5>
                </CardBody>
              </Card>
            </Col>
          </Row>
        </div>
      </Container>
    );
  }
}

export default withAuth(ProductPosts);
