import React, {useCallback, useMemo, useRef, useState} from 'react';

const MemoryHooks = () => {
    const [myname, setName] = useState("kerwin");
    const [text, setText] = useState("");
    const [list, setList] = useState(["aa", "bb", "cc"]);
    const myRef = useRef(null);

    const handleChange = useCallback((evt) => {
        // console.log("handleChange",evt.target.value)

        setText(evt.target.value);
    }, []);

    const handleAdd = useMemo(() => () => {
        console.log(myRef.current)

        // list.push("")
        setList([...list, text]);

        //情况
        setText("");
    }, [text, list]);

    const handleDel = useCallback(
        (index) => {
            console.log(index);
            const newList = [...list];
            newList.splice(index, 1);
            setList(newList);
        },
        [list]
    );
    return (
        <div>
            {myname} -{" "}
            <button
                onClick={() => {
                    setName("xiaomng");
                }}
            >
                change-myname
            </button>
            <input onChange={handleChange} value={text}/>
            <button onClick={handleAdd}>add</button>
            <ul ref={myRef}>
                {list.map((item, index) => (
                    <li key={index}>
                        {item}
                        <button onClick={() => handleDel(index)}>del</button>
                    </li>
                ))}
            </ul>
            {!list.length && <div>暂无待办事项</div>}
        </div>
    );
};

export default MemoryHooks;
