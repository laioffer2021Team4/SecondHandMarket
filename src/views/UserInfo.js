import React, {Component} from 'react';
import {
  Card,
  CardHeader,
  CardTitle,
  CardImg,
  CardBody,
  CardFooter
} from "shards-react";
import user_avatar from '../images/avatars/0.jpg';

class UserInfo extends Component {
  render() {
    return (
      <Card>
        <CardHeader>Seller Info</CardHeader>
        <CardImg src={user_avatar} />
        <CardBody>
          <CardTitle>Username</CardTitle>
          <p>basic info</p>
          rate
        </CardBody>
        <CardFooter>Ask Me</CardFooter>
      </Card>
    );
  }
}

export default UserInfo;
