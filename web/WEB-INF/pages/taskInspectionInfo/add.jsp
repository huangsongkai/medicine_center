<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>taskinspectioninfo-add</title>
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
                    {name:"id", placeholder:"id"} ,
                                {name:"taskId", placeholder:"taskId"} ,
                                {name:"inspectionUnit", placeholder:"inspectionUnit"} ,
                                {name:"attribution", placeholder:"attribution"} ,
                                {name:"checktype", placeholder:"checktype"}                             ],
        formExtend :[
                    {name:"id", alias:"id" ,type:"hidden" } ,
                            {name:"taskId", alias:"taskId"  } ,
                            {name:"inspectionUnit", alias:"inspectionUnit"  } ,
                            {name:"attribution", alias:"attribution"  } ,
                            {name:"checktype", alias:"checktype"  }                  ],
        title : "添加taskinspectioninfo",
        url : "/taskinspectioninfo",
        redirectUrl : "/taskinspectioninfo/add",
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

