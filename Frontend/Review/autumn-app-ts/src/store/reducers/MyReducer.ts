import {Reducer} from 'redux'

interface State {
    name: string,
    age: number,
    data?: Array<any>
}

const initalState: State = {age: 21, name: "evan"}


const MyReducer: Reducer<State, Action> = (preState = initalState, action) => {
    const {type, payload} = action
    const newState: State = {...preState}
    switch (type) {
        case "a":
            newState.age++
            return newState
        case 'list':
            newState.data = payload
            return newState
        default:
            return preState
    }
}

export default MyReducer
