<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<head>
    <title>CRUD Example--Edit</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var form_title = "user列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/admin/user/list",
        addUrl:"/admin/user/add",
        editUrl:"/admin/user/edit",
        activePage :pageNo,
        columnFilter : [
//            {name:"id", alias:"id"} ,
            {name:"name", alias:"用户名"} ,
            {name:"directive", alias:"科室"} ,
//            {name:"mobile", alias:"mobile"} ,
//            {name:"email", alias:"email"} ,
//            {name:"password", alias:"password"}
        ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
