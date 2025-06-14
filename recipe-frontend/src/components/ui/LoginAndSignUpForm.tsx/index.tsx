import 'index.css';
import React, { useState } from 'react';
import { AuthRequestModel } from '../../../models/authModels/authRequestModel';

const LoginForm:React.FC=()=>{
    
    return(
        <form  className="login-form">
            <input type="text" placeholder="Enter your email" name="email" required />
            <input type="password" placeholder="Enter your password" name="password" required />
            <button type="submit">Login</button>
        </form>
    );
}