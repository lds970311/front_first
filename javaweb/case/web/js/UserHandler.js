function handleDelete(id) {
    console.log(id)
    if (confirm("Are you sure you want to delete?")) {
        window.location.href = `/case/delUser?id=${id}`
    }
}