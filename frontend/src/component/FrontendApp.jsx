import React, {useState} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import MenuComponent from './MenuComponent';
import Login from "./LoginComponent";
import UserWrapper from "./user/UserWrapper";
import AuthenticationService from "../service/AuthenticationService";

const FrontendApp = () => {

    const [userLoggedIn, setUserLoggedIn] = useState(AuthenticationService.isUserLoggedIn());

    const loginStateHandler = (v) => {
        setUserLoggedIn(v);
    };

    return (
        <Router>
            <MenuComponent isLoggedIn={userLoggedIn} handleLoginState={loginStateHandler}/>
            <Switch>
                <Route exact path="/">
                    <Login handleLoginState={loginStateHandler} />
                </Route>
                <Route exact path="/login">
                    <Login handleLoginState={loginStateHandler} />
                </Route>
                <Route path="/user">
                    <UserWrapper/>
                </Route>
                <Route path="/logout">
                    <Login handleLoginState={loginStateHandler} />
                </Route>
            </Switch>
        </Router>
    );
};

export default FrontendApp