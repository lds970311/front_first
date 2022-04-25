import _ from "lodash";


const initialState = {
    show: true,
    city: "上海"
}

const cityReducer = (preState = initialState, {type, payload}) => {
    let newState = _.cloneDeep(preState)
    switch (type) {
        case "add":
            newState.show = false
            return newState
        case "changeCity":
            newState.city = "北京"
            return newState
        default:
            return preState
    }
}


export default cityReducer
