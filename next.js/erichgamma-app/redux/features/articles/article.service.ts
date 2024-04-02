import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllArticlesAPI } from "./article.api";


export const fetchAllArticles: any =createAsyncThunk('articles/fetchAllArticles',
async(page:number, {rejectWithValue})=>{
    console.log('fetchAllArticles page:'+ page)
    
    const data:any = await  getAllArticlesAPI(1);

        const {message, result}:any = data
        // console.log('----- API 를 사용한 경우 -----')
        // console.log('message : '+ message)
        // console.log(JSON.stringify(result))
        return data
}
)