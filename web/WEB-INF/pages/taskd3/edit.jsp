<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>详细信息</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
      <link rel="stylesheet" href="/css/style.css"/>
  </head>
  <body>
  <jsp:include page="../template.jsp" flush="true"></jsp:include>
    <script type="text/javascript">
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/d3/task/"+id;
    var pageParas ={
      formInit :[
        {name:"taskId"},
        {name:"inspectionUnit", placeholder:"单位名称"},
        {name:"source", value:"三科"},
        {name:"state"},
        {name:"leaderNum", value:"1"},
        {name:"bacteria"},
        {name:"生产组人数", group:"groupList"},
        {name:"质量组人数", group:"groupList"},
        {name:"executionTime", placeholder:"2016-01-01 09:30:00"}
      ],
      formExtend :[
        {name:"createTime", alias:"创建时间"},
        {name:"inspectionUnit", alias:"被检单位"},
        {name:"state", alias:"任务状态"},
        {name:"checktype", alias:"业务类型"},
        {name:"taskId", alias:"任务编号"},
        {name:"bacteria", alias:"无菌要求", type:"checkbox"},
        {name:"source", alias:"科室"},
        {name:"leaderNum", alias:"组长人数"},
        {name:"attribution", alias:"归属地"},
        {name:"startExecutionTime", alias:"开始时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true, readOnly:"true"}},
        {name:"endExecutionTime", alias:"结束时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true, readOnly:"true"}}
      ],
      title : "详细信息",
      url : url,
      redirectUrl : "/d3/task/list",
      taskExpertsUrl : "/d3/task/experts/"+id,
      alterUrl : "/d3/task/change",
      cancelUrl : "/d3/task/"+id,
      method : "put",
      button : "none",
      department : "d3",
      taskId : id
    }  
    
    
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/dTaskExpertsEditGen-bundle.js"></script>
  </body>
</html>
