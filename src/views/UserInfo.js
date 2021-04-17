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

class UserInfo extends Component {

  // state = {
  //   userInfo: null
  // }

  // send info by userid(from product table ?
  // displayAddress = address => {
  //
  // }


  render() {
    const userInfo = this.props.userInfo;
    return (
      <Card style={{maxWidth: "100%", height: "inherit"}}>
        <CardHeader>Here's Seller</CardHeader>
        <CardImg style={{display: "block",marginLeft:"auto", marginRight:"auto", maxWidth: "80%"}} src={user_avatar} />
        <CardBody>
          <CardTitle>{userInfo.firstName} {userInfo.lastName}</CardTitle>
          {
            // Object.keys(userInfo.address).map((key, i) => {
            //   return <div>{userInfo.address[key]}</div>
            // })
          }
          <Button style={{position: "relative", top: "10px"}}>More Info &rarr;</Button>
        </CardBody>
        <CardFooter><a href={`mailto:${userInfo.useremail}`}>contact me</a></CardFooter>
      </Card>
    );
  }
}

export default UserInfo;
