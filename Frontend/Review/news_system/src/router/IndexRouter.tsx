import React, {Suspense} from 'react';
import {HashRouter, Routes, Route} from 'react-router-dom'
import {Spin} from 'antd';
import NotFound from "../views/NotFound";
import AutoRoute from "../utils/AuthRoute"
import Home from "../components/Home/Home";
import RightManage from "../components/Right/RightManage";
import RoleManage from "../components/Right/RoleManage";
import UserList from "../components/User/UserList";

const Login = React.lazy(() => import('../views/Login'))
const NewsSandbox = React.lazy(() => import('../views/NewsSandbox'))


const Loading = () => {
    return (
        <div style={{
            margin: '0 auto',
            textAlign: 'center',
            background: 'rgba(0, 0, 0, 0.05)',
            borderRadius: '4px',
            height: '100vh',
            lineHeight: '100vh'
        }}>
            <Spin size="large"/>
        </div>
    );
};


const IndexRouter = () => {
    return (
        <HashRouter>
            <Suspense fallback={<Loading/>}>
                <Routes>
                    <Route path="/" element={<AutoRoute>
                        <NewsSandbox/>
                    </AutoRoute>}>
                        <Route path="home" element={<Home/>}/>
                        <Route path="right-manage/role/list" element={<RoleManage/>}/>
                        <Route path="right-manage/right/list" element={<RightManage/>}/>
                        <Route path="user-manage/list" element={<UserList/>}/>
                    </Route>
                    <Route path='/login' element={<Login/>}/>
                    <Route path="*" element={<NotFound/>}/>
                </Routes>
            </Suspense>
        </HashRouter>

    );
};

export default IndexRouter;
