import { UserModel } from "./UserModel";

export interface FollowingModel{
    id:Number;
    follower:UserModel;
    following:UserModel;
}