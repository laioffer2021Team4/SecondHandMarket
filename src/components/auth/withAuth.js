import React from "react";
import authService from "../../auth/authService"
import {Redirect} from "react-router-dom"



const withAuth = (WrappedComponent) => {
  return class extends React.Component {
    constructor(props) {
      super(props);
      this.state={isAuth: undefined};
    }

    componentDidMount() {
      if(authService.getCurrentUser() && authService.getCurrentUser().accessToken ){
        this.setState({isAuth: true});
      } else{
        this.setState({isAuth: false});
      }
    }


    render() {
      // ... and renders the wrapped component with the fresh data!
      // Notice that we pass through any additional props
      if(this.state.isAuth){
        return <WrappedComponent  {...this.props} />;
      } else if( this.state.isAuth === undefined) {
        return <h1> loading </h1>
      } else {
        return <Redirect to="/login" />
      }

    }
  };
};


export default withAuth;
