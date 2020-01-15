
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台首页面</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/zTree_v3/css/bootstrapStyle/bootstrapStyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/statics/zTree_v3/js/jquery.ztree.all.min.js"></script>
    <style type="text/css">
        .container{
            width: 1500px;
        }
        #leftsdd{
                  width: 200px;
                  height: 800px;
                  float: left;
                  border: 1px solid #ccc;

              }
        #right{
            width: 1250px;
            height: 800px;
            float: left;
            border: 1px solid #ccc;
        }
    </style>
    <script>
        $(function(){
            var setting = {
                view:{
                    showLine:true
                },
                data:{
                    simpleData:{
                        enable:true,
                        idKey:"id",
                        pIdKey:"pId",
                        rootPId:null
                    }
                },
                callback:{
                    onClick:openNew
                }

            };
            
            $.ajax({
                url:'leftMenu.html',
                type:"GET",
                dataType:"json",
                success:function (data) {
                    console.log(data);
                    ztreeObj=$.fn.zTree.init($("#treeDemo"),setting,data);
                    ztreeObj.expandAll(true);
                }
            })
        });
        function openNew(p1,p2,p3) {
            $("#title").html(p3.name);
            $("#content").attr("src",p3.url);
            event.preventDefault();
        }
    </script>
</head>
<body>

   <div class="container" style="margin: 0px auto;margin-bottom: 50px" >
       <div id="leftsdd">
           <ul id="treeDemo" class="ztree"></ul>
       </div>
       <div>
           <div id="right">
               <div id="title"></div>
               <div>
                   <iframe id="content" width="100%" height="750px" style="border: none"></iframe>
               </div>
           </div>
       </div>
   </div>
</body>
</html>
