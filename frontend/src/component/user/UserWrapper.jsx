import React from 'react'
import IndianUser from "./IndianUser";
import SriLankaUser from "./SriLankaUser";


export default class UserWrapper extends React.Component {
    constructor(props){
        super(props);
        let  userId= sessionStorage.getItem('user')
        let tenantId=sessionStorage.getItem('tenant');
        this.state={
            user:userId,
            tenant:tenantId,

        }
    }
    componentDidMount() {
    }

    render() {
        let tenant=this.state.tenant;
        return (
            <div>
                {(tenant==='t1')?(<IndianUser/>):(<SriLankaUser/>)}
            </div>
        );
    }
}
