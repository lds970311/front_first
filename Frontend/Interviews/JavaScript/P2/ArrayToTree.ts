/**
 * 手写数组转树
 */
const input = [
    {
        id: 1,
        val: "学校",
        parentId: null,
    },
    {
        id: 2,
        val: "班级1",
        parentId: 1,
    },
    {
        id: 3,
        val: "班级2",
        parentId: 1,
    },
    {
        id: 4,
        val: "学生1",
        parentId: 2,
    },
    {
        id: 5,
        val: "学生2",
        parentId: 3,
    },
    {
        id: 6,
        val: "学生3",
        parentId: 3,
    },
];

function arrayToTree(input: Array<any>): any {
    const res: any = [];
    input.forEach(item => {
        let parentId = item.id;
        if (parentId != null) {
            input.forEach(subItem => {
                if (subItem.parentId === parentId) {
                    if (!item.children) item.children = [];
                    item.children.push(subItem);
                }
            })
        }
        res.push(item);
    })
    return res;
}

const tree = arrayToTree(input);
console.log(tree);
