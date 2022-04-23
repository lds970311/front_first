import React, {useState, useEffect} from 'react';
import PropTypes from "prop-types";

const StateHooks = () => {
    const [title, setTitle] = useState("title")
    const [name, setName] = useState("evan")
    useEffect(() => {
        const newName = name.toUpperCase()
        setName(newName)
    }, [name])
    return (
        <div>
            <button onClick={() => {
                setTitle("hehe")
                setName("lee")
            }}>switch title
            </button>
            <p>{title}</p>
            <p>{name}</p>
        </div>
    );
};


export default StateHooks;

