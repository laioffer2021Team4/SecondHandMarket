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

  state = {
    userInfo: null
  }

  // send info by userid(from product table ?


  render() {
    const userInfo = this.props.userInfo;
    return (
      <Card>
        <CardHeader>Seller Info</CardHeader>
        <CardImg src={user_avatar} />
        <CardBody>
          <CardTitle>{userInfo.firstName} {userInfo.lastName}</CardTitle>
          {
            // Object.keys(userInfo.address).map((key, i) => {
            //   return <div>{userInfo.address[key]}</div>
            // })
          }
          <br/>
          <Button>Ask Me &rarr;</Button>
        </CardBody>
        <CardFooter> </CardFooter>
      </Card>
    );
  }
}

export default UserInfo;
