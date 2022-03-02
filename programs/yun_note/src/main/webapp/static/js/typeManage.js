$(function () {
    //显示模态窗口
    $("#addBtn").click(function () {
        $("#myModalLabel").text("新增");
        $('#myModal').modal();
        $("input[name='typeId']").val('');
        $('#typename').val('');
    });

    //确保本人的类型唯一
    var target = $('#typename');
    //获取焦点可用状态
    target.focus(function () {
        $('#btn_submit').html('保存').removeClass("btn-danger").addClass("btn-info").attr('disabled', false);
    });
    //使用ajax验证
    target.blur(function () {
        var val = target.val(); //获取值
        if (val.length == 0) {
            return;
        }
        $.getJSON("type", {
            act: 'unique', typename: val
        }, function (data) {
            if (data.resultCode == -1) {
                $('#btn_submit').html('名称已存在').removeClass("btn-primary").addClass("btn-danger").attr('disabled', true);
            } else {
                $('#btn_submit').html('保存').removeClass("btn-danger").addClass("btn-info").attr('disabled', false);

            }
        });
    });

    //保存数据
    $('#btn_submit').click(function () {
        var idVal = $("input[name='typeId']").val();
        $.getJSON("type", {
            act: 'save', typename: $('#typename').val(), typeId: idVal
        }, function (data) {
            //追加一行
            if (data.resultCode == 1) {
                if (idVal.length == 0) { //新增
                    var noteType = data.result;
                    var tr = "<tr><td>" + noteType.typeId + "</td>";
                    tr += "<td>" + noteType.typeName + "</td>";
                    tr += "<td><button class=\"btn btn-primary\" type=\"button\">修改</button>&nbsp;";
                    tr += "<button class=\"btn btn-danger\" type=\"button\">删除</button></td></tr>";
                    //追加到当前表格中
                    //$(“.table”).filter(“.table-hover”).filter(“.table-striped”)
                    //$("[class='table table-hover table-striped']");
                    $(".table.table-hover.table-striped").append(tr);

                } else { //修改
                    //遍历表格
                    var targetTr;
                    $("table tr:gt(0)").each(function (i) {
                        $(this).children("td:eq(0)").each(function (i) {
                            if ($(this).text() == idVal) {
                                targetTr = $(this).parent();
                                return false;
                            }
                        });
                    });
                    targetTr.children('td').eq(1).html($('#typename').val());
                }
                //隐藏模态窗口
                $('#myModal').modal('hide');
            }
        });
    });

    //修改
    //$(".table tr td:nth-child(2)").addClass('red');
    //$(this).children('td').eq(1).addClass('red');
    //1、绑定所有修改按钮事件
    $('.table').on('click', '.btn-primary', function () {
        //2、获取对应的值  typeId typeName
        var tr = $(this).parent().parent();
        var typeId = tr.children('td').eq(0).text();
        var typeName = tr.children('td').eq(1).text();

        //3、显示模态窗口
        $("#myModalLabel").text("修改");
        $('#myModal').modal();
        //4、按钮重置样式
        $('#btn_submit').html('保存').removeClass("btn-danger").addClass("btn-info").attr('disabled', true);
        //5、填充值
        $('#typename').val(typeName);
        $("input[name='typeId']").val(typeId);
    });


    //删除 1、绑定所有修改按钮事件
    $('.table').on('click', '.btn-danger', function () {
        //2、获取对应的值  typeId typeName
        var tr = $(this).parent().parent();
        var typeId = tr.children('td').eq(0).text();
        var typeName = tr.children('td').eq(1).text();
        //3、使用sweet-alert
        swal({
            title: "操作提示",   //弹出框的title
            text: "确定删除【" + typeName + "】吗？",  //弹出框里面的提示文本
            type: "warning",    //弹出框类型
            showCancelButton: true, //是否显示取消按钮
            confirmButtonColor: "#DD6B55",//确定按钮颜色
            cancelButtonText: "取消",//取消按钮文本
            confirmButtonText: "是的，确定删除！"//确定按钮上面的文档
        }).then(function (isConfirm) {
            if (isConfirm === true) {
                $.getJSON("type", {
                    act: 'del', typeId: typeId
                }, function (data) {
                    if (data.resultCode == 1) {
                        swal('操作成功!', '已成功删除数据', 'success');
                        //移除tr
                        var targetTr;
                        $("table tr:gt(0)").each(function (i) {
                            $(this).children("td:eq(0)").each(function (i) {
                                if ($(this).text() == typeId) {
                                    targetTr = $(this).parent();
                                    return false;
                                }
                            });
                        });
                        targetTr.remove();
                    } else if (data.resultCode == 0) {
                        swal('操作失败!', '存在子记录不能删除', 'error');
                    } else {
                        swal('操作失败!', '未知问题', 'error');
                    }
                });

            }
        });
    });
});