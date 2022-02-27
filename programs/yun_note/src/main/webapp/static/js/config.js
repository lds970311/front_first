//登录页图片切换
let currentIndex = 1;
let timer = null;

$(function () {
    $("#flash").css("background-image", "url(" + $("#flash1").attr("bgUrl") + ")");//设置banner背景颜色名称 这里的flash就是div的ID
});


function changeFlash(i) {
    currentIndex = i;
    const len = $("#flash .pos a").length
    for (let j = 1; j <= len; j++) {//此处的2代表你想要添加的幻灯片的数量与下面的5相呼应
        if (j === i) {
            $("#flash" + j).fadeIn("normal")
                .css("display", "block");
            $("#f" + j).removeClass()
                .attr("class", "dq");
            //alert("#f"+j+$("#f"+j).attr("class"))
            $("#flash").css("background-image", "url(" + $("#flash" + j).attr("bgUrl") + ")");
        } else {
            $("#flash" + j).css("display", "none");
            $("#f" + j).removeClass()
                .attr("class", "no");
        }
    }
}

function startAm() {
    timer = setInterval("timer_tick()", 2000);//8000代表间隔时间设置
}

function stopAm() {
    clearInterval(timer);
}

function timer_tick() {
    currentIndex = currentIndex >= $("#flash .pos a").length ? 1 : currentIndex + 1;//此处的5代表幻灯片循环遍历的次数
    changeFlash(currentIndex);
}

$(document).ready(function () {
    $(".flash_bar div").mouseover(function () {
        stopAm();
    }).mouseout(function () {
        startAm();
    });
    startAm();
});

// input
$(function () {
    //鼠标焦点
    $(":input.user").focus(function () {
        $(this).addClass("userhover");
    }).blur(function () {
        $(this).removeClass("userhover")
    });
    $(":input.pwd").focus(function () {
        $(this).addClass("pwdhover");
    }).blur(function () {
        $(this).removeClass("pwdhover")
    });

    //输入用户名
    $(".user").focus(function () {
        const username = $(this).val();
        if (username === '') {
            $(this).val('');
        }
    });
    $(".user").blur(function () {
        const username = $(this).val();
        if (username === '') {
            $(this).val('');
        }
    });

    //输入密码
    $(".pwd").focus(function () {
        const password = $(this).val();
        if (password === '') {
            $(this).val('');
        }
    });
    $(".pwd").blur(function () {
        const password = $(this).val();
        if (password === '') {
            $(this).val('');
        }
    });

});
	