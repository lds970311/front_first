//CREATE AT: 2021-12-16
export interface MenuItem {
    icon?: string,
    i?: string,
    name: string, //导航名称
    index: string //导航标识
    children?: MenuItem[] //子菜单
}
