<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRUD Example--Edit</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<div id="root">
</div>
<div id="example">
</div>
<script type="text/javascript">
    var form_title = "expertsuplog列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/expertsuplog/list",
//        addUrl:"/expertsuplog/add",
//        editUrl:"/expertsuplog/edit",
        activePage :pageNo,
        columnFilter  : [
//                            {name:"id", alias:"id" ,type:"hidden" } ,
                            {name:"expertsId", alias:"id"  } ,
                            {name:"upadteDetails", alias:"修改内容"  } ,
                            {name:"source", alias:"科室"  } ,
                            {name:"user", alias:"操作人"  } ,
                            {name:"type", alias:"操作类型"  },
                            {name:"createTime", alias:"创建时间"  } ,

        ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
