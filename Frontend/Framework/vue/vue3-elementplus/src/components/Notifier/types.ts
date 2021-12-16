//CREATE AT: 2021-12-15
interface Content {
    title: string,
    time: string,
    avatar: string,
    tag?: string,
    desc?: string,
    tagType?: '' | 'success' | 'info' | 'warning' | 'danger'
}

export interface ListItem {
    avatar?: string
    title?: string
    desc?: string,
    time?: string,
    tag?: string,
    tagType?: '' | 'success' | 'info' | 'warning' | 'danger'
    content: Content[]
}

export interface ListOptions {
    title: string,
    content: ListItem[]
}

//操作选项
export interface ActionOptions {
    text: string,
    icon?: string
}
