<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>expertscdlog-add</title>
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
                                {name:"expertsId", placeholder:"expertsId"} ,
                                {name:"name", placeholder:"name"} ,
                                {name:"gender", placeholder:"gender"} ,
                                {name:"age", placeholder:"age"} ,
                                {name:"school", placeholder:"school"} ,
                                {name:"degree", placeholder:"degree"} ,
                                {name:"work", placeholder:"work"} ,
                                {name:"title", placeholder:"title"} ,
                                {name:"phone", placeholder:"phone"} ,
                                {name:"remarks", placeholder:"remarks"} ,
                                {name:"leader", placeholder:"leader"} ,
                                {name:"bacteria", placeholder:"bacteria"} ,
                                {name:"category", placeholder:"category"} ,
                                {name:"categoryTwo", placeholder:"categoryTwo"} ,
                                {name:"categoryThree", placeholder:"categoryThree"} ,
                                {name:"source", placeholder:"source"} ,
                                {name:"attribution", placeholder:"attribution"} ,
                                {name:"user", placeholder:"user"} ,
                                {name:"type", placeholder:"type"}                             ],
        formExtend :[
                    {name:"id", alias:"id" ,type:"hidden" } ,
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
                            {name:"category", alias:"category"  } ,
                            {name:"categoryTwo", alias:"categoryTwo"  } ,
                            {name:"categoryThree", alias:"categoryThree"  } ,
                            {name:"source", alias:"source"  } ,
                            {name:"attribution", alias:"attribution"  } ,
                            {name:"user", alias:"user"  } ,
                            {name:"type", alias:"type"  }                  ],
        title : "添加expertscdlog",
        url : "/expertscdlog",
        redirectUrl : "/expertscdlog/add",
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

