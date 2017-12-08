<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改记录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var form_title = "修改记录";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/tasklog/list/d4",
       // addUrl:"/tasklog/add",
       // editUrl:"/tasklog/edit",
        activePage :pageNo,
        columnFilter  : [
                          //  {name:"id", alias:"序号" ,type:"hidden" } ,
                            {name:"inspectionUnit", alias:"被检单位"  } ,
                            {name:"oldName", alias:"替换前"  } ,
                            {name:"newName", alias:"替换后"  } ,
                            {name:"reason", alias:"原因"  }
        ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
