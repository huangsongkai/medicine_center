<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>任务详情</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
      <link rel="stylesheet" href="/css/style.css"/>
  </head>
  <body>
  <jsp:include page="../template.jsp" flush="true"></jsp:include>
    <script type="text/javascript">
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/dq/"+id;
    var pageParas ={
      formInit :[
        {name:"inspectionUnit", placeholder:"单位名称"},
        {name:"source", value:"三科"},
        {name:"leaderNum", value:"1"},
        {name:"bacteria"},
        {name:"生产组人数", group:"groupList"},
        {name:"质量组人数", group:"groupList"},
        {name:"executionTime", placeholder:"2016-01-01 09:30:00"}
      ],
      formExtend :[
        {name:"taskId", alias:"任务ID"},
        {name:"state", alias:"状态"},
        {name:"createTime", alias:"创建时间"},
        {name:"inspectionUnit", alias:"被检单位"},
        {name:"bacteria", alias:"无菌要求", type:"checkbox"},
        {name:"source", alias:"科室"},
        {name:"checktype", alias:"业务类型"},
        {name:"leaderNum", alias:"组长人数"},
        {name:"attribution", alias:"归属地"},
        {name:"endExecutionTime", alias:"结束时间"},
        {name:"startExecutionTime", alias:"开始时间"},
      ],
      title : "任务详情",
      url : url,
      redirectUrl : "/dq/task/list",
      method : "put",
      department : "d3",
      // expertRetrieveUrl : "experts",
      genExpertsUrl : "/dq/selectGroup/"+id,//生成专家
      taskExpertsUrl : "/dq/task/experts/"+id,//请求专家列表
      confirmUrl : "/dq/determineTask/"+id, // 确认名单
      replaceUrl : "/dq/selectGroupOne/"+id,//替换一个
      taskId:id
    }  
    
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/dqTaskExpert-bundle.js"></script>
  </body>
</html>
