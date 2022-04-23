import React, {useReducer} from 'react';


const reducer = (prevState, action) => {
    console.log(prevState)
    const newState = {...prevState};
    switch (action.type) {
        case '+':
            newState.count++
            return newState
        case '-':
            newState.count--
            return newState
        default:
            return prevState
    }
}

const initialState = {
    count: 0
}


const ReducerHooks = () => {
    const [state, dispatch] = useReducer(reducer, initialState)

    return (
        <div>
            <button onClick={() => dispatch({
                type: '-'
            })}>-
            </button>
            {state.count}
            <button onClick={() => dispatch({
                type: '+'
            })}>+
            </button>
        </div>
    );
};

export default ReducerHooks;
