<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>升级后台主页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <link href="resources-1.0.0/static/bootstrap/2.1.1/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="resources-1.0.0/static/bootstrap/2.1.1/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" language="javascript" src="js/table/jquery.dataTables.js"></script>
    <script type="text/javascript" language="javascript" src="js/table/dataBase.js"></script>
    <script type="text/javascript" language="javascript"
            src="js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
    <script>
        //页面加载完之后执行
        $(function () {
            //发送ajax请求,获取所有的课程信息
            $.ajax({
                url: "findAllCourses.action",
                type: "get",
                dataType: 'JSON',
                success: function (result) {
                    //返回数据
                    var data = result;
                    console.log(result);
                    if (data != null) {
                        $("#d1 tbody").remove();
                        if ($('#d1').hasClass('dataTable')) {
                            $('#d1').dataTable().fnDestroy();
                        }
                        var list = [];
                        var str = "";
                        for (var i = 0; i < data.length; i++) {
                            var id = data[i].id;
                            var operation = "<a style='width: 30px' data-toggle='modal' data-target='#courseUpdateModal' onclick=toCourseUpdate('" + id + "');><span class='glyphicon glyphicon-edit'></a>&nbsp;" +
                                "<a style='width: 30px' onclick=toCourseDelete('" + id + "');><span class='glyphicon glyphicon-trash'></span></a>";
                            list[i] = {
                                "id": id,
                                "name": data[i].name,
                                "createDate": data[i].createDate,
                                "updateDate": data[i].updateDate,
                                "fullScore": data[i].fullScore,
                                "operation": operation
                            };

                        }
                        var cloums = ["id", "name", "createDate", "updateDate", "fullScore", "operation"];
                        getTableData_("d1", list, cloums, 20, 10);//容器ID，数据集合，数据属性集合（需要展示的属性名），行高,每页显示的条数

                    } else {
                        alert(result);
                    }
                },
                error: function () {
                    alert("课程加载失败!");
                }

            });

            //搜索功能
            $("#search").click(function () {
                //课程名称
                var name = $("#name").val().trim();
                console.log(name);
                if (name == "") {
                    //为空则刷新页面
                    location.reload();
                } else {
                    //发送查询请求
                    $.ajax({
                        url: "searchCourse.action",
                        type: "post",
                        dataType: 'JSON',
                        data: {
                            "name": name
                        },
                        success: function (result) {
                            //返回数据
                            var data = result;
                            //判断是否成功
                            if (data != null && data[0].id != null) {
                                $("#d1 tbody").remove();
                                if ($('#d1').hasClass('dataTable')) {
                                    $('#d1').dataTable().fnDestroy();
                                }
                                var list = [];
                                for (var i = 0; i < data.length; i++) {
                                    var id = data[i].id;
                                    var operation = "<a style='width: 30px' data-toggle='modal' data-target='#courseUpdateModal' onclick=toCourseUpdate('" + id + "');><span class='glyphicon glyphicon-edit'></a>&nbsp;" +
                                        "<a style='width: 30px' onclick=toCourseDelete('" + id + "');><span class='glyphicon glyphicon-trash'></span></a>";
                                    list[i] = {
                                        "id": id,
                                        "name": data[i].name,
                                        "createDate": data[i].createDate,
                                        "updateDate": data[i].updateDate,
                                        "fullScore": data[i].fullScore,
                                        "operation": operation
                                    };

                                }
                                var cloums = ["id", "name", "createDate", "updateDate", "fullScore", "operation"];
                                getTableData_("d1", list, cloums, 20, 10);//容器ID，数据集合，数据属性集合（需要展示的属性名），行高,每页显示的条数

                            } else {
                                alert("该课程不存在");
                            }
                        },
                        error: function () {
                            alert("搜索课程失败!");
                        }
                    });
                }
            });

            //点击显示注册课程模态框
            $('#add').click(function () {
                $('#courseAddModal').modal('show');
            });

        });


        //删除商品
        function toCourseDelete(id) {
            if (confirm("确定要删除吗?")) {
                $.ajax({
                    type: "post",
                    url: "deleteCourse.action",
                    data: {"cid": id},
                    dataType: "text",
                    success: function (result) {
                        //返回消息
                        var msg = result;
                        if ("1" == msg) {
                            location.reload();
                        }
                    },
                    error: function () {
                        alert("删除失败");
                    }
                });
            }
        }

        //显示修改课程界面
        function toCourseUpdate(id) {
            $.ajax({
                type: "post",
                url: "findCourse.action",
                data: {"cid": id},
                dataType: "json",
                success: function (result) {
                    //返回数据
                    var data = result;
                    if (data != null) {
                        $('#idUpdate').html("" + data.id + "");
                        $('#inputIdUpdate').val("" + data.id + "")
                        $('#nameUpdate').val("" + data.name + "");
                        $('#fullScoreUpdate').val("" + data.fullScore + "");
                    } else {
                        alert(result.msg);
                    }
                },
                error: function () {
                    alert("页面加载失败");
                }
            });
        }

        //提交课程信息修改
        function saveCourseUpdate() {
            var cid = $('#inputIdUpdate').val().trim();
            var name = $('#nameUpdate').val().trim();
            var fullScore = $('#fullScoreUpdate').val().trim();
            //发送Ajax请求
            $.ajax({
                type: "post",
                url: "updateCourse.action",
                data: {
                    "cid": cid,
                    "name": name,
                    "fullScore": fullScore
                },
                dataType: 'text',
                success: function (result) {
                    //返回数据
                    var msg = result;
                    if ("1" == msg) {
                        $('#courseUpdateModal').modal('hide');
                        location.reload();
                    }
                },
                error: function () {
                    alert("修改课程失败");
                }
            });
        }

        //提交新增商品信息
        function saveCourseAdd() {
            var name = $('#nameAdd').val().trim();
            var fullScore = $('#fullScoreAdd').val().trim();
            //发送Ajax请求
            $.ajax({
                type: "post",
                url: "addCourse.action",
                data: {
                    "name": name,
                    "fullScore": fullScore
                },
                dataType: 'text',
                success: function (result) {
                    //返回数据
                    var msg = result;
                    if ("1" == msg) {
                        $('#courseAddModal').modal('hide');
                        location.reload();
                    } else if ("3" == msg) {
                        alert("该课程已存在");
                    }
                },
                error: function () {
                    alert("新增课程失败");
                }
            });
        }

    </script>
</head>

<style>
    body {
        font-family: SimHei;
        background: #d2ddea;
        background: #d2d9e2;
    }

    .nav > li.nav-header {
        font-size: 22px;
        color: #113665;
        /*font-family: STXinwei;*/
        padding: 10px 20px;
        text-align: center;
        background: #6094CD;
        border-bottom: 1px solid #ccc;
        color: #fff;
    }

    h3 {
        /*font-family: STXinwei;*/

    }

    .nav > li {
        border-bottom: 1px solid #fbfbfb;
    }

    .nav-list > li > a {
        padding: 3px 40px;
        cursor: pointer;
        /*font-family: Microsoft YaHei;*/
        /*font-family: SimHei;*/
        /*text-indent: 20px;*/
        font-size: 16px;
        color: #636262;
        /*font-family: STXinwei;*/
        line-height: 30px;
    }

    .nav-list > li > a:hover {
        color: #428bca;
    }

    select, textarea, input[type="text"] {
        width: 230px;
        height: 28px;
        border: 1px solid #dcdcdc;
        border-radius: 3px;
        margin: 5px 0;
    }

    textarea {
        width: 300px;
        height: 50px;
    }

    form {
        overflow: hidden;
    }

    form p {
        overflow: hidden;
    }

    form label {
        display: block;
        min-width: 120px;
        height: 30px;
        float: left;
        margin: 0;
        font-weight: normal;
        /*text-align: right;*/
    }

    form span {
        display: block;
        float: left;
        max-width: 400px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    .button {
        background: #5891ce;
        color: #fff;
        border-radius: 3px;
        border: 1px solid #006dcc;
        padding: 0px 30px;
        margin: 15px 0;
    }

    .modal .button {
        margin: 45px 0 0 0;
        cursor: pointer;
        text-decoration: none;
    }

    .well {
        margin: 50px 20px;
        display: block;
        float: left;
        padding: 35px 35px;
        border: 1px solid #ccc;
        box-shadow: 1px 1px 5px #b5cce6;
    }

    #left {
        width: 260px;
        overflow: hidden;
        float: left;
    }

    #middlebar {
        width: 70%;
        float: left;
    }

    .info {
        font-size: 14px;
        color: gray;
    }

    /*#d1 {*/
    /*border: 1px solid #ccc;*/
    /*table-layout: fixed;*/
    /*!*top: 93px;*!*/
    /*!*left: 0px;*!*/
    /*!*position: absolute;*!*/
    /*}*/

    #d1 a {
        display: inline-block;
        font-size: 14px;
        cursor: pointer;
        width: 50px;
        height: 25px;
        margin: 0 3px;
    }

    #d1_filter {
        display: none;
    }

    #d1 {
        border: 1px solid #ccc;
        border-radius: 3px;
        background: #fff;
    }

    #d1 td, #d1 th {
        border: 1px solid #ccc;
        width: 132px;
        text-align: center;
        border-radius: 3px;
        padding: 10px 0px;
        max-width: 180px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    #d1_processing {
        display: none;
    }

    #d1 th {
        /*background: #f5f5f5;*/
        border: 1px solid #b3b0b0;
        color: #333;
    }

    #d1_paginate {
        float: right;
    }

    #d1_paginate a {
        text-decoration: none;
        padding: 0 5px;
        cursor: pointer;
    }

    header {
        background: #113665;
        line-height: 50px;
        color: #e4e6e8;
        padding: 0 50px;
        letter-spacing: 3px;
        box-shadow: 1px 1px 5px #395b86;
        font-family: STXinwei;
        font-size: 26px;
        text-shadow: 1px 1px 5px #395b86;
    }

    header span {
        cursor: pointer;
    }

    header span:hover {
        color: #f5f5f5;
    }

    .upload {
        float: right;
        cursor: pointer;
        width: 30px;
        height: 30px;
        background: url("resources-1.0.0/static/images/uploadFile.png") no-repeat;
        background-size: 30px 30px;
    }

    .force {
        background: url("resources-1.0.0/static/images/forceSet.png") no-repeat;
        background-size: 25px 25px;
    }

    .extra {
        background: url("resources-1.0.0/static/images/extraSet.png") no-repeat;
        background-size: 25px 25px;
    }

    .active {
        background: url("resources-1.0.0/static/images/active.png") no-repeat;
        background-size: 25px 25px;
    }

    .modal {
        /*overflow: hidden;*/
    }

    .nav > li > a > img {
        margin: -3px 0 0 0;
    }

    .modal-body {
        font-size: 16px;
        line-height: 30px;
    }

    #d1 th.forceUpdateValue {
        width: 150px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    #d1 th {
        width: 160px;
    }

    .xline {
        border-bottom: solid 2px #000;
        height: 5px;
    }

    #orderList th {
        color: #333;
        font-size: 11px;
    }

    #changeButtonUn {
        position: absolute;
        left: 378px;
    }

    label.class {
        color: dodgerblue;
    }


</style>

<body>

<%@ include file="/WEB-INF/header.jsp" %>
<div class="container-fluid">
    <div id="left">
        <div class="well span3" style="width: 220px;min-height: 100px;padding: 0;">
            <ul class="nav nav-list">
                <li id="skipClassManager"><a href="login.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                      width="25"
                                                                      height="25" alt="">班级管理</a>
                </li>
                <li id="skipCourseManager"><a href="course.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                    width="25"
                                                                    height="25" alt="">课程管理</a>
                </li>
                <li id="skipAssessGroup"><a href="group.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                     width="25"
                                                                     height="25" alt="">测评小组</a>
                </li>
                <li id="skipOwnAssess"><a href="own.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                 width="25"
                                                                 height="25" alt="">学生自评</a>
                </li>
                <li id="skipStudentAssess"><a href="student.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                        width="25"
                                                                        height="25" alt="">学生管理</a>
                </li>
                <li id="skipAssessResult"><a href="result.action"><img src="resources-1.0.0/static/images/activeLog.png"
                                                                       width="25"
                                                                       height="25" alt="">测评结果查询</a>
                </li>
            </ul>
        </div>
    </div>

    <div id="middlebar">
        <div class="well span3" style="margin:50px 0;padding:0 20px 20px 20px;height: 80%;width: 1323px">
            <h3 style="color:green;">课程管理</h3>
            <HR class="xline">
            &nbsp;&nbsp;&nbsp;&nbsp;课程名称:&nbsp;<input id="name" name="name" type="text" style="width:200px"/>&nbsp;&nbsp;
            <input id="search" type="button" value="课程搜索" name="search"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="add" type="button" value="新增课程" name="add"/>
            <div id="1" style="margin-top: 10px; text-align: center;height: 80%;width: 1200px">
                <table id="d1">
                    <colgroup>
                        <col style="width:5%">
                        <col style="width:5%">
                        <col style="width:10%">
                        <col style="width:10%">
                        <col style="width:8%">
                        <col style="width:4%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>课程ID</th>
                        <th>课程名称</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th>满分</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!--模态框-->
    <div class="modal fade" id="courseUpdateModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog classedit">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h3 class="modal-title">
                        课程信息修改<span style="color: red;font-size: 14px">(※ 为必填项)</span>
                    </h3>
                </div>
                <div class="modal-body">
                    <div>
                        <form id="courseUpdateForm" enctype="multipart/form-data">
                            <p>
                                <label> 课程ID:</label>
                                <span id="idUpdate"></span>
                                <input id="inputIdUpdate" style="visibility:hidden;display: none" name="cid"
                                       type="text" value="">
                            </p>
                            <p>
                                <label> <span style="color: red">※</span>课程名称:</label>
                                <input id="nameUpdate" name="name" type="text" value="">
                            </p>
                            <p>
                                <label> <span style="color: red">※</span>课程总分:</label>
                                <input id="fullScoreUpdate" name="name" type="text" value="">
                            </p>
                            <input type="button" class="button" value="修改" onclick="saveCourseUpdate()"/>
                            <input type="button" class="button" data-dismiss="modal" aria-hidden="true" value="取消"/>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="courseAddModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog classedit">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h3 class="modal-title">
                        新增课程<span style="color: red;font-size: 14px">(※ 为必填项)</span>
                    </h3>
                </div>
                <div class="modal-body">
                    <div>
                        <form id="courseAddForm" enctype="multipart/form-data">
                            <p>
                                <label> <span style="color: red">※</span> 课程名称:</label>
                                <input id="nameAdd" name="name" type="text" value="">
                            </p>
                            <p>
                                <label> <span style="color: red">※</span>课程总分:</label>
                                <input id="fullScoreAdd" name="fullScore" type="text" value="">
                            </p>
                            <input type="button" class="button" value="增加" onclick="saveCourseAdd()"/>
                            <input type="button" class="button" data-dismiss="modal" aria-hidden="true" value="取消"/>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
