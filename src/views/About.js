/* eslint jsx-a11y/anchor-is-valid: 0 */

import React from "react";
import { Container} from "shards-react";
import bgImage from "../assets/bg_opacity0.5.png";

class About extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      teamImage: require("../images/content-management/team.png")
    };
  }


  render() {
    const styles = {
      body: {
        backgroundImage: `url(${bgImage})`,
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
      }
    }

    return (
      <Container fluid className="main-content-container px-4" style={styles.body}>
        <div>
          <div style={{padding:"5% 25% 30px"}}>
            <img src={this.state.teamImage}/>
          </div>
          <div style={{padding:"0 25%"}}>
            <h5 className="card-title">
              Lai Offer Team 4
            </h5>
            <p>We teamed up and made this secondhand market web application; Though not perfect, we learned and gained.</p>
            <h5>Team members:</h5>
            <p> Wei Wang(Tech Lead), Yingying Xin(project leader), Xinhao Song,Yu Zhao</p>
            <p> XiuZhong Yang, Jianing Cheng,Lu Liu,Ling Zhao</p>
            <p>Xujun Wang,Shuofei Wu,Boyang Zhou</p>
            <span className="text-muted">3/20/2021~4/21/2021</span>
          </div>
        </div>

      </Container>
    );
  }
}

export default About;
