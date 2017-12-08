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
      selector: {
        jianguan:["注射剂", "医用氧"],   
        jianyan:["中药", "化药"]
      },

      formInit :[
        {name:"inspectionUnit", placeholder:"单位名称"},
        {name:"source", value:"二科"},
        {name:"leaderNum", value:"1"},
        {name:"jianguan", group:"jianguan", isRoot:"true", value:"1", validator:{notNull:true, dataType:"number"}},
        {name:"jianyan", group:"jianyan", isRoot:"true", value:"1", selectorValue:"化药", validator:{notNull:true, dataType:"number"}},
        {name:"executionTime", placeholder:"2016-01-01 09:30:00"}
      ],
      formExtend :[
        {name:"taskId", alias:"任务ID"},
        {name:"state", alias:"状态"},
        {name:"createTime", alias:"创建时间"},
        {name:"inspectionUnit", alias:"被检单位", validator:{notNull:true}},
        {name:"jianguan", alias:"监管人员"},
        {name:"attribution", alias:"归属地"},
        {name:"endExecutionTime", alias:"结束时间"},
        {name:"startExecutionTime", alias:"开始时间"},
        {name:"jianyan", alias:"检验人员"},
        {name:"checktype", alias:"业务类型"},
        {name:"source", alias:"科室", readOnly:"true"},
        {name:"leaderNum", alias:"组长人数", readOnly:"true"},
        {name:"executionTime", alias:"检查时间", validator:{dataType:"time", pattern:"yyyy-mm-dd hh:mm:ss", notNull:true}},
      ],
      title : "任务详情",
      url : url,
      redirectUrl : "/dq/task/list",
      method : "put",
      department : "d2",
      // expertRetrieveUrl : "experts",
      genExpertsUrl : "/dq/selectTwoGroup/"+id,//生成专家
      taskExpertsUrl : "/dq/task/experts/"+id,//请求专家列表
      confirmUrl : "/dq/determineTask/"+id, // 确认名单
      replaceUrl : "/dq/selectTwoGroupOne/"+id,//替换一个
      taskId:id
    }  
    
    
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/dqTaskExpert-bundle.js"></script>
  </body>
</html>
