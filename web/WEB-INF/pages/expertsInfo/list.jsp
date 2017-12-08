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
    var form_title = "expertsinfo列表";
    var pageNo = window.location.hash;
    if(pageNo){
        pageNo = pageNo.substring(1);
    }
    var pageParas = {
        url:"/expertsinfo/list",
        addUrl:"/expertsinfo/add",
        editUrl:"/expertsinfo/edit",
        activePage :pageNo,
        columnFilter  : [
                            {name:"expertsId", alias:"expertsId"  } ,
                                        {name:"name", alias:"name"  } ,
                                        {name:"gender", alias:"gender"  } ,
                                        {name:"age", alias:"age"  } ,
                                        {name:"school", alias:"school"  } ,
                                        {name:"degree", alias:"degree"  } ,
                                        {name:"work", alias:"work"  } ,
                                        {name:"title", alias:"title"  } ,
                                        {name:"phone", alias:"phone"  } ,
                                        {name:"remarks", alias:"remarks"  } ,
                                        {name:"leader", alias:"leader"  } ,
                                        {name:"bacteria", alias:"bacteria"  } ,
                                        {name:"categoryOne", alias:"categoryOne"  } ,
                                        {name:"categoryTwo", alias:"categoryTwo"  } ,
                                        {name:"source", alias:"source"  }                      ],
        searchBar: true,
        identifier : "id"
    };
</script>
<script src="/js/commonV3.js"></script>
<script src="/js/pageListGenerator-bundle.js"></script>
</body>
</html>
