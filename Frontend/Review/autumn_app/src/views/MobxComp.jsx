import React from 'react';
import {observable, autorun} from 'mobx';

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

const MobxComp = () => {
    return (
        <div>
            mobx
        </div>
    );
};

export default MobxComp;
