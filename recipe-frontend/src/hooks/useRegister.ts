import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { UserModel } from "../models/UserModel";

export function RegisterHooks(user:UserModel){
    const navigate = useNavigate();
    const[isLoggedIn,setLoggedIn] = useState(false);
    useEffect(()=>{
        if(user!=null){
            
        }
    },[user,navigate]);
}