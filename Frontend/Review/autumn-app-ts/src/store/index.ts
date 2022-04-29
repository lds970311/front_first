import {createStore, combineReducers, applyMiddleware} from 'redux'
import MyReducer from "./reducers/MyReducer";
import createSagaMiddleware from 'redux-saga'
import watchSaga from "./saga/watchSaga";

const sagaMiddleware = createSagaMiddleware()

const allReducers = combineReducers({
    MyReducer
})

const store = createStore(allReducers, applyMiddleware(sagaMiddleware))
sagaMiddleware.run(watchSaga) //任务

export default store
