<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加任务</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <style type="text/css">
        .selected>li:hover,.selected>li.active{
            background-color:#1E90FF;
        }
    </style>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var selector={attribution:["哈尔滨","齐齐哈尔","牡丹江","佳木斯","大庆","鸡西","鹤岗","双鸭山","伊春","黑河","七台河","绥化","大兴安岭"]};
    var checktype={checktype:["认证检查","跟踪检查","飞行检查","现场检查","医疗机构制剂注册技术审评","医疗器械注册技术审评","专项检查"]};
    var pageParas ={
        selector : {
            attribution:["哈尔滨","齐齐哈尔","牡丹江","佳木斯","大庆","鸡西","鹤岗","双鸭山","伊春","黑河","七台河","绥化","大兴安岭"]
        },
        formInit :[
            {name:"inspectionUnit", placeholder:"单位名称"},
            {name:"attribution", alias:"归属地",type:"select", options:selector.attribution },
            {name:"checktype", alias:"检查类型",type:"select", options:checktype.checktype },
            {name:"source", value:"六科"},
            {name:"zyzz", alias:"zyzz", type:"HintInputData"},       
            {name:"hyzj", alias:"hyzj", type:"HintInputData"},
            {name:"startExecutionTime", placeholder:"2016-01-01"},
            {name:"endExecutionTime", placeholder:"2016-01-01"}
        ],
        formExtend :[
            {name:"inspectionUnit", alias:"被检单位", validator:{notNull:true}},
            {name:"zyzz", alias:"中药制剂"},
            {name:"hyzj", alias:"化药制剂"},
            {name:"source", alias:"科室", readOnly:"true"},
            {name:"startExecutionTime", alias:"开始时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true}},
            {name:"endExecutionTime", alias:"结束时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true}},
        ],
        title : "添加任务",  
        url : "/d6/task",
        redirectUrl : "/d6/task/list",
        method : "post"
    }

</script>
<script src="/js/commonV3.js"></script>
<script src="/js/editFormGenerator-bundle.js"></script>
</body>