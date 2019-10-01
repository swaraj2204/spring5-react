import * as React from 'react'
import Login from "./Login";

export default class HomePage extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            loggedIn:false,
            tenant:""
        }


    }

    componentDidMount() {
       let loggedIn= sessionStorage.getItem('loggedin') === 'true';
       this.setState({loggedIn:loggedIn})
    }

    handleLogin(tenant) {
        this.setState({tenant: tenant})

    }


    render() {
        let data = this.state;
        return (
            <div>
                {(data.loggedIn) ? (<Login handleLogin={this.handleLogin.bind(this)}/>) : ("WelCome Message")}
            </div>

        )
    }
}
