import React, {useEffect, useRef, useState} from 'react';
import axios from "axios";

const FunctionView: React.FC = props => {
    const [name, setName] = useState<string>("evan")
    const myRef = useRef<HTMLInputElement>(null)

    useEffect(() => {
        console.log(props)
    }, [])

    function handleClick() {
        const newName = name.toUpperCase()
        setName(newName)
        console.log((myRef.current as HTMLElement).innerText)
    }

    return (
        <div>
            <button onClick={handleClick}>click me</button>
            <p ref={myRef}>{name}</p>
            <Child isShow={true}/>
        </div>
    );
};

export default FunctionView;


interface ChildProps {
    isShow: boolean;
}

const Child: React.FC<ChildProps> = (props) => {
    return (
        <div>
            {props.isShow}
        </div>
    )
}


