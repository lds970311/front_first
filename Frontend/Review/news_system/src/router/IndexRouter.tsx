import React, {Suspense} from 'react';
import {HashRouter, Routes, Route} from 'react-router-dom'
import {Spin} from 'antd';
import NotFound from "../views/NotFound";
import AutoRoute from "../utils/AuthRoute"

const Login = React.lazy(() => import('../views/Login'))
const NewsSandbox = React.lazy(() => import('../views/NewsSandbox'))

const IndexRouter = () => {
    return (
        <HashRouter>
            <Suspense fallback={<Spin size="large"/>}>
                <Routes>
                    <Route path="/" element={<AutoRoute>
                        <NewsSandbox/>
                    </AutoRoute>}/>
                    <Route path='/login' element={<Login/>}/>
                    <Route path="*" element={<NotFound/>}/>
                </Routes>
            </Suspense>
        </HashRouter>

    );
};

export default IndexRouter;
