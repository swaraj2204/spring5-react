import React from 'react'
import AuthenticationService from "../service/AuthenticationService";
import {Link} from "react-router-dom";

class MenuComponent extends React.Component {

    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return(
          <header>
              <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                  <ul className="navbar-nav">
                      <li><Link className="nav-link" to="/user">Courses</Link></li>
                  </ul>
                  <ul className="navbar-nav navbar-collapse justify-content-end">
                      {!isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                      {isUserLoggedIn && <li><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                  </ul>
              </nav>
          </header>
        );
    }
}

export default MenuComponent