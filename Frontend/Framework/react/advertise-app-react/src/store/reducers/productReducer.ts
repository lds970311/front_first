import {Action} from "../../@types"
import ActionTypes from "../constants/action-types";

const initialState = {
    products: []
}
export const ProductReducer = (state = initialState, action: Action) => {
    switch (action.type) {
        case ActionTypes.SET_PRODUCTS:
            return {...state, products: action.payload};
        default:
            return state
    }
}
