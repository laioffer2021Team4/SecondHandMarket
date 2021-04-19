import React, {Component} from 'react';
import {
  Card,
  CardHeader,
  CardTitle,
  CardImg,
  CardBody,
  CardFooter,
  Button
} from "shards-react";
import user_avatar from '../images/avatars/user.png';
import authService from "../auth/authService"

class UserInfo extends Component {
  constructor(props) {
    super(props);
    this.state={isAuth: undefined};
  }

  componentDidMount() {
    if(authService.getCurrentUser() && authService.getCurrentUser().accessToken ){
      this.setState({isAuth: true});
    } else{
      this.setState({isAuth: false});
    }
  }

  // state = {
  //   userInfo: null
  // }

  // send info by userid(from product table ?
  // displayAddress = address => {
  //
  // }


  render() {
    const sellerInfo = this.props.userInfo;
    const {isAuth} = this.state;
    return (
      <Card style={{maxWidth: "100%", height: "inherit"}}>
        <CardHeader>Seller</CardHeader>
        <CardImg style={{display: "block",marginLeft:"auto", marginRight:"auto", maxWidth: "80%"}} src={user_avatar} />
        <CardBody>
          <CardTitle>{sellerInfo.firstName} {sellerInfo.lastName}</CardTitle>
          {
            // Object.keys(userInfo.address).map((key, i) => {
            //   return <div>{userInfo.address[key]}</div>
            // })
          }

          {
            isAuth? <p>{sellerInfo.useremail}</p> : <Button style={{position: "relative", top: "10px"} }> <a href={"/login"} style={{textDecoration:"none", color:"white"} }>Contact Me</a></Button>
          }

        </CardBody>

      </Card>
    );
  }
}

export default UserInfo;
