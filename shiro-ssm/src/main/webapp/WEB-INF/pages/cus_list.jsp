<%--
  Created by IntelliJ IDEA.
  User: qq139
  Date: 2020/1/15
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="<%=request.getContextPath()%>/statics/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/statics/js/vue.js"></script>
</head>
<body>
    <div id="app">
        <input type="text" v-model="name">
        <button @click="loadData">查询</button>
        <button @click="addCusPage">增加数据</button>
        <table border="1px">
            <tr v-for="cus in cusList">
                <td>{{cus.name}}</td>
                <td>{{cus.linkman}}</td>
                <td>{{cus.phone}}</td>
                <td>{{cus.createdate|formatDate()}}</td>
            </tr>
        </table>
    </div>
</body>
</html>
<script>
    var vm=new Vue({
        el:"#app",
        data:{
            name:'',
            cusList:[]
        },
        mounted:list,
        filters:{
              formatDate:function (arg0) {
                  var date=new Date(arg0);
                  var year=date.getFullYear();
                  var month=date.getMonth();
                  if (month<10){
                      month="0"+month;
                  }
                  var day=date.getDate();
                  if (day<10){
                      day="0"+day;
                  }
                  var info=year+"-"+month+"-"+day;
                  return info;
              }
        },
        methods:{
            loadData:list,
            addCusPage:function () {
                window.location.href="<%=request.getContextPath()%>/cus/goAdd.html";
            }
        },

    });
    function list() {
        axios.get('http://localhost:8080/shiro_ssm_war_exploded/cus/findAll.html',{
            params:{
                name: this.name
            }
        }).then(res=>{
            console.log(res.data);
            this.cusList=res.data;
        }).catch(err=>{
            console.log(err);
        });
    }
</script>
