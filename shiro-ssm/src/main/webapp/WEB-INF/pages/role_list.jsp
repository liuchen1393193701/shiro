
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            font-size: 25px;
        }
        .pager{
            position: relative;
        }
        .pager ul{
            position: absolute;
            right: 200px;
        }
        .pager ul li{
            float: left;
            margin-left: 5px;
            list-style: none;
        }
        a{
            text-decoration: none;
        }
    </style>
    <script>
        function goPage(page) {
            window.location.href="<%=request.getContextPath()%>/role/goList.html?currentPage="+page;
        }
        function goAssign(roleId) {
            window.location.href="<%=request.getContextPath()%>/role/goAssign.html?roleId="+roleId;
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5" width="80%" style="margin: 0px auto">
    <tr>
        <td>序号</td>
        <td>角色名</td>
        <td>角色描述</td>
        <td>操作</td>
    </tr>
    <c:forEach var="role" items="${requestScope.roleList}" varStatus="i">
    <tr>
        <td>${i.index+1}</td>
        <td>${role.name}</td>
        <td>${role.bz}</td>
        <td><a href="javascript:goAssign(${role.id})">分配权限</a></td>
    </tr>
    </c:forEach>
</table>
<div class="pager">
    <ul>
        <li>当前第${currentPage}页 共${totalPages}页</li>
        <li><a href="javascript:goPage(1)">首页</a></li>
        <li><a href="javascript:goPage(${currentPage-1})">上一页</a></li>
        <li><a href="javascript:goPage(${currentPage+1})">下一页</a></li>
        <li><a href="javascript:goPage(${totalPages})">尾页</a></li>
        <li>共${count}条记录</li>

    </ul>
</div>
</body>
</html>
