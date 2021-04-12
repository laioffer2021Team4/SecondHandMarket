import React, {Component} from "react";
import {
  Container, Row, Col, Card, CardHeader, ListGroup,
  ListGroupItem, FormInput, FormGroup, Form
} from "shards-react";
import avatar from "./../images/avatars/0.jpg"

import PageTitle from "../components/common/PageTitle";


export default class UserProfile extends Component {
  state = {
    currUser: JSON.parse(localStorage.getItem('user'))
  }

  render() {
    const {currUser} = this.state;
    return (
      <Container fluid className="main-content-container px-4">
        <Row noGutters className="page-header py-4">
          <PageTitle title="User Profile" subtitle="Overview" md="12"
                     className="ml-sm-auto mr-sm-auto"/>
        </Row>
        <Row>
          <Col lg="4">
            <Card small className="mb-4 pt-3">
              <CardHeader className="border-bottom text-center">
                <div className="mb-3 mx-auto">
                  <img
                    className="rounded-circle"
                    src={avatar}
                    alt={currUser.name}
                    width="110"
                  />
                </div>
                <h4 className="mb-0">{currUser.name}</h4>
              </CardHeader>
            </Card>
          </Col>
          <Col lg="8">
            <Card small className="mb-4">
              <CardHeader className="border-bottom">
                <h6 className="m-0">Account Details</h6>
              </CardHeader>
              <ListGroup flush>
                <ListGroupItem className="p-3">
                  <Row>
                    <Col>
                      <Form>
                        <Row form>
                          {/* First Name */}
                          <Col md="6" className="form-group">
                            <label htmlFor="fefirstname">First Name</label>
                            <FormInput readOnly
                                       id="fefirstname"
                                       placeholder="First Name"
                                       value={currUser.firstname}
                            />
                          </Col>
                          {/* Last Name */}
                          <Col md="6" className="form-group">
                            <label htmlFor="felastname">Last Name</label>
                            <FormInput readOnly
                                       id="felastname"
                                       placeholder="Last Name"
                                       value={currUser.lastname}
                            />
                          </Col>
                        </Row>
                        <Row form>
                          {/* Email */}
                          <Col md="6" className="form-group">
                            <label htmlFor="feEmail">Email</label>
                            <FormInput readOnly
                                       type="email"
                                       id="feEmail"
                                       placeholder="Email Address"
                                       value={currUser.email}
                            />
                          </Col>
                          {/* Password */}
                          <Col md="6" className="form-group">
                            <label htmlFor="fePassword">Password</label>
                            <FormInput readOnly
                                       type="password"
                                       id="fePassword"
                                       placeholder="Password"
                                       value={currUser.password}
                                       autoComplete="current-password"
                            />
                          </Col>
                        </Row>
                        <FormGroup>
                          <label htmlFor="feAddress">Address</label>
                          <FormInput readOnly
                                     id="feAddress"
                                     placeholder="Address"
                                     value={currUser.street}
                          />
                        </FormGroup>
                        <Row form>
                          {/* City */}
                          <Col md="6" className="form-group">
                            <label htmlFor="feCity">City</label>
                            <FormInput readOnly
                                       id="feCity"
                                       placeholder="City"
                                       value={currUser.city}
                            />
                          </Col>
                          {/* State */}
                          <Col md="4" className="form-group">
                            <label htmlFor="feInputState">State</label>
                            <FormInput readOnly id="feInputState"
                                       placeholder="State"
                                       value={currUser.state}>
                            </FormInput>
                          </Col>
                          {/* Zip Code */}
                          <Col md="2" className="form-group">
                            <label htmlFor="feZipCode">Zip</label>
                            <FormInput readOnly
                                       id="feZipCode"
                                       placeholder="Zip"
                                       value={currUser.zipcode}
                            />
                          </Col>
                        </Row>
                      </Form>
                    </Col>
                  </Row>
                </ListGroupItem>
              </ListGroup>
            </Card>

          </Col>
        </Row>
      </Container>
    )
  };
}

