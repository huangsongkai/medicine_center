<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>添加专家</title>
    <!-- Author: Song -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
      <link rel="stylesheet" href="/css/style.css"/>
  </head>
  <body>
  <jsp:include page="../template.jsp" flush="true"></jsp:include>
    <script type="text/javascript">
    var  selector = {
        gender:["男", "女"],
        attribution:["省直","哈尔滨","齐齐哈尔","牡丹江","佳木斯","大庆","鸡西","鹤岗","双鸭山","伊春","黑河","七台河","绥化","大兴安岭"]
      }
    var pageParas ={
      formInit :[
        {name:"id"} ,
        {name:"name"} ,
        {name:"gender"} ,
        {name:"attribution", alias:"归属地",type:"select", options:selector.attribution },
        {name:"age"} ,
        {name:"school"} ,
        {name:"degree"} ,
        {name:"work"} ,
        {name:"title"} ,
        {name:"phone"} ,
        {name:"bacteria"} ,
        {name:"category"} ,
        {name:"categoryTwo" , value : "无"} ,
        {name:"remarks"} ,
        {name:"source"}                             
      ],
      formExtend :[
        {name:"id", alias:"id" ,type:"hidden" } ,
        {name:"name", alias:"姓名", validator:{notNull:true}   } ,
        {name:"gender", alias:"性别", type:"select", options:["男", "女"]  } ,
        {name:"age", alias:"年龄", validator:{dataType:"number"} } ,
        {name:"school", alias:"毕业学校"  } ,
        {name:"degree", alias:"学历"  } ,
        {name:"work", alias:"工作单位" , validator:{notNull:true} } ,
        {name:"title", alias:"职务"  } ,
        {name:"phone", alias:"电话" , validator:{notNull:true} } ,
        {name:"remarks", alias:"备注"  } ,
        {name:"bacteria", alias:"无菌", type:"checkbox"} ,
        {name:"category", alias:"分类", type:"select", options:["检查组长", "生产组", "质量组"]   } ,
        {name:"source", alias:"科室来源", value:"七科", type:"readOnly"  }
      ],
      title : "添加专家",
      url : "/d7/experts",
      redirectUrl : "/d7/experts/list",
      method : "post"
    }  
    
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/editFormGenerator-bundle.js"></script>
  </body>
</html>
