import React from "react";
import {
  Container,
  Form,
  FormGroup,
  FormInput, Button
} from "shards-react";


const Login = () => (

  <Container fluid className="main-content-container px-4 pb-4" style={{display:"flex", justifyContent:"center"}}>
    {/* Page Header */}
    <div style={{width:"350px"}}>
      <div className="page-header py-4">
        <h3 style={{textAlign:"center"}}>Welcome to Login</h3>
        <p style={{color:"grey", paddingTop:"3px", textAlign:"center"}}>Make your not-in-use item to be others' treasure</p>
      </div>

      <Form>
        <FormGroup>
          <FormInput placeholder="Email" />
        </FormGroup>
        <FormGroup>
          <FormInput
            type="password"
            placeholder="Password"
            onChange={() => {}}
          />
        </FormGroup>
        <Button type="submit" style={{marginTop:"10px"}}>Login</Button>
      </Form>

    </div>

  </Container>
);

export default Login;
