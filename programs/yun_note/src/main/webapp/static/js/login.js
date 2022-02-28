/**
 * 判断字符串是否为空
 *    为空，返回true
 *    不为空，返回false
 * @param str
 * @returns {Boolean}
 */
function isEmpty(str) {
    return str == null || str.trim() === "";
}

/**
 * 登录表单校验
 */
function checkLogin() {
    const userName = $("#UserName").val()
    const password = $("#UserPwd").val()
    const uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
    const pPattern = /^[a-zA-Z0-9_-]{6,16}$/;
    if (isEmpty(userName) || isEmpty(password)) {
        $("#Msg").text("用户名或密码不能为空!!!")
        return
    }
    if (uPattern.test(userName) && pPattern.test(password)) {
        $("#Msg").text("")
        console.log("start login")
        $("#login-form").submit()
    } else {
        $("#Msg").text("用户名或密码格式不正确!!!")
    }
}