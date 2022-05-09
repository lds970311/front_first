import {createStore, combineReducers, compose, applyMiddleware} from 'redux'
import menuReducer from "./reducers/MenuReducer";
import {persistStore, persistReducer} from 'redux-persist'
import storage from 'redux-persist/lib/storage';
import autoMergeLevel2 from 'redux-persist/lib/stateReconciler/autoMergeLevel2';
import reduxThunk from 'redux-thunk'

const allReducers = combineReducers({
    menuReducer
})

const persistConfig = {
    key: 'evan',
    storage: storage,
    stateReconciler: autoMergeLevel2,

}
const myPersistReducer = persistReducer(persistConfig, allReducers)
// @ts-ignore
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(allReducers, composeEnhancers(applyMiddleware(reduxThunk)))
const ps = persistStore(store)
export {store, ps}
