import React from 'react';
import "../styles/newsSandbox.scss"
import SideMenu from '../components/NewsSandbox/SideMenu'
import TopHeader from '../components/NewsSandbox/TopHeader'
import {Layout} from 'antd'
import {Outlet} from 'react-router-dom'

const {Content} = Layout

const NewsSandbox = () => {
    return (
        <Layout>
            <SideMenu/>
            <Layout className="site-layout">
                <TopHeader/>
                <Content
                    className="site-layout-background"
                    style={{
                        margin: '24px 16px',
                        padding: 24,
                        minHeight: 280,
                    }}
                >
                    <Outlet/>
                </Content>
            </Layout>

        </Layout>
    );
};

export default NewsSandbox;
