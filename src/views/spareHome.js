/* eslint jsx-a11y/anchor-is-valid: 0 */

import React from "react";
import {Container} from "shards-react";
import bgImage from "../assets/bg.png";


class SpareHome extends React.Component {

  render() {
    return (
      <Container fluid className="main-content-container px-4" style={{backgroundImage:`url(${bgImage})`, backgroundRepeat: 'no-repeat', backgroundSize:'cover',opacity:'0.5'}}>
      </Container>
    );
  }
}

export default SpareHome;
