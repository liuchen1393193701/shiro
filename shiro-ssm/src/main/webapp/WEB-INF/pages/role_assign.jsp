<%--
  Created by IntelliJ IDEA.
  User: 石头
  Date: 2020/1/9
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/zTree_v3/css/bootstrapStyle/bootstrapStyle.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/statics/zTree_v3/js/jquery.ztree.all.min.js"></script>
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
                check:{
                    enable:"true",
                }

            };

            $.ajax({
                url:'<%=request.getContextPath()%>/role/checkMenu.html',
                type:"GET",
                dataType:"json",
                success:function (data) {
                    console.log(data);
                    ztreeObj=$.fn.zTree.init($("#myTreeDemo"),setting,data);
                    ztreeObj.expandAll(true);
                    getCheck();
                }
            });
            $("#btn").click(function () {
                ztreeObj=$.fn.zTree.getZTreeObj("myTreeDemo");
                var nodes=ztreeObj.getCheckedNodes(true);
                console.log(nodes);
                var idArray="";
                for (var i=0;i<nodes.length;i++){
                    if (nodes[i].checked){
                        idArray+=nodes[i].id+","
                    }
                }
                idArray=idArray.substring(0,idArray.length-1);

                $.ajax({
                    url:'<%=request.getContextPath()%>/role/assignPerm.html',
                    type:'POST',
                    data:{"roleId":$("#roleIdH").val(),"perArray":idArray},
                    dataType:"json",
                    success:function (data) {
                        console.log(data.msg);
                        if (data.msg=="success"){
                            alert("分配成功");
                        }else {
                            alert("分配失败");
                        }
                    }
                });
            })

        });
        function getCheck() {
            var roleId = document.getElementById("roleIdH").value;
          $.ajax({
              url:'<%=request.getContextPath()%>/role/getCheck.html?roleId='+roleId,
              type:"GET",
              dataType:"json",
              success:function (data) {
                 var result = data;
                  ztreeObj=$.fn.zTree.getZTreeObj("myTreeDemo")
                  for (var i=0;i<result.length;i++){
                      ztreeObj.checkNode(ztreeObj.getNodeByParam("id",result[i]),true);
                  }

              }

          });
        }
    </script>
</head>
<body>
<H1>角色分配页面</H1>
<input type="hidden" id="roleIdH" value="${roleId}">
<div>

    <ul id="myTreeDemo" class="ztree"></ul>
</div>
<input type="button" value="重新分配权限" id="btn">
</body>
</html>
