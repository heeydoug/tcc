import React from 'react';
import { GoogleLogin } from "react-google-login";

const clientId = '308424476532-e40blk46kh67iussdbce2655m9lnacoq.apps.googleusercontent.com'

function Login(){

    const onSuccess = (res) => {
        console.log("Login realizado com sucesso! Usuário atual: ", res.profileObj);
    };

    const onFailure = (res) => {
        console.log("Falha ao realizar login! res: ", res);
    };

    return(
        <div id="signInButton">
            <GoogleLogin
                clientId={clientId}
                buttonText={"Login"}
                onSuccess={onSuccess}
                onFailure={onFailure}
                cookiePolicy={'single_host_origin'}
                isSignedIn={true}
            ></GoogleLogin>
        </div>
    )
}

export default Login;