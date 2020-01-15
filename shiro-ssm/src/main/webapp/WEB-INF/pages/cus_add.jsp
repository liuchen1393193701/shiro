<%--
  Created by IntelliJ IDEA.
  User: qq139
  Date: 2020/1/15
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加页面</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="<%=request.getContextPath()%>/statics/js/vue.js"></script>
</head>
<body>
    <div id="app">
        <form action="#">
            <p>
                <span>公司名</span>
                <input type="text" v-model="userForm.name">
            </p>
            <p>
                <span>联系人</span>
                <input type="text" v-model="userForm.linkman">
            </p>
            <p>
                <span>电话</span>
                <input type="text" v-model="userForm.phone">
            </p>
            <p>
                <span>日期</span>
                <input type="date" v-model="userForm.createdate">
            </p>
            <button @click="addCus">增加</button>

        </form>
    </div>
</body>
</html>
<script>
    var cm=new Vue({
        el:"#app",
        data:{
            userForm:{
                name:'',
                linkman: '',
                phone:'',
                createdate:'',
            }
        },
        methods:{
            addCus:function(){
                axios.post("http://localhost:8080/shiro_ssm_war_exploded/cus/addCus.html",{
                    name: cm.userForm.name,
                    linkman: cm.userForm.linkman,
                    phone: cm.userForm.phone,
                    createdate: cm.userForm.createdate
                }, {
                    header: {
                        'Content-Type': 'application/json'
                    }
                }).then(res=>{
                    console.log(res.msg);
                }).catch(err=>{
                    console.log(err.msg);

                });

            }
        }

    });
</script>
