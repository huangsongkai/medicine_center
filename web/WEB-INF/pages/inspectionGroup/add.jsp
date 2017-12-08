<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>inspectiongroup-add</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
</head>
<body>
<div id="root">
</div>
<div id="example">
</div>
<script type="text/javascript">
    //Caution: AUTO_INCREMENT id should be set the type:{delete}
    var pageParas ={
        formInit :[
                    {name:"groupId", placeholder:"groupId"} ,
                                {name:"taskId", placeholder:"taskId"} ,
                                {name:"category", placeholder:"category"} ,
                                {name:"categoryTwo", placeholder:"categoryTwo"} ,
                                {name:"num", placeholder:"num"} ,
                                {name:"state", placeholder:"state"}                             ],
        formExtend :[
                    {name:"groupId", alias:"groupId"  } ,
                            {name:"taskId", alias:"taskId"  } ,
                            {name:"category", alias:"category"  } ,
                            {name:"categoryTwo", alias:"categoryTwo"  } ,
                            {name:"num", alias:"num"  } ,
                            {name:"state", alias:"state"  }                  ],
        title : "添加inspectiongroup",
        url : "/inspectiongroup",
        redirectUrl : "/inspectiongroup/add",
        method : "post"
    /*
   example:
   {name:"id", alias:"价格(元)", type:"delete", defaultValue:"1234"},
   {name:"price", alias:"价格(元)", type:"password",validator:{dataType:"number",notNull:true}},
   {name:"mobile", alias:"手机", validator:{dataType:"mobile",notNull:true}},
   {name:"state", alias:"状态", type:"select", options:["上架","下架"]},
   {name:"email", alias:"邮箱",validator:{dataType:"email", minLength:"5", maxLength:"10", notNull:true}},
   * */
    }

</script>
<script src="/js/commonV3.js"></script>
<script src="/js/editFormGenerator-bundle.js"></script>
</body>
</html>

