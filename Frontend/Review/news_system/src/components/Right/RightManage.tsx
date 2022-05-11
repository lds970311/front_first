import React, {useEffect, useState} from 'react';
import {Table, Tag, Space, Button, Modal} from 'antd';

import {ExclamationCircleOutlined} from '@ant-design/icons'
import axios from "axios";

const {confirm} = Modal;

const RightManage = () => {
    const [data, setData] = useState([])
    useEffect(() => {
        axios.get("http://localhost:3000/rights?_embed=children")
            .then(res => {
                res.data[0].children = ""
                setData(res.data)
            })
    }, [data])

    const [update, setUpdate] = useState(false)


    const columns = [
        {
            title: 'Id',
            dataIndex: 'id',
            key: 'name'
        },
        {
            title: '权限名称',
            dataIndex: 'title',
            key: 'title',
        },
        {
            title: '路径',
            dataIndex: 'key',
            render: key => {
                return (
                    <Tag color='orange'>{key}</Tag>
                )
            }
        },
        {
            title: '操作',
            key: 'action',
            render: (item) => (
                <Space size="middle">
                    <Button
                        type="primary"
                        onClick={() => editRight(item)}
                        size={"small"}
                        disabled={!item.pagepermisson}
                    >编辑</Button>
                    <Button
                        danger
                        type="primary"
                        onClick={() => deleteRight(item)}
                        size={"small"}
                    >删除</Button>
                </Space>
            ),
        },
    ];

    function deleteRight(item) {
        confirm({
            title: '确认提示框',
            icon: <ExclamationCircleOutlined/>,
            content: '确认删除该权限?',
            onOk() {
                console.log('OK');
                if (item.grade === 1) {
                    setUpdate(!update)
                    axios.delete(`http://localhost:3000/rights/${item.id}`)
                        .then(res => {
                            console.log("delete success")
                        }).catch(err => {
                        console.log(err)
                    })
                } else {
                    console.log(item)
                    setUpdate(!update)
                    axios.delete(`http://localhost:3000/children/${item.id}`)
                        .then(res => {
                            console.log("delete success")

                        }).catch(err => console.log(err))
                }

            },
            onCancel() {
                console.log('Cancel');
            },
        });
    }

    function editRight(item) {

    }


    return (
        <div>
            <Table columns={columns} dataSource={data}
                   pagination={{
                       pageSize: 5
                   }}
            />
            <div style={{display: 'none'}}>{update}</div>
        </div>
    );
};

export default RightManage;
