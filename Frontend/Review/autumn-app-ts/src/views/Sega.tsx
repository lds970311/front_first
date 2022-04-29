import React, {useEffect} from 'react';
import {useSelector, useDispatch} from 'react-redux'
import MyAction from "../store/actions/MyAction";
import watchSaga from "../store/saga/watchSaga";

const Sega = () => {
    //@ts-ignore
    const selector = useSelector(state => state.MyReducer)
    const dispatch = useDispatch()
    useEffect(() => {
        console.log(selector)
    }, [selector])
    return (
        <div>
            <p>{selector.age}</p>
            <p>{selector.name}</p>
            <button onClick={() => {
                dispatch(MyAction(123))
                watchSaga()
            }}>click change
            </button>
        </div>
    );
};

export default Sega;
