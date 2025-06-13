import React, { useState } from "react";
import { AuthRequestModel } from '../models/authModels/authRequestModel';

const Login:React.FC=()=>{
    const[authRequest,setauthRequest] = useState<AuthRequestModel>({
        email:'',
        password:''
    });
    const[sumbit,setSubmit] = useState();
    function handleFormSubmit(event:React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        const formData = new FormData(event.currentTarget);
       const data: { [key: string]: string } = {};

       
    formData.forEach((value, key) => {
        data[key] = value.toString(); // You can customize type as needed
    });
        setauthRequest(data);

    }
    return(
        <div className="login-page">
            <div className="form-container">
            <form onSubmit={handleFormSubmit}></form>
             <input type = "text" placeholder="Enter the username"/>
             <input type = "password" placeholder="Enter the password" />
             <button type="submit">login</button>
            </div>
        </div>
    );
}