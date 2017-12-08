<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>experts-edit</title>
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
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/experts/"+id;
    var pageParas ={
        formInit :[
        ],
        formExtend :[
                            {name:"id", alias:"id" ,type:"hidden" } ,
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
                                        {name:"source", alias:"source"  }                      ],
        title : "修改experts",
        url : url,
        redirectUrl : "/experts/list",
        method : "put"
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

