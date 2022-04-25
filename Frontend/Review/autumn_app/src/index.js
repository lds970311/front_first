import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
import App from './App';
import {store, ps} from './store';
import {Provider} from 'react-redux'

import {PersistGate} from "redux-persist/integration/react";

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <PersistGate loading={null} persistor={ps}>
                <App/>
            </PersistGate>

        </Provider>
    </React.StrictMode>,
    document.getElementById('root')
);

