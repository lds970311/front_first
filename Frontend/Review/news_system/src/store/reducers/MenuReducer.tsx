import {Reducer} from 'redux'

interface IState {
    isCollapsed: boolean
}


const initialState: IState = {
    isCollapsed: true
}

const menuReducer: Reducer<IState, IAction> = (preState = initialState, action) => {
    const currentState: IState = {...preState}
    const {type, payload} = action
    switch (type) {
        case "changeCollapsed":
            currentState.isCollapsed = payload
            return currentState
        default:
            return preState
    }
}


export default menuReducer
