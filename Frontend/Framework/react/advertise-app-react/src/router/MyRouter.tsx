import React, {Component} from 'react';
import {HashRouter, Route, Routes} from "react-router-dom";
import Home from "../views/Home/Home";

class MyRouter extends Component {
    render() {
        return (
            <div>
                <HashRouter>
                    <Routes>
                        <Route path="/" element={<Home/>}/>
                    </Routes>
                </HashRouter>
            </div>
        );
    }
}

export default MyRouter;
