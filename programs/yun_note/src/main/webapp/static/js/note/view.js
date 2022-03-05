//加载富文本编辑器ueditor
const uEditor = UE.getEditor("content")

function isEmpty(str) {
    return str == null || str.trim() === "";
}

/**
 * 校验提交表单
 */
function checkNoteForm() {
    const typeId = $("#typeId").val()
    const title = $("#title").val()
    const content = uEditor.getContent();

    //非空校验
    if (isEmpty(typeId)) {
        $("#msg").html("云记类型不能为空!")
        return false
    }
    if (isEmpty(title)) {
        $("#msg").html("标题不能为空!")
        return false
    }
    if (isEmpty(content)) {
        $("#msg").html("云记内容不能为空!")
        return false
    }
    return true;
}