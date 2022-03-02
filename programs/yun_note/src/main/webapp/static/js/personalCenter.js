$(function () {
        const target = $("#nickName");
        //验证昵称唯一
        target.blur(
            function () {
                $("#btn").attr('disabled', false);
                $("#msg").html('');
                let value = target.val();
                //不用ajax验证，没有填写或者与之前内容相同
                if (value.length === 0 || value === '我思故我在') {
                    target.val('我思故我在');
                    return;
                }
                //ajax验证
                $.getJSON("user", {
                    act: 'unique',
                    nick: value
                }, function (data) {
                    if (data.resultCode === -1) {
                        $("#msg").html(value + "此用户名已存在");
                        target.val('');
                        $("#btn").attr('disabled', true);
                    } else {
                        $("#btn").attr('disabled', false);
                    }
                });
            }
        );
    }
);

function checkUser() {
    const nickName = $('#nick').val();
    if (nickName.length === 0) {
        $("#msg").html("昵称不能为空,请核对！");
        return false;
    }
    return true;
}