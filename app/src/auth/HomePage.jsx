import * as React from 'react'
import Login from "./Login";

export default class HomePage extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            loggedIn: false
        }

    }

    componentDidMount() {

    }

    handleLogin(isLoggedIn) {
        this.setState({loggedIn: isLoggedIn})

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
