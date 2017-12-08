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
    var form_title = "experts列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/experts/list",
        addUrl:"/experts/add",
        editUrl:"/experts/edit",
        activePage :pageNo,
        columnFilter : [
                            {name:"id", alias:"id" ,type:"hidden" } ,
                                        {name:"name", alias:"姓名"  } ,
                                        {name:"gender", alias:"性别"  } ,
                                        {name:"age", alias:"年龄"  } ,
                                        {name:"school", alias:"学校"  } ,
                                        {name:"degree", alias:"学位"  } ,
                                        {name:"work", alias:"工作岗位"  } ,
                                        {name:"title", alias:"职务"  } ,
                                        {name:"phone", alias:"手机号"  } ,
                                        {name:"remarks", alias:"备注"  } ,
                                        {name:"leader", alias:"组长"  } , ,
                                        {name:"category", alias:"类别"  } ,
                                        {name:"source", alias:"科室名"  }
                        ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
