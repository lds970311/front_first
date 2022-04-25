import {createStore, combineReducers, applyMiddleware, compose} from 'redux'
import cityReducer from "./reducers/DetailReducer";
import movieDetailReducer from "./reducers/MovieDetailReducer";
import reduxThunk from 'redux-thunk'
import {persistStore, persistReducer} from 'redux-persist'
import storage from 'redux-persist/lib/storage';
import autoMergeLevel2 from 'redux-persist/lib/stateReconciler/autoMergeLevel2';


const persistConfig = {
    key: 'evan',
    storage: storage,
    //localStorage: import storage from 'redux-persist/lib/storage'
    // sessionStorage: import storageSession from 'redux-persist/lib/storage/session'
    stateReconciler: autoMergeLevel2,
    //控制在本地存储中，新老状态怎么合并，覆盖？或者合并？
    // blacklist:[]
}

const reducer = combineReducers({
    cityReducer,
    movieDetailReducer
})
const myPersistReducer = persistReducer(persistConfig, reducer)

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(myPersistReducer, composeEnhancers(applyMiddleware(reduxThunk)))
const ps = persistStore(store)

export {store, ps}
