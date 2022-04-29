import React from 'react';
import IndexRouter from "./router/index"
import {Provider} from 'react-redux'
import store from "./store";

function App() {
    return (
        <div className="App">
            <Provider store={store}>
                <IndexRouter/>
            </Provider>
        </div>
    );
}

export default App;
