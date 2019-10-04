import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import MenuComponent from './MenuComponent';
import AuthenticatedRoute from "./AuthenticatedRoute";
import LoginComponent from "./LoginComponent";
import UserWrapper from "./user/UserWrapper";

class FrontendApp extends React.Component {
    render() {
        return (
            <Router>
                <MenuComponent/>
                <Switch>
                    <Route path="/" exact component={LoginComponent}/>
                    <Route path="/login" exact component={LoginComponent}/>
                    <AuthenticatedRoute path="/user" exact component={UserWrapper}/>
                </Switch>
            </Router>
        );
    }
}

export default FrontendApp