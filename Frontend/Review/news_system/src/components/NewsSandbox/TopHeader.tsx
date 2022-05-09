import React, {useState} from 'react';
import {Avatar, Dropdown, Layout, Menu, Space} from 'antd'
import {useSelector, useDispatch} from 'react-redux'
import {collapsedAction} from "../../store/actions/MenuAction"
import {DownOutlined, SmileOutlined} from '@ant-design/icons';
import {
    MenuUnfoldOutlined,
    MenuFoldOutlined,
} from '@ant-design/icons';

const {Header} = Layout;


const TopHeader = () => {
    // @ts-ignore
    const {isCollapsed} = useSelector(state => state.menuReducer)
    const dispatch = useDispatch()

    function toggle() {
        dispatch(collapsedAction(!isCollapsed))
    }

    // @ts-ignore
    const menu = (
        <Menu
            items={[
                {
                    label: '3rd menu item（disabled）',
                    key: '3',
                    disabled: true,
                },
            ]}
        />
    );
    return (

        <Header className="site-layout-background" style={{padding: 0}}>
            {React.createElement(isCollapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
                className: 'trigger',
                onClick: toggle,
            })}
            <div style={{float: 'right', marginRight: '24px'}}>
                <span>欢迎xxx回来</span>
                <Dropdown overlay={menu} arrow={false}>

                    <a onClick={e => e.preventDefault()}>
                        <Avatar src="https://joeschmoe.io/api/v1/random"/>
                        <Space>
                            管理员
                        </Space>
                    </a>
                </Dropdown>
            </div>
        </Header>

    );
};

export default TopHeader;
