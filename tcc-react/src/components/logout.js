import React from 'react';
import { GoogleLogout }  from "react-google-login";

const clientId = '308424476532-e40blk46kh67iussdbce2655m9lnacoq.apps.googleusercontent.com'

function Logout(){

    const onSuccess = (res) => {
        console.log("Logout realizado com sucesso!");
    };


    return (
        <div id={"signOutButton"}>
            <GoogleLogout
                clientId={clientId}
                buttonText={"Logout"}
                onLogoutSuccess={onSuccess}
            ></GoogleLogout>
        </div>

    );
}

export default Logout;