<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRUD Example--Edit</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div id="root">
</div>
<div id="example">
</div>
    <script type="text/javascript">
      
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/crud/edit/"+id;
    var pageParas ={
      formInit :[
      ],
      formExtend :[
        {name:"createTime", type:"delete"},
        {name:"shopInfoId", type:"hidden"}
      ],
      title : "编辑商品",
      url : url,
      redirectUrl : "/redirect",
      method : "put"
    }  
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/editFormGenerator-bundle.js"></script>
  </body>
</html>
