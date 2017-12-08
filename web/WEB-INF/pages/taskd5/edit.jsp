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
    var url = "/d5/task/"+id;
    var pageParas ={
      selector: {
        zuzhang:["组长"],
        zuyuan:["组员"]
      },

      formInit :[
        {name:"inspectionUnit", placeholder:"单位名称"},
        {name:"source", value:"五科"},
        {name:"state", alias:"状态"},
        {name:"zuzhang", group:"zuzhang", isRoot:"true", value:"1", validator:{notNull:true, dataType:"number"}},
        {name:"groupList", group:"zuyuan", isRoot:"true", value:"1", validator:{notNull:true, dataType:"number"}},
        {name:"executionTime", placeholder:"2016-01-01 09:30:00"}
      ],
      formExtend :[
        {name:"inspectionUnit", alias:"被检单位", validator:{notNull:true}, readOnly:"true"},
        {name:"state", alias:"状态"},
        {name:"createTime", alias:"创建时间"},
        {name:"taskId", alias:"任务ID"},
        {name:"checktype", alias:"业务类型"},
        {name:"groupList", alias:"组员", readOnly:"true"},
        {name:"attribution", alias:"归属地"},
        {name:"checktype", alias:"检查类型"},
        {name:"startExecutionTime", alias:"开始时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true, readOnly:"true"}},
        {name:"endExecutionTime", alias:"结束时间", validator:{dataType:"time", pattern:"yyyy-mm-dd", notNull:true, readOnly:"true"}}
      ],
      title : "详细信息",
      url : url,
      redirectUrl : "/d5/task/list",
      taskExpertsUrl : "/d5/task/experts/"+id,
      alterUrl : "/d5/task/change",
      cancelUrl : "/d5/task/"+id,
      method : "put",
      button : "none",
      department : "d5",
      taskId : id
    }
    
    
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/dTaskExpertsEditGen-bundle.js"></script>
  </body>
</html>
