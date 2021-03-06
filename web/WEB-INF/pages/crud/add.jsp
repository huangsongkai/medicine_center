<!DOCTYPE html>
<html>
<head>
    <title>CRUD Example--Edit</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/static/bootstrapCssWrapper-bundle.js"></script>
    <!-- Author: Song -->
</head>
<body>
<div id="root">
</div>
<div id="example">
</div>
<script type="text/javascript">

    var id = window.location.pathname.substring(window.location.pathname.lastIndexOf("/")+1);
    var url = "/shop/id/"+id;
    var pageParas ={
        formInit :[
        ],
        formExtend :[
            {name:"createTime", type:"delete"},
            {name:"shopInfoId", type:"hidden"}
        ],
        title : "编辑商品",
        url : url,
        redirectUrl : "/redirect",
        method : "put"
    }
</script>
<script src="/static/commonV3.js"></script>
<script src="/static/editFormGenerator-bundle.js"></script>
</body>
</html>
