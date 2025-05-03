import { Cuisine } from "./enumModels/Cuisine";
import { UserModel } from "./UserModel";

export interface RecipeModel{
    recipeId: number;
    recipeName: string;
    user: UserModel;
    noOfServings: number;
    ingridients: Record<string, number>; // HashMap<String, Integer> equivalent
    rating: number;
    dateTime: string; // ISO date string
    steps: string[];
    publicID: string;
    imageUrl: string;
    cuisine: Cuisine;
}