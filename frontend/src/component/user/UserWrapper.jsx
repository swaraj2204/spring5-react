import React from 'react'
import IndianUser from "./IndianUser";
import SriLankaUser from "./SriLankaUser";


export default class UserWrapper extends React.Component {
    constructor(props) {
        super(props);
        let userId = sessionStorage.getItem('user');
        let tenantId = sessionStorage.getItem('tenant');
        this.state = {
            user: userId,
            tenant: tenantId,

        }
        this.renderUser = this.renderUser.bind(this);
    }

    componentDidMount() {
    }

    renderUser() {
        switch (this.state.tenant) {
            case "t1":
                return <IndianUser/>;
            case "t2":
                return <SriLankaUser/>;
            default:
                return <IndianUser/>
        }
    }

    render() {
        return (
            <div>
                {this.renderUser()}
            </div>
        );
    }
}
