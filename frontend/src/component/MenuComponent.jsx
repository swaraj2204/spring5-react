import React from 'react'
import AuthenticationService from "../service/AuthenticationService";
import {Link} from "react-router-dom";

const MenuComponent = (props) => {

    const doLogout = () => {
        AuthenticationService.logout();
        props.handleLoginState(false);
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top sticky-top">
            <ul className="navbar-nav">
                <li><Link className="nav-link" to="/user">User</Link></li>
            </ul>
            <ul className="navbar-nav navbar-collapse justify-content-end">
                <li>
                    {props.isLoggedIn ?
                        <Link className="nav-link" to="/logout" onClick={doLogout}>Logout</Link>
                        :
                        <Link className="nav-link" to="/login">Login</Link>
                    }
                </li>
            </ul>
        </nav>
    );
};

export default MenuComponent