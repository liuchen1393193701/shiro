<%--
  Created by IntelliJ IDEA.
  User: 石头
  Date: 2020/1/9
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分配角色</title>
    <script src="<%=request.getContextPath()%>/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script>
        $(function(){
            $("#assignBtn").click(function () {
                var ckArray=$(".ck");
                var roleArray="";
                for (var i=0;i<ckArray.length;i++){
                    if (ckArray[i].checked){
                       roleArray+=ckArray[i].value+","
                    }
                }
                roleArray=roleArray.substring(0,roleArray.length-1);
                var userId=$("#userIdHidden").val();
               $.ajax({
                   url:'<%=request.getContextPath()%>/user/assignRole.html',
                   type:'POST',
                   data:{"userId":userId,"roleArray":roleArray},
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
            });
        });
    </script>

    <style>
        *{
            font-size: 25px;
        }
    </style>

</head>
<body>
    <c:forEach var="roleItem" items="${roleList}" >
        <input type="checkbox" class="ck" ${roleItem.checked} value="${roleItem.role.id}">${roleItem.role.name}
    </c:forEach>
    <input type="hidden" id="userIdHidden" value="${userId}">
    <input type="button" value="重新分配角色" id="assignBtn"/>
</body>
</html>
