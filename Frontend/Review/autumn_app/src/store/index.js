import {createStore, combineReducers, applyMiddleware, compose} from 'redux'
import cityReducer from "./reducers/DetailReducer";
import movieDetailReducer from "./reducers/MovieDetailReducer";
import reduxThunk from 'redux-thunk'

/*const initialState = {
    show: true,
    city: "上海"
}


const reducer = (preState = initialState, {type, payload}) => {
    let newState = _.cloneDeep(preState)
    console.log(payload)
    console.log(newState)
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
}*/


const reducer = combineReducers({
    cityReducer,
    movieDetailReducer
})

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(reducer, composeEnhancers(applyMiddleware(reduxThunk)))


export default store
