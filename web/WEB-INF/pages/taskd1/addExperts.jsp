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

      var selector = {
        gender:["男", "女"],
        category:["组长", "监管机构", "检验检测机构", "临床"],
        categoryTwo:{
          "组长":["注射剂", "中药", "化药", "氧气"],
          "监管机构":["注射剂", "中药", "化药", "氧气"],
          "检验检测机构":["中药", "化药"],
          "临床":["儿科", "风湿免疫", "妇科、乳腺", "骨科", "呼吸科", "外科", "消化科", "心内科", "神经科", "临床机构", "眼科", "皮肤科", "其他科"]
        }
      }
      var pageParas ={

        formInit :[
          {name:"id"} ,
          {name:"name"} ,
          {name:"gender"} ,
          {name:"age"} ,
          {name:"school"} ,
          {name:"degree"} ,
          {name:"work"} ,
          {name:"title"} ,
          {name:"phone"} ,
          {name:"category", selectGroup:[{name:"category", alias:"分类", type:"select"}, {name:"categoryTwo", alias:"科目", type:"select"}], selector:selector} ,
          {name:"remarks"} ,
          {name:"attribution"} ,
          {name:"source"}
        ],
        formExtend :[
          {name:"id", alias:"id" ,type:"hidden" } ,
          {name:"name", alias:"姓名", validator:{notNull:true}   } ,
          {name:"gender", alias:"性别", type:"select", options:selector.gender } ,
          {name:"age", alias:"年龄", validator:{dataType:"number",notNull:true} } ,
          {name:"school", alias:"毕业学校"  } ,
          {name:"degree", alias:"学历"  } ,
          {name:"work", alias:"工作单位" , validator:{notNull:true} } ,
          {name:"title", alias:"职务"  } ,
          {name:"phone", alias:"电话" , validator:{notNull:true} } ,
          {name:"remarks", alias:"备注"  } ,
          {name:"category", alias:"分类", type:"select", options:selector.category} ,
          {name:"source", alias:"科室来源", value:"二科", type:"readOnly"  }
        ],
        title : "添加专家",
        url : "/d1/experts",
        redirectUrl : "/d1/experts/list",
        method : "post"
      }

    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/editFormGenerator-bundle.js"></script>
  </body>
</html>
