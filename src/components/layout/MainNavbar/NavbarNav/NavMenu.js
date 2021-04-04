import React from "react";
import {Nav, NavItem, NavLink} from "shards-react"
import {Link} from "react-router-dom"
import PropTypes from "prop-types";
import UserActions from "./UserActions"


const NavMenu = ({ menuItems }) => (
        <Nav style={{width:'200px'}}>
          {menuItems.map((item, idx) => (
            <NavItem key={idx}>
              <NavLink tag={Link} to={item.to} style={{textAlign:'center', lineHeight:'40px'}}>
                {item.title}
              </NavLink>
            </NavItem>
          ))}

        </Nav>
);

NavMenu.propTypes = {
  menuItems: PropTypes.array
};

NavMenu.defaultProps = {
  menuItems: [
    {
      title: "Register",
      to: "/register"
    },
    {
      title: "Login",
      to: "/login"
    }
  ]
};
export default NavMenu;
