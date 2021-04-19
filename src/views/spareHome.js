/* eslint jsx-a11y/anchor-is-valid: 0 */

import React from "react";
import {Container} from "shards-react";
import bgImage from "../assets/bg.png";


class SpareHome extends React.Component {
  constructor(props) {
    super(props);
    // this.state = {
    //   bg: {backgroundImage: require("../assets/bg.png")}
    // };
  }

  // setBodyBg = status => {
  //   const $container = document.querySelector("Container")[0];
  //   if ($container instanceof HTMLBodyElement) {
  //     $container.setAttribute('bg', status ? 'set' : 'none');
  //   }
  // }
  // componentDidMount() {
  //   this.setBodyBg(true);
  // }
  //
  // componentWillUnmount() {
  //   this.setBodyBg(false);
  // }
  render() {
    // const {  bg   } = this.state;

    return (
      <Container fluid className="main-content-container px-4" style={{backgroundImage:`url(${bgImage})`}}>
      </Container>
    );
  }
}

export default SpareHome;
