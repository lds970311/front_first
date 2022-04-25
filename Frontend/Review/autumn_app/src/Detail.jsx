import React, {useEffect} from 'react';
import store from "./store";
import getDetailAction from "./store/actions/getDetailAction";
import {useRouteMatch} from "react-router-dom";

const Detail = () => {
    const match = useRouteMatch()
    console.log(match)
    useEffect(() => {
        store.dispatch({
            type: "add",
            payload: "123123"
        })
        let event = null;
        const {movieDetailReducer} = store.getState()
        console.log(movieDetailReducer)
        if (movieDetailReducer.watched === 0) {
            //取数据,异步
            event = store.dispatch(getDetailAction(match.params.id))
        } else {
            // 使用缓存
        }
        return () => {
            if (event !== null) {
                //取消订阅
                event()
            }
        }
    }, [match.params.id])

    return (
        <div>
            detail
            <p>{store.getState().cityReducer.city}</p>
        </div>
    );
};

export default Detail;
