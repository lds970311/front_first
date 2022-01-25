function handleDelete(id, page) {
    console.log(id)
    if (confirm("Are you sure you want to delete?")) {
        window.location.href = `/case/delUser?id=${id}`
    }
}

function handleUserUpdate(id) {
    window.location.href = `/case/queryUser?id=${id}`
}

/**
 * 批量选中删除
 */
function handleIdSelect() {
    if (confirm("Are you sure you want to delete?")) {
        const inputs = document.getElementsByName("uid")
        let selectedString = [];
        inputs.forEach(input => {
            if (input.checked) {
                selectedString.push("id=" + input.value)
            }
        })
        //判断是否有选中条目
        if (selectedString.length > 0) {
            const params = selectedString.join("&");
            console.log(params)
            window.location.href = `/case/deleteSelected?${params}`
        }
    }
}