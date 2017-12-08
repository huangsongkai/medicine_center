<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>task-add</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
</head>
<body>
<div id="root">
</div>
<div id="example">
</div>
<script type="text/javascript">

    var pageParas ={
        formInit :[
            {name:"inspectionUnit", placeholder:"单位名称"},
            {name:"source", value:"三科"},
            {name:"leaderNum", value:"1"},
            {name:"bacteria", value:"1"},
            {name:"生产组人数", group:"groupList", value:"1", validator:{notNull:true, dataType:"number"}},
            {name:"质量组人数", group:"groupList", value:"1", validator:{notNull:true, dataType:"number"}},
            {name:"executionTime", placeholder:"2001-01-01 08:00"}
        ],
        formExtend :[
            {name:"inspectionUnit", alias:"被检单位", validator:{notNull:true}},
            {name:"bacteria", alias:"无菌要求", type:"checkbox", value:false},
            {name:"source", alias:"科室", type:"readOnly"},
            {name:"leaderNum", alias:"组长人数", type:"readOnly"},
            {name:"executionTime", alias:"检查时间",validator:{dataType:"time", notNull:true}},
        ],
        title : "添加商品表单",
        url : "/task",
        redirectUrl : "/task/list",
        method : "post"
    }

</script>
<script src="/js/commonV3.js"></script>
<script src="/js/d3EditFormGenerator-bundle.js"></script>
</body>
</html>
