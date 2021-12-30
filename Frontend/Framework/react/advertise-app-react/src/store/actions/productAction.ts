import ActionTypes from "../constants/action-types";
import {Action} from "../../@types"
import {Product} from "../../@types";

export const setProduct = (product: Product): Action => {
    return {
        type: ActionTypes.SET_PRODUCTS,
        payload: product
    }
}

export const selectProduct = (product: Product): Action => {
    return {
        type: ActionTypes.SELECTED_PRODUCTS,
        payload: product
    }
}
