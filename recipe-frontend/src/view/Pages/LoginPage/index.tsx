import React from "react";
import LoginForm from "../../components/LoginForm";
import './index.css';


const Login:React.FC=()=>{
    return(
        <div className="login-page">
            <div className="form-container">
                <LoginForm />
            </div>
        </div>
    );
}
export default Login;