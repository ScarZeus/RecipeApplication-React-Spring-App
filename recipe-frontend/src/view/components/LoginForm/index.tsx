import React from "react";
import { AuthRequestModel } from '../../../models/authModels/authRequestModel';
import './index.css';

const LoginForm:React.FC=()=>{

    // const[authRequest,setauthRequest] = useState<AuthRequestModel>({
    //     email:'',
    //     password:''
    // });
    // const[sumbit,setSubmit] = useState();
    // function handleFormSubmit(event:React.FormEvent<HTMLFormElement>){
    //     event.preventDefault();
    //     const formData = new FormData(event.currentTarget);
    //    const data: { [key: string]: string } = {};

       
    // formData.forEach((value, key) => {
    //     data[key] = value.toString(); // You can customize type as needed
    // });
        // setauthRequest(data);

    return(
        <div className='form-container'>
            <h2>Login</h2>
            <form> 
                <input type="text" name="emailId" id="emailId" placeholder="Enter your user emailID"/>
                <input type = "password" name="password" id="password" placeholder="Enter your Password" />
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;