import React, {useState} from 'react';
import {Layout, Menu, MenuProps} from 'antd';
import "./index.scss"
import {useNavigate} from 'react-router-dom'
import {useSelector} from "react-redux";
import {getItem} from "../../utils/menuUtils";
import useAxios from "../../hooks/useAxios";

const {Sider} = Layout;
type MenuItem = Required<MenuProps>['items'][number];

const SideMenu: React.FunctionComponent = () => {
    // @ts-ignore
    const {isCollapsed} = useSelector(state => state.menuReducer)
    const navigate = useNavigate()
    const {loading, data} = useAxios("http://localhost:3000/rights?_embed=children", 'get')
    let newItem: MenuItem[] = []
    if (!loading) {
        newItem = renderMenu(data)
    }

    function renderMenu(data) {
        return data.map(item => {
            if (item.children && item.children.length !== 0) {
                return getItem(item.title, item.key, null, renderMenu(item.children))
            }
            return getItem(item.title, item.key, null)
        })
    }


    function handleClick({item, key, keyPath, domEvent}) {
        console.log(key)
        navigate(key, {replace: true})
    }

    return (
        <Sider trigger={null} collapsible collapsed={isCollapsed}>
            {isCollapsed ? null : (<div className="logo">新闻发布管理系统</div>)}
            <Menu
                defaultSelectedKeys={['1']}
                defaultOpenKeys={['/home']}
                mode="inline"
                theme="dark"
                items={newItem}
                onClick={handleClick}
            />
        </Sider>
    );
};

export default SideMenu;
