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
    var form_title = "expertscdlog列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/expertscdlog/list",
//        addUrl:"/expertscdlog/add",
//        editUrl:"/expertscdlog/edit",
        activePage :pageNo,
        columnFilter  : [
                           // {name:"id", alias:"id" ,type:"hidden" } ,
                            {name:"expertsId", alias:"id"  } ,
                            {name:"name", alias:"姓名"  } ,
                            {name:"category", alias:"分组1"  } ,
                            {name:"categoryTwo", alias:"分组2"  } ,
                            {name:"source", alias:"科室"  } ,
                            {name:"attribution", alias:"归属地"  } ,
                            {name:"user", alias:"操作人"  } ,
                            {name:"type", alias:"操作类型"},
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
