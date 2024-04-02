import { createSlice } from "@reduxjs/toolkit";
import { fetchAllUsers } from "./user.service";
import { initialState } from "./user.init";

const userThunks = [fetchAllUsers]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handleFulfilled = (state:any, {payload}:any)=>{
    console.log('-------------')
    state.array= payload
    console.log(state.array)
}

const handlePending = (state: any) => {
}

const handleRejected = (state: any) => {
}


export const userSlice = createSlice({
    name: "users",
    initialState,
    reducers: {},
    extraReducers:builder => {
        const {pending, rejected} = status;
        builder
        .addCase(fetchAllUsers.fulfilled, handleFulfilled)
    }

})
export const getAllUsers = (state: any) => {
    console.log('------------------ Before useSelector ---------------')
    console.log(JSON.stringify(state.user.array.result))
    return state.user.array.result;
}


export const {} = userSlice.actions

export default userSlice.reducer