<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
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
        var form_title = "科室提出修改记录";
        var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/taskupdatelog/list",
//        addUrl:"/taskupdatelog/add",
//        editUrl:"/taskupdatelog/edit",
        activePage :pageNo,
        columnFilter  : [
                        {name:"id", alias:"id" ,type:"hidden" } ,
                        {name:"taskId", alias:"taskId"  } ,
                        {name:"reason", alias:"reason"  } ,
                        {name:"createUser", alias:"createUser"  }
        ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
