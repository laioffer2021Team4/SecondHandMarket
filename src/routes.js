import React from "react";
import { Redirect } from "react-router-dom";

// Layout Types
import { DefaultLayout } from "./layouts";

// Route Views
import BlogOverview from "./views/BlogOverview";
import UserProfileLite from "./views/UserProfileLite";
import AddNewPost from "./views/AddNewPost";
import Errors from "./views/Errors";
import ComponentsOverview from "./views/ComponentsOverview";
import Tables from "./views/Tables";
import Home from "./views/Home";
import Register from "./views/Register"
import Login from "./views/Login"
<<<<<<< HEAD
import PostNewProduct from "./views/PostNewProduct";
import editPost from "./views/editPost";
=======
import ProductsList from "./views/ProductsList"
>>>>>>> 2beae60d6b941a19cba68c1a2ac72621a5069a5e

export default [
  {
    path: "/",
    exact: true,
    layout: DefaultLayout,
    component: () => <Redirect to="/home" />
  },
  {
    path: "/blog-overview",
    layout: DefaultLayout,
    component: BlogOverview
  },
  {
    path: "/user-profile-lite",
    layout: DefaultLayout,
    component: UserProfileLite
  },
  {
    path: "/add-new-post",
    layout: DefaultLayout,
    component: AddNewPost
  },
  {
    path: "/errors",
    layout: DefaultLayout,
    component: Errors
  },
  {
    path: "/components-overview",
    layout: DefaultLayout,
    component: ComponentsOverview
  },
  {
    path: "/tables",
    layout: DefaultLayout,
    component: Tables
  },
  {
    path: "/home",
    layout: DefaultLayout,
    component: Home
  },
  {
    path: "/register",
    layout: DefaultLayout,
    component: Register
  },
  {
    path: "/login",
    layout: DefaultLayout,
    component: Login
  },
  {
<<<<<<< HEAD
    path: "/post-new-product",
    layout: DefaultLayout,
    component: PostNewProduct
  },
  {
    path: "/edit-post",
    layout: DefaultLayout,
    component: editPost
=======
    path: "/myposts",
    layout: DefaultLayout,
    component: ProductsList
>>>>>>> 2beae60d6b941a19cba68c1a2ac72621a5069a5e
  }
];
