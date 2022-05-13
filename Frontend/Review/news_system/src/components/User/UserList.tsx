import React, {useEffect, useState} from 'react';
import {DeleteOutlined, EditOutlined, ExclamationCircleOutlined} from '@ant-design/icons'
import {Button, Switch, Table, Modal} from "antd";
import axios from "axios";


const {confirm} = Modal
const UserList: React.FunctionComponent = () => {
    const [dataSource, setDataSource] = useState([])
    useEffect(() => {
        axios.get("http://localhost:3000/users?_expand=role").then((res) => {
            setDataSource(res.data);
        });
    }, [])

    const columns = [
        {
            title: "区域",
            dataIndex: "region",
            render: (region) => {
                return <b>{region === "" ? "全球" : region}</b>;
            },
        },
        {
            title: "角色名称",
            dataIndex: "role",
            render: (role) => {
                return role?.roleName;
            },
        },
        {
            title: "用户名",
            dataIndex: "username",
        },
        {
            title: "用户状态",
            dataIndex: "roleState",
            render: (roleState, item) => {
                return <Switch
                    checked={item.roleState}
                    disabled={item.default}
                    onChange={(checked) => handleSwitchChange(checked, item.id)}/>;
            },
        },
        {
            title: "操作",
            render: (item) => {
                return (
                    <div>
                        <Button
                            danger
                            shape="circle"
                            icon={<DeleteOutlined/>}
                            onClick={() => confirmMethod(item)}
                            disabled={item.default}
                        />

                        <Button
                            type="primary"
                            shape="circle"
                            icon={<EditOutlined/>}
                            disabled={item.default}
                        />
                    </div>
                );
            },
        },
    ];

    function handleSwitchChange(checked, id) {
        axios.patch(`http://localhost:3000/users/${id}`, {
            roleState: checked
        }).then(() => {
            const man = dataSource.map(item => {
                if (item.id === id) {
                    item.roleState = checked
                }
                return item
            });

            setDataSource(man)
        })
    }

    function confirmMethod(item) {
        confirm({
            title: "你确定要删除?",
            icon: <ExclamationCircleOutlined/>,
            onOk() {
                //   console.log('OK');
                deleteMethod(item);
            },
            onCancel() {
                console.log('Cancel');
            },
        });
    }

    function deleteMethod(item) {

    }

    return (
        <div>
            <Table
                dataSource={dataSource}
                columns={columns}
                pagination={{
                    pageSize: 5,
                }}
                rowKey={(item) => item.id}
            />
        </div>
    );
};

export default UserList;
