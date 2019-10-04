import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import MenuComponent from './MenuComponent';
import AuthenticatedRoute from "./AuthenticatedRoute";
import Login from "./LoginComponent";
import UserWrapper from "./user/UserWrapper";
import AuthenticationService from "../service/AuthenticationService";

class FrontendApp extends React.Component {
    render() {
        return (
            <Router>
                <MenuComponent isUserLoggedIn={AuthenticationService.isUserLoggedIn()}/>
                <Switch>
                    <Route path="/" exact component={Login}/>
                    <Route path="/login" exact component={Login}/>
                    <AuthenticatedRoute path='/logout' exact component={Login}/>
                    <AuthenticatedRoute path="/user" exact component={UserWrapper}/>
                </Switch>
            </Router>
        );
    }
}

export default FrontendApp