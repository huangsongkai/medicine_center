<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加任务</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var selector={attribution:["哈尔滨","齐齐哈尔","牡丹江","佳木斯","大庆","鸡西","鹤岗","双鸭山","伊春","黑河","七台河","绥化","大兴安岭"]};
    var checktype={checktype:["认证检查","跟踪检查","飞行检查","现场检查","医疗机构制剂注册技术审评","医疗器械注册技术审评","专项检查"]};
    var pageParas ={
        selector: {
            zuzhang:["注射剂", "化药", "医用氧", "中药"],
            jianguan:["注射剂", "化药", "医用氧", "中药"],
            jianyan:["中药", "化药"],
            linchuang:["儿科", "风湿免疫", "妇科、乳腺", "骨科", "呼吸科", "呼吸科", "外科", "消化科", "心内科", "神经科", "临床机构", "眼科", "皮肤科", "其他科"],
        },

        formInit :[
            {name:"inspectionUnit", placeholder:"单位名称"},
            {name:"attribution", alias:"归属地",type:"select", options:selector.attribution },
            {name:"checktype", alias:"检查类型",type:"select", options:checktype.checktype },
            {name:"source", value:"二科"},
            {name:"zuzhang", group:"zuzhang", isRoot:"true", value:"1", validator:{notNull:true, dataType:"number"}},
            {name:"jianguan", group:"jianguan", isRoot:"true", value:"1", validator:{notNull:true, dataType:"number"}},
            {name:"jianyan", group:"jianyan", isRoot:"true", value:"1", selectorValue:"中药", validator:{notNull:true, dataType:"number"}},
            {name:"linchuang", group:"linchuang", isRoot:"true", value:"1", selectorValue:"儿科", validator:{notNull:true, dataType:"number"}},
            {name:"startExecutionTime", placeholder:"2016-01-01"},
            {name:"endExecutionTime", placeholder:"2016-01-01"}
        ],
        formExtend :[
            {name:"inspectionUnit", alias:"被检单位", validator:{notNull:true, dataType:"location"}},
            {name:"zuzhang", alias:"组长"},
            {name:"linchuang", alias:"临床"},
            {name:"jianguan", alias:"监管人员"},
            {name:"jianyan", alias:"检验人员"},
            {name:"source", alias:"科室", readOnly:"true"},
            {name:"startExecutionTime", alias:"开始时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true}},
            {name:"endExecutionTime", alias:"结束时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true}},
        ],
        title : "添加任务",  
        url : "/d2/task",
        redirectUrl : "/d2/task/list",
        method : "post"
    }

</script>
<script src="/js/commonV3.js"></script>
<script src="/js/d2EditFormGenerator-bundle.js"></script>
</body>
</html>
