<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Expert</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <!-- Author: Song -->
      <link rel="stylesheet" href="/css/style.css"/>
  </head>
  <body>
  <jsp:include page="../template.jsp" flush="true"></jsp:include>
    <script type="text/javascript">
      
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/task/"+id;
    var pageParas ={
      
      formExtend :[
        {name:"inspectionUnit", alias:"被检单位", readOnly:true, validator:{notNull:true}},
        {name:"bacteria", alias:"无菌要求", type:"text", readOnly:true},
        {name:"source", alias:"科室", readOnly:true},
        {name:"leaderNum", alias:"组长人数", readOnly:true},
        {name:"executionTime", alias:"检查时间",readOnly:true, validator:{dataType:"time", notNull:true}},
      ],
      title : "生成专家列表",
      url : url,
      redirectUrl : "/task/list",
      method : "put"
    }
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/d3TaskExpertsGen-bundle.js"></script>
  </body>
</html>
