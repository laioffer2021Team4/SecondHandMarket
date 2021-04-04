import React from "react";
import { Nav } from "shards-react";
import NavMenu from "./NavMenu"
import UserActions from "./UserActions"



export default () => (
  <Nav navbar className="border-left flex-row">
    {/*<Notifications />*/}

    <NavMenu />
    <UserActions />
  </Nav>
);
