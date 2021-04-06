/* eslint jsx-a11y/anchor-is-valid: 0 */

import React from "react";
import AddIcon from '@material-ui/icons/Add';
import withAuth from "../components/auth/withAuth.js"

import {
  Container,
  Row,
  Col,
  Card,
  CardBody
} from "shards-react";


class BlogPosts extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      // First list of posts.
      PostsListOne: [
        {
          backgroundImage: require("../images/content-management/1.jpeg"),
          name: "Item name1"
        },
        {
          backgroundImage: require("../images/content-management/2.jpeg"),
          name: "Item name2"
        }
      ]
    };
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
                    style={{ backgroundImage: `url(${post.backgroundImage})` }}
                  />
                  <CardBody>
                    <h5 className="card-title">
                      <a href="#" className="text-fiord-blue">
                        {post.name}
                      </a>
                    </h5>
                  </CardBody>
                </Card>
              </Col>
            ))}

            <Col lg="3" md="6" sm="12" className="mb-4" >
              <Card className="card-post card-post--1">
                <div className="card-post__image" style={{ display:"flex", justifyContent:"center" }}>
                  <a href="#">
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

export default withAuth(BlogPosts);
