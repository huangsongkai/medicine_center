<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>user-add</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<jsp:include page="../template.jsp" flush="true"></jsp:include>
<script type="text/javascript">
    var pageParas ={
        formInit :[
            {name:"id", alias:"id" ,type:"hidden" } ,
            {name:"name"} ,
            {name:"directive"} ,
            {name:"mobile", alias:"手机"} ,
            {name:"password",validator:{notNull:true}  }
        ],
        formExtend :[
            {name:"id", alias:"ID" ,type:"hidden" } ,
            {name:"name", alias:"姓名", validator:{notNull:true}  } ,
            {name:"directive", alias:"科室", type:"select", options:["一科","二科", "三科","四科","五科", "六科", "质量科"] } ,
            {name:"password", alias:"登录密码"  }],
        title : "添加user",
        url : "/admin/user",
        redirectUrl : "/admin/user/list",
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

