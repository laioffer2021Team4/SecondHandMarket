import React, {Component} from "react";
import {
  Container,
  Form,
  FormGroup,
  FormInput, Button
} from "shards-react";
import AuthService from "../auth/authService"



class Login extends Component {
  constructor(props) {
    super(props);
    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeEmail= this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.state = {
      email: "",
      password: ""
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

  handleLogin = e=>{
    e.preventDefault();

    AuthService.login(this.state.email, this.state.password).then(
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
            <h3 style={{textAlign:"center"}}>Welcome to Login</h3>
            <p style={{color:"grey", paddingTop:"3px", textAlign:"center"}}>Make your not-in-use item to be others' treasure</p>
          </div>

          <Form onSubmit={this.handleLogin}>
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
            <Button type="submit" style={{marginTop:"10px"}}>Login</Button>
          </Form>

        </div>

      </Container>
    );
  }
}


export default Login;
