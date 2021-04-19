import React from "react";
import { Link } from "react-router-dom";
import {
  Dropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  Collapse,
  NavItem,
  NavLink
} from "shards-react";
import AuthService from "../../../../auth/authService"

export default class UserActions extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      visible: false,
      userName: ""
    };
    this.toggleUserActions = this.toggleUserActions.bind(this);
  }

  toggleUserActions() {
    this.setState({
      visible: !this.state.visible
    });
  }
  handleLogout = e=>{
    e.preventDefault();
    AuthService.logout(AuthService.getCurrentUser().email);
    window.location.href="/";
  }

  componentDidMount() {
    let userInfo = AuthService.getCurrentUser();
    this.setState({
      userName: userInfo.customer.firstName
    })

  }

  render() {

    return (
      <NavItem tag={Dropdown} caret toggle={this.toggleUserActions}>
        <DropdownToggle caret tag={NavLink} className="text-nowrap px-3">
          <img
            className="user-avatar rounded-circle mr-2"
            src={require("./../../../../images/avatars/user.png")}
            alt="User Avatar"
            style={{padding:"4px"}}
          />{" "}
          <span className="d-none d-md-inline-block">{this.state.userName}</span>
        </DropdownToggle>
        <Collapse tag={DropdownMenu} right small open={this.state.visible}>
          <DropdownItem tag={Link} to="/profile">
            <i className="material-icons">&#xE7FD;</i> Profile
          </DropdownItem>
          {/*<DropdownItem tag={Link} to="edit-user-profile">*/}
          {/*  <i className="material-icons">&#xE8B8;</i> Edit Profile*/}
          {/*</DropdownItem>*/}
          {/*<DropdownItem tag={Link} to="file-manager-list">*/}
          {/*  <i className="material-icons">&#xE2C7;</i> Files*/}
          {/*</DropdownItem>*/}
          <DropdownItem tag={Link} to="/myposts">
            <i className="material-icons">&#xE896;</i> My posts
          </DropdownItem>
          <DropdownItem divider />
          <DropdownItem onClick={this.handleLogout} className="text-danger">
            <i className="material-icons text-danger">&#xE879;</i> Logout
          </DropdownItem>
        </Collapse>
      </NavItem>
    );
  }
}
