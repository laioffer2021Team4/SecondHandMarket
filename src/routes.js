import React from "react";
import { Redirect } from "react-router-dom";

// Layout Types
import { DefaultLayout } from "./layouts";

// Route Views
import BlogOverview from "./views/BlogOverview";
import UserProfile from "./views/UserProfile";
import AddNewPost from "./views/AddNewPost";
import Errors from "./views/Errors";
import ComponentsOverview from "./views/ComponentsOverview";
import Tables from "./views/Tables";
import Home from "./views/Home";
import Register from "./views/Register"
import Login from "./views/Login"
import ProductsList from "./views/ProductsList"
import PostNewProduct from "./views/PostNewProduct";
import EditPost from "./views/EditPost";
import ProductDetail from "./views/ProductDetail"
import SearchResult from "./views/SearchResult";
import SpareHome from "./views/spareHome"
import About from "./views/About"

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
    component: SpareHome
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
    path: "/myposts",
    layout: DefaultLayout,
    component: ProductsList
  },
  {
    path: "/edit-post",
    layout: DefaultLayout,
    component: EditPost
  },
  {
    path: "/post-new-product",
    layout: DefaultLayout,
    component: PostNewProduct
  },
  {
    path: "/profile",
    layout: DefaultLayout,
    component: UserProfile
  },
  {
    path: "/product/:productId",
    layout: DefaultLayout,
    component: ProductDetail
  },
  {
    path: "/search-result",
    layout:DefaultLayout,
    component: SearchResult
  },
  {
    path: "/about",
    layout:DefaultLayout,
    component: About
  }
];
