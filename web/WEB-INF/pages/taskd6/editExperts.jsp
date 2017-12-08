<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>修改专家</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/js/bootstrapCssWrapper-bundle.js"></script>
    <!-- Author: Song -->
      <link rel="stylesheet" href="/css/style.css"/>
  </head>
  <body>
  <jsp:include page="../template.jsp" flush="true"></jsp:include>
    <script type="text/javascript">
      
    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/d5/experts/"+id;

    var selector = {
      gender:["男", "女"],
      category:["中药制剂", "化药制剂"],
      categoryTwo:{
        "组长":["注射剂", "中药", "化药", "氧气"],
        "监管机构":["注射剂", "中药", "化药", "氧气"],
        "检验检测机构":["中药", "化药"],
        "临床":["儿科", "风湿免疫", "妇科、乳腺", "骨科", "呼吸科", "外科", "消化科", "心内科", "神经科", "临床机构", "眼科", "皮肤科", "其他科"]
      },
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
        {name:"categoryTwo", alias:"专家类型", type:"hint",department:"6"},
        {name:"category", alias:"分类", type:"select", options:selector.category} ,
        {name:"remarks"} ,
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
        {name:"source", alias:"科室来源", value:"六科", type:"readOnly"  }
      ],
      title : "修改专家",
      url : url,
      redirectUrl : "/d6/experts/list",
      method : "put",
      button : "none",
      department : "d6",
      expertsId : id
    }
    </script>
    <script src="/js/commonV3.js"></script>
    <script src="/js/editFormGenerator-bundle.js?0705"></script>
  </body>
</html>
