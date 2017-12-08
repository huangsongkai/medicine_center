<!-- Author: Song -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>五科查看专家</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var form_title = "五科查看专家";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/d5/experts/list",
        addUrl:"/d5/experts/add",
        editUrl:"/d5/experts/edit",
        activePage :pageNo,
        columnFilter : [
                                        {name:"name", alias:"姓名"  } ,
                                        {name:"gender", alias:"性别"  } ,
                                        {name:"school", alias:"学校"  } ,
                                        {name:"work", alias:"工作岗位"  } ,
                                        {name:"title", alias:"职务"  } ,
                                        {name:"phone", alias:"手机号" } ,
                                      //  {name:"leader", alias:"组长" } , ,
                                        {name:"category", alias:"类别"  } ,
                                        {name:"source", alias:"科室名"  }
                        ],
        searchBar: true,
        identifier : "expertsId"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
