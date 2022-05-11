import React, {useState} from 'react';
import {Layout, Menu, MenuProps} from 'antd';
import "./index.scss"
import {useNavigate} from 'react-router-dom'
import {useSelector} from "react-redux";
import {getItem} from "../../utils/menuUtils";
import useAxios from "../../hooks/useAxios";
import {useLocation} from 'react-router-dom'
import {
    UserOutlined,
    AppstoreOutlined,
    BuildOutlined,
    ContainerOutlined,
    DesktopOutlined,
    FolderOutlined,
    LinkOutlined,
    OneToOneOutlined, ToTopOutlined

} from '@ant-design/icons';

const {Sider} = Layout;
type MenuItem = Required<MenuProps>['items'][number];

interface Icon {
    [key: string]: React.ReactNode;
}

const iconList: Icon = {
    "/home": <UserOutlined/>,
    "/user-manage": <AppstoreOutlined/>,
    "/user-manage/list": <BuildOutlined/>,
    "/right-manage": <ContainerOutlined/>,
    "/right-manage/role/list": <DesktopOutlined/>,
    "/right-manage/right/list": <FolderOutlined/>,
    "/news-manage": <LinkOutlined/>,
    "/audit-manage": <OneToOneOutlined/>,
    "/publish-manage": <ToTopOutlined/>
    //.......
}

const SideMenu: React.FunctionComponent = () => {
    // @ts-ignore
    const {isCollapsed} = useSelector(state => state.menuReducer)
    const location = useLocation()
    const navigate = useNavigate()
    const {loading, data} = useAxios("http://localhost:3000/rights?_embed=children", 'get')
    let newItem: MenuItem[] = []
    if (!loading) {
        newItem = renderMenu(data)
    }

    function renderMenu(data) {
        return data.map(item => {
            if (item.children && item.children.length !== 0) {
                return checkPagePermission(item) && getItem(item.title, item.key, iconList[item.key], renderMenu(item.children))
            }
            return checkPagePermission(item) && getItem(item.title, item.key, iconList[item.key])
        })
    }


    function handleClick({item, key, keyPath, domEvent}) {
        console.log(key)
        navigate(key, {replace: true})
    }

    function checkPagePermission(item): boolean {
        return item.pagepermisson === 1
    }

    return (
        <Sider trigger={null} collapsible collapsed={isCollapsed}>
            {isCollapsed ? null : (<div className="logo">新闻发布管理系统</div>)}
            <Menu
                selectedKeys={["/" + location.pathname.split("/")[1]]}
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
