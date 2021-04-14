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
import user_avatar from '../images/avatars/0.jpg';

class UserInfo extends Component {

  state = {
    userInfo: null
  }

  // send info by userid(from product table ?


  render() {
    return (
      <Card>
        <CardHeader>Seller Info</CardHeader>
        <CardImg src={user_avatar} />
        <CardBody>
          <CardTitle>Username</CardTitle>
          <p>basic info</p>
          <Button>Read more &rarr;</Button>
        </CardBody>
        <CardFooter>Ask Me: phone number</CardFooter>
      </Card>
    );
  }
}

export default UserInfo;
