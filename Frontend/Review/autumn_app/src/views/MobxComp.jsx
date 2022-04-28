import React, {useEffect} from 'react';
import myMobx from '../mobx/index'
import {Observer} from "mobx-react";
/*
const value = observable.box(0);
const number = observable.box(100);
const map = observable.map({
    name: "evan"
})
const list = observable([1, 2, 3, 4])

autorun(() => {
    console.log("value changed", value.get())
})

autorun(() => {
    console.log("number changed", number.get())
})

autorun(() => {
    console.log("map changed", map.get("name"))
})
autorun(() => {
    console.log("list changed", list.at(0))
})

setTimeout(() => {
    value.set(10)
    map.set("name", 'ceiling')
    list.push(1, 2, 3)
}, 1000)
*/


const MobxComp = props => {
    useEffect(() => {
        console.log(props)
    }, [props])
    return (
        <Observer>
            {
                () => {
                    return (
                        <div>
                            <p>
                                <span>name</span>
                                <button onClick={myMobx.changeName}>{myMobx.name}</button>
                            </p>
                            <p>
                                <span>num</span>
                                <button onClick={myMobx.changeNum}>{myMobx.num}</button>
                            </p>
                            <div>
                                <button onClick={myMobx.getDataList}>获取数据</button>
                                <ul>
                                    {myMobx.list.map((item, index) => {
                                        return (
                                            <li key={index}>
                                                {item}
                                            </li>
                                        )
                                    })}
                                </ul>
                            </div>
                        </div>
                    )
                }
            }

        </Observer>

    );
}


export default MobxComp;


