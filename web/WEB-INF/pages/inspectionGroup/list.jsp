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
    var form_title = "inspectiongroup列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/inspectiongroup/list",
        addUrl:"/inspectiongroup/add",
        editUrl:"/inspectiongroup/edit",
        activePage :pageNo,
        columnFilter  : [
                            {name:"groupId", alias:"groupId"  } ,
                                        {name:"taskId", alias:"taskId"  } ,
                                        {name:"category", alias:"category"  } ,
                                        {name:"categoryTwo", alias:"categoryTwo"  } ,
                                        {name:"num", alias:"num"  } ,
                                        {name:"state", alias:"state"  }                      ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
