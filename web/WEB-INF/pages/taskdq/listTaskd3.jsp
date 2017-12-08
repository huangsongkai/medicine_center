<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<head>
    <title>质量科任务列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var form_title = "质量科任务列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }

    var pageParas = {
        url:"/dq/task/list/d3",
        editUrl:"/dq/task/",
        // orderBy:"shopName",
        activePage :parseInt(pageNo),
        columnFilter : [
            {name:'inspectionUnit', alias:'单位名称'},
            {name:'startExecutionTime', alias:'开始时间'},
            {name:'endExecutionTime', alias:'结束时间'},
            {name:'source', alias:'来源科室'},
            {name:'state', alias:'任务状态'},
            // {name:'createUserName', alias:'创建人'},
        ],

        searchBar: true,
        identifier : "taskId",
        selector :{"name":"state", "value":[{"value":"", "name":"全部类型"}, {"value":"待处理", "name":"待处理"}, {"value":"处理中", "name":"处理中"}, {"value":"已完成", "name":"已完成"}, {"value":"变更中", "name":"变更中"}, {"value":"已取消", "name":"已取消"}]
        }
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/dqListGenerator-bundle.js"></script>
</body>
</html>
