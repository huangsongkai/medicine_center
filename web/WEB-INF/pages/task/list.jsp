<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<head>
    <title>CRUD Example--Edit</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
</head>
<body>
<div id="root">
</div>
<div id="example">
</div>
<script type="text/javascript">
    var form_title = "user列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/d3/list",
        addUrl:"/d3",
        editUrl:"/d3",
        activePage :pageNo,
        columnFilter : [
            {name:"taskId", alias:"id"} ,
            {name:"inspectionUnit", alias:"inspectionUnit"} ,
            {name:"createTime", alias:"createTime"} ,
            {name:"executionTime", alias:"executionTime"} ,
            {name:"state", alias:"email"} ,
            {name:"source", alias:"source"}                  ],
        searchBar: true,
        identifier : "taskId",
        selector :{"name":"state", "value":[{"value":"all", "name":"全部类型"}, {"value":"待处理", "name":"待处理"}, {"value":"处理中", "name":"处理中"}, {"value":"已完成", "name":"已完成"}, {"value":"变更中", "name":"变更中"}, {"value":"已取消", "name":"已取消"}]}
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
