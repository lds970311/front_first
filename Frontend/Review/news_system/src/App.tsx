import React, {Fragment} from 'react';
import 'antd/dist/antd.css';
import IndexRouter from "./router/IndexRouter";
import {store, ps} from "./store";
import {Provider} from 'react-redux'

function App() {
    return (
        <Provider store={store}>
            <Fragment>
                <IndexRouter/>
            </Fragment>
        </Provider>

    );
}

export default App;
