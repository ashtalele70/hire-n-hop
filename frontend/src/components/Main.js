import React, { Component } from "react";
import { Route } from "react-router-dom";
import "../App.css";
import axios from "axios";
import cookie from "react-cookies";
import { Redirect } from "react-router";
import RentalLogin from "./rentalLogin/rentalLogin";
import SignUp from "./signUp/signUp";
import Navigation from "./Navbar/Navbar";

class Home extends Component {
  render() {
    return (
      <div>
        <Route path="/" component={Navigation} />
        <Route exact path="/login" component={RentalLogin} />
        <Route exact path="/signup" component={SignUp} />
      </div>
    );
  }
}
//export Home Component
export default Home;
