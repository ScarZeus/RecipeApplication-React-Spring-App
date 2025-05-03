import { FollowingModel } from "./FollowingModel";

export interface UserModel{
    userId:Number;
    userName:String;
    emailId?:String;
    password?:String;
    imageUrl?:String;
    imagePublicID?:String;
    followers?:FollowingModel[];
    following?:FollowingModel[];
}