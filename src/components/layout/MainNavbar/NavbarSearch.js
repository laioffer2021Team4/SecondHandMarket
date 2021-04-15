import React from "react";
import {
  Form,
  InputGroup,
  InputGroupAddon,
  InputGroupText,
  FormInput,
  Button
} from "shards-react";
import { withRouter } from "react-router-dom";

class NavbarSearch extends React.Component {
  constructor(props) {
    super(props);
    this.redirectToSearchResult = this.redirectToSearchResult.bind(this);
    this.state = {
      keyword: ""
    };
  }

  handleChange = e => {
    this.setState({
      keyword: e.target.value
    });
  }

  redirectToSearchResult(keyword, e) {
    e.preventDefault();
    this.props.history.push({
      pathname:"/search-result",
      state:{
        keyword: keyword
      }
    });
  }

  render() {
    return(
      <Form className="main-navbar__search w-100 d-none d-md-flex d-lg-flex">
        <InputGroup seamless className="ml-3">
          <InputGroupAddon type="prepend">
            <InputGroupText>
              <i className="material-icons">search</i>
            </InputGroupText>
          </InputGroupAddon>
          <FormInput
            className="navbar-search"
            placeholder="Search for your needs..."
            value = {this.state.keyword}
            onChange = {this.handleChange}
          />
        </InputGroup>
        <Button
          variant="primary"
          onClick={(e) => this.redirectToSearchResult(this.state.keyword, e)}>
          Go
        </Button>
      </Form>
    )
  }
}

export default withRouter(NavbarSearch);
