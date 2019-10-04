import React from 'react'
import AuthenticationService from "../service/AuthenticationService";

class LoginComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tenant: '',
            username: '',
            password: '',
            error: false,
            success: false
        };
        this.loginClicked = this.loginClicked.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }


    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    render() {
        return (
            <div className="container">
                <div className="form-signin">
                    <label htmlFor="tenant" className="sr-only">Tenant</label>
                    <input type="text" id="tenant" name="tenant" className="form-control" placeholder="Tenant"
                           onChange={this.handleChange} required autoFocus/>
                    <label htmlFor="username" className="sr-only">User Name</label>
                    <input type="text" id="username" name="username" className="form-control" placeholder="UserName"
                           onChange={this.handleChange} required/>
                    <label htmlFor="password" className="sr-only">Password</label>
                    <input type="password" name="password" id="password" className="form-control" placeholder="Password"
                           onChange={this.handleChange} required/>
                    <button className="btn btn-lg btn-primary btn-block" type="button" onClick={this.loginClicked}>Sign
                        in
                    </button>
                </div>
            </div>
        );
    }

    loginClicked() {
        if (this.state.username === '')
            return;
        AuthenticationService.doBasicAuth(this.state.tenant, this.state.username, this.state.password)
            .then(() => {
                AuthenticationService.registerLogin(this.state.tenant, this.state.username, this.state.password);
                this.props.history.push(`/user`)
            }).catch(() => {
            this.setState({showSuccessMessage: false});
            this.setState({hasLoginFailed: true})
        })

    }
}

export default LoginComponent
