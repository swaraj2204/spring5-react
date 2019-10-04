import React from 'react'
import IndianUser from "./IndianUser";
import SriLankaUser from "./SriLankaUser";

const UserWrapper = () => {

    const renderUser = () => {
        switch (sessionStorage.getItem("tenant")) {
            case "t1":
                return <IndianUser/>;
            case "t2":
                return <SriLankaUser/>;
            default:
                return <IndianUser/>
        }
    };

    return (
            <div>
                {renderUser()}
            </div>
        );
};

export default UserWrapper;
