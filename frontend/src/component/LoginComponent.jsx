import React, {useState} from 'react'
import AuthenticationService from "../service/AuthenticationService";

const Login = (props) => {

    const [tenant, setTenant] = useState('');
    const [username, setUserName] = useState('');
    const [password, setPassword] = useState('');

    const handleChange = (event) => {
        console.log(event.target.name)
        switch (event.target.name) {
            case "tenant":
                setTenant(event.target.value)
                break;
            case "password":
                setPassword(event.target.value)
                break;
            default:
                setUserName(event.target.value)
                break;
        }
    };

    const loginClicked = () => {
        if (username === '') return;

        AuthenticationService.doBasicAuth(tenant, username, password)
            .then(() => {
                AuthenticationService.registerLogin(tenant, username, password);
                props.handleLoginState(true);
                props.history.push(`/user`);
            }).catch((x) => {
            console.log(x);
        })
    };

    return (
        <div className="container">
            <div className="form-signin">
                <label htmlFor="tenant" className="sr-only">Tenant</label>
                <input type="text" id="tenant" name="tenant" className="form-control" placeholder="Tenant"
                       onChange={handleChange} required autoFocus/>
                <label htmlFor="username" className="sr-only">User Name</label>
                <input type="text" id="username" name="username" className="form-control" placeholder="UserName"
                       onChange={handleChange} required/>
                <label htmlFor="password" className="sr-only">Password</label>
                <input type="password" name="password" id="password" className="form-control" placeholder="Password"
                       onChange={handleChange} required/>
                <button className="btn btn-lg btn-primary btn-block" type="submit" onClick={loginClicked}>
                    Sign in
                </button>
            </div>
        </div>
    );
};

export default Login;
