import React, {Component} from "react";
import { Nav } from "shards-react";
import NavMenu from "./NavMenu"
import UserActions from "./UserActions"
import authService from "../../../../auth/authService"



 class NavbarNav extends Component {
   constructor(props) {
     super(props);
     this.state={isAuth: undefined};
   }
   componentWillMount() {
     if(authService.getCurrentUser() && authService.getCurrentUser().accessToken ){
       this.setState({isAuth: true});
     } else{
       this.setState({isAuth: false});
     }
   }
  render(){
    return(
      <Nav navbar className="border-left flex-row">
        {/*  <Notifications />*/}
        { this.state.isAuth? <UserActions/> : <NavMenu/> }
      </Nav>
    )
  }

}
export default NavbarNav;
