import * as React from 'react'

class Login extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            tenant:""
        }

    }

    componentDidMount() {

    }

    // setTenant(e){
    //     this.props.handleLogin(e.target.value);
    // }

    render() {
        return (
                <form className="form-signin" method="post" action="/login">
                    <h2 className="form-signin-heading">Please sign in</h2>
                    <p>
                        <label htmlFor="tenant" className="sr-only">Username</label>
                        <input type="text" id="tenant" name="tenant" className="form-control" placeholder="tenant"
                               required autoFocus/>
                    </p>
                    <p>
                        <label htmlFor="username" className="sr-only">Username</label>
                        <input type="text" id="username" name="username" className="form-control" placeholder="Username"
                               required autoFocus/>
                    </p>
                    <p>
                        <label htmlFor="password" className="sr-only">Password</label>
                        <input type="password" id="password" name="password" className="form-control"
                               placeholder="Password" required/>
                    </p>
                    <button className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>


        )
    }

}

export default (Login);