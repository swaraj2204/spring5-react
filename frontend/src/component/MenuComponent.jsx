import React from 'react'
import AuthenticationService from "../service/AuthenticationService";
import {Link} from "react-router-dom";

class MenuComponent extends React.Component {
    render() {
        const isUserLoggedIn = this.props.isUserLoggedIn;
        return (
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top sticky-top">
                <ul className="navbar-nav">
                    <li><Link className="nav-link" to="/user">User</Link></li>
                </ul>
                <ul className="navbar-nav navbar-collapse justify-content-end">
                    {!isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                    {isUserLoggedIn &&
                    <li><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link>
                    </li>}
                </ul>
            </nav>
        );
    }
}

export default MenuComponent