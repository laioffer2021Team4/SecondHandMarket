import React, {Component} from "react";
import {
  Container,
  Form,
  FormGroup,
  FormInput, Button, Row, Col, FormSelect
} from "shards-react";
import AuthService from "../auth/authService"



class Register extends Component {
  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeEmail= this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeStreet = this.onChangeStreet.bind(this);
    this.onChangeCity = this.onChangeCity.bind(this);
    this.onChangeState = this.onChangeState.bind(this);
    this.onChangeZip = this.onChangeZip.bind(this);
    this.state = {
      email: "",
      password: "",
      firstName: "",
      lastName: "",
      address: "",
      city: "",
      state: "",
      zip: ""
    };
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }
  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }
  onChangeFirstName(e) {
    this.setState({
      firstName: e.target.value
    });
  }
  onChangeLastName(e) {
    this.setState({
      lastName: e.target.value
    });
  }
  onChangeStreet(e) {
    this.setState({
      street: e.target.value
    });
  }
  onChangeCity(e) {
    this.setState({
      city: e.target.value
    });
  }
  onChangeState(e) {
    this.setState({
      state: e.target.value
    });
  }
  onChangeZip(e) {
    this.setState({
      zip: e.target.value
    });
  }


  handleRegister = e=>{
    e.preventDefault();
    const {email,password, firstName, lastName, street, city, state, zip} = this.state;
    AuthService.register(email, password, firstName, lastName, street, city, state, zip).then(
      () => {
       return AuthService.login(email, password)
      })
      .then(
        () => {
          this.props.history.push("/");
          window.location.reload();
        });
  }

  render(){
    return(
      <Container fluid className="main-content-container px-4 pb-4" style={{display:"flex", justifyContent:"center"}}>
        {/* Page Header */}
        <div style={{width:"350px"}}>
          <div className="page-header py-4">
            <h3 style={{textAlign:"center"}}>Welcome to Register</h3>
            <p style={{color:"grey", paddingTop:"3px", textAlign:"center"}}>Make your not-in-use item to be others' treasure</p>
          </div>
          <Form onSubmit={this.handleRegister}>
            <FormGroup>
              <FormInput
                placeholder="Email"
                name="email"
                value={this.state.email}
                onChange={this.onChangeEmail}
              />
            </FormGroup>
            <FormGroup>
              <FormInput
                type="password"
                placeholder="Password"
                name="password"
                value={this.state.password}
                onChange={this.onChangePassword}
              />
            </FormGroup>
            {/*<FormGroup>*/}
            {/*  <FormInput*/}
            {/*    type="password"*/}
            {/*    placeholder="Reconfirm Your Password"*/}
            {/*    onChange={() => {}}*/}
            {/*  />*/}
            {/*</FormGroup>*/}

            <Row form>
            {/* First Name */}
              <Col md="6" className="form-group">
              <label htmlFor="feFirstName">First Name</label>
              <FormInput
                id="feFirstName"
                placeholder="First Name"
                value={this.state.firstName}
                onChange={this.onChangeFirstName}
              />
            </Col>
            {/* Last Name */}
              <Col md="6" className="form-group">
                <label htmlFor="feLastName">Last Name</label>
                <FormInput
                  id="feLastName"
                  placeholder="Last Name"
                  value={this.state.lastName}
                  onChange={this.onChangeLastName}
                />
              </Col>
            </Row>
            <FormGroup>
            <label htmlFor="feStreet">Street</label>
            <FormInput
              id="feStreet"
              placeholder="Street"
              value={this.state.street}
              onChange={this.onChangeStreet}
            />
          </FormGroup>
            <Row form>
            {/* City */}
            <Col md="5" className="form-group">
              <label htmlFor="feCity">City</label>
              <FormInput
                id="feCity"
                placeholder="City"
                value={this.state.city}
                onChange={this.onChangeCity}
              />
            </Col>
            {/* State */}
            <Col md="4" className="form-group">
              <label htmlFor="feInputState">State</label>
              <FormInput
                id="InputState"
                placeholder="City"
                value={this.state.state}
                onChange={this.onChangeState}
              />
            </Col>
            {/* Zip Code */}
            <Col md="3" className="form-group">
              <label htmlFor="feZipCode">Zip</label>
              <FormInput
                id="feZipCode"
                placeholder="Zip code"
                value={this.state.zip}
                onChange={this.onChangeZip}
              />
            </Col>
          </Row>

            <Button type="submit" style={{marginTop:"10px"}}>Create New Account</Button>
          </Form>
        </div>
      </Container>

    )
  }
}

export default Register;
