import React, {useEffect, useState} from 'react';
import {Button, Modal, Table, Tree} from "antd";
import {DeleteOutlined, EditOutlined, ExclamationCircleOutlined} from '@ant-design/icons'
import axios from "axios";

const {confirm} = Modal

const RoleManage = () => {
    const [update, setUpdate] = useState(false)
    const [dataSource, setDataSource] = useState([])
    const [rightList, setRightList] = useState([])
    const [currentRights, setCurrentRights] = useState([])
    const [currentId, setCurrentId] = useState(0)
    const [isModalVisible, setIsModalVisible] = useState(false)
    const [expandedKeys, setExpandedKeys] = useState<React.Key[]>(['0-0-0', '0-0-1']);
    const [autoExpandParent, setAutoExpandParent] = useState<boolean>(true);
    useEffect(() => {
        axios.get("http://localhost:3000/roles")
            .then(res => setDataSource(res.data))
    }, [])
    useEffect(() => {
        axios.get("http://localhost:3000/rights?_embed=children").then(res => {
            // console.log(res.data)
            setRightList(res.data)
        })
    }, [])

    function confirmMethod(item): void {
        confirm({
            title: '你确定要删除?',
            icon: <ExclamationCircleOutlined/>,
            onOk() {
                deleteMethod(item)
            },
            onCancel() {
                console.log('Cancel');
            },
        });
    }


    const deleteMethod = (item) => {
        const newData = dataSource.filter(data => data.id !== item.id);
        setDataSource(newData)
        axios.delete(`http://localhost:3000/roles/${item.id}`)
            .then(res => {
                setUpdate(!update)
            }).catch(err => console.log(err))
    }

    const columns = [
        {
            title: 'ID',
            dataIndex: 'id',
            render: (id) => {
                return <b>{id}</b>
            }
        },
        {
            title: '角色名称',
            dataIndex: 'roleName'
        },
        {
            title: "操作",
            render: (item) => {
                return <div>
                    <Button danger shape="circle" icon={<DeleteOutlined/>} onClick={() => confirmMethod(item)}/>
                    <Button type="primary" shape="circle" icon={<EditOutlined/>} onClick={() => {
                        setIsModalVisible(true)
                        setCurrentRights(item.rights)
                        setCurrentId(item.id)
                    }}/>
                </div>
            }
        }
    ]

    function handleOk() {
        axios.patch(`http://localhost:3000/roles/${currentId}`, {
            rights: currentRights
        }).then(res => {
            setIsModalVisible(false)
        }).catch(err => console.error(err))
    }

    function handleCancel() {
        setIsModalVisible(false)
    }


    function onCheck(checkedKeys: any, info: any) {
        setCurrentRights(checkedKeys.checked)
    }

    const onExpand = (expandedKeysValue: React.Key[]) => {
        setExpandedKeys(expandedKeysValue);
        setAutoExpandParent(false);
    };
    return (
        <div>
            <Table dataSource={dataSource} columns={columns}
                   rowKey={(item) => item.id}>
            </Table>
            <Modal title="权限分配" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel}>
                <Tree
                    checkable
                    checkedKeys={currentRights}
                    onCheck={onCheck}
                    checkStrictly={true}
                    treeData={rightList}
                    onExpand={onExpand}
                    expandedKeys={expandedKeys}
                    autoExpandParent={autoExpandParent}
                />
            </Modal>
            <p>{update}</p>
        </div>
    );
};

export default RoleManage;
