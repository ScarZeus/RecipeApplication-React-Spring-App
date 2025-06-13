import { useState } from "react";
import { AuthRequestModel } from "../models/authModels/authRequestModel";

export function useLogin(){
    const[loading,setLoading] = useState(false);
    const[error,setError] = useState(null);
    const Login = async (authdata:AuthRequestModel) => {
        try{
            setLoading(true);
            setError(null);
            const jwtToken = await 
        }


    }
}