/*
[
    {
        "id": 1,
        "name": "部门1",
        "pid": 0,
        "children": [
            {
                "id": 2,
                "name": "部门2",
                "pid": 1,
                "children": []
            },
            {
                "id": 3,
                "name": "部门3",
                "pid": 1,
                "children": [
                    // 结果 ,,,
                ]
            }
        ]
    }
]
*/


let arr = [
    {id: 1, name: '部门1', pid: 0},
    {id: 2, name: '部门2', pid: 1},
    {id: 3, name: '部门3', pid: 1},
    {id: 4, name: '部门4', pid: 3},
    {id: 5, name: '部门5', pid: 4},
]

function arrayToTree(arr) {
    const result = []
    arr.forEach(item => {
        const parent = arr.find(i => i.id === item.pid)
        if (!parent) {
            result.push(item)
        } else {
            parent.children ? parent.children.push(item) : parent.children = [item]
        }
    })
    return result
}

console.log(arrayToTree(arr));
