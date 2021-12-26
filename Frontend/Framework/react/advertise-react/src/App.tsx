import React from 'react';
import {HashRouter, Route, Routes} from 'react-router-dom'
import Home from "./views/Home/Home"

const App: React.FunctionComponent = () => {
    return (
        <HashRouter>
            <Routes>
                <Route path="/" element={<Home/>}/>
            </Routes>
        </HashRouter>
    );
};

export default App;
