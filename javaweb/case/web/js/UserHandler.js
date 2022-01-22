function handleDelete(id) {
    console.log(id)
    if (confirm("Are you sure you want to delete?")) {
        window.location.href = `/case/delUser?id=${id}`
    }
}

function handleUserUpdate(id) {
    window.location.href = `/case/queryUser?id=${id}`
}