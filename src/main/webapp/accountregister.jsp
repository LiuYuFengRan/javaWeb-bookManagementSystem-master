
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <title>用户注册界面</title>
    <script>
        window.onload=function () {
            document.getElementById("imgcheckcode").onclick=reflushCheckCode;
        }
        function reflushCheckCode(){
            var imgcheckcode = document.getElementById("imgcheckcode");
            imgcheckcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>

</head>
<body>
<div  style="width: 40%;margin-left: 35%;margin-top: 8%;">
    <form method="post" action="${pageContext.request.contextPath}/accountRegisterServlet" >
        <div class="input-group " style="width: 200px;">
            <span class="input-group-addon">账号</span>
            <input type="text" class="form-control" placeholder="请输入账号" name="name" required="required" value="${name}" >
            <c:if test="${register_err eq '该账号已被注册'}">
                <span class="glyphicon glyphicon-remove" style="font-size: 20px;color: red;" id="register_err"></span>
            </c:if>
            <c:if test="${empty register_err}">
                <script>
                    var elementById = document.getElementById("register_err");
                    if (elementById!=null){
                        elementById.remove();
                    }
                </script>
            </c:if>
        </div>
        <br>
        <div class="input-group" style="width: 200px;">
            <span class="input-group-addon">密码</span>
            <input type="password" class="form-control" placeholder="请输入密码" name="password" required="required" value="${password}" >
        </div>

        <br>
        <div class="input-group" style="width: 200px;">
            <span class="input-group-addon">联系</span>
            <input type="text" class="form-control" placeholder="请输入联系方式" name="phone" required="required" value="${phone}" >
        </div>

        <br>
        <div class="input-group" style="width: 200px;">
            <span class="input-group-addon">邮箱</span>
            <input type="email" class="form-control" placeholder="请输入联系方式" name="email" required="required" value="${email}" >
        </div>

        <br>
        <div class="form-group" style="width: 220px;">
            <span>类型：</span>
            <c:if test="${type eq '管理员'}">
                <label class="radio-inline">
                    <input type="radio"  value="游客" name="type" >游客
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="普通用户" name="type">普通用户
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="管理员" name="type" checked="checked">管理员
                </label>
            </c:if>

            <c:if test="${type eq '普通用户'}">
                <label class="radio-inline">
                    <input type="radio"  value="游客" name="type" >游客
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="普通用户" name="type" checked="checked">普通用户
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="管理员" name="type" >管理员
                </label>
            </c:if>

            <c:if test="${type eq '游客'}">
                <label class="radio-inline">
                    <input type="radio"  value="游客" name="type" checked="checked" >游客
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="普通用户" name="type" >普通用户
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="管理员" name="type" >管理员
                </label>
            </c:if>

            <c:if test="${empty type}">
                <label class="radio-inline">
                    <input type="radio"  value="游客" name="type" >游客
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="普通用户" name="type" checked="checked">普通用户
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="管理员" name="type" >管理员
                </label>
            </c:if>
        </div>


        <br>
        <div class="form-group" style="width: 220px;">
            <span>性别：</span>
            <c:if test="${sex eq '男'}">
                <label class="radio-inline">
                    <input type="radio"  value="男性" name="sex" checked="checked">男性
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="女性" name="sex">女性
                </label>

            </c:if>

            <c:if test="${sex eq '女'}">
                <label class="radio-inline">
                    <input type="radio"  value="男性" name="sex" >男性
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="女性" name="sex" checked="checked">女性
                </label>
            </c:if>
            <c:if test="${empty sex}">
                <label class="radio-inline">
                    <input type="radio"  value="男性" name="sex"  checked="checked">男性
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="女性" name="sex">女性
                </label>
            </c:if>
        </div>
            <div class="form-group">
                <label for="checkcode" stype="display:inline;">验证码：</label>
                <input type="text" name="checkcode" class="form-control" id="checkcode" style="display:inline;width:110px;"  placeholder="请输入验证码" value="${checkcode}"/>
                <img src="${pageContext.request.contextPath}/checkCodeServlet" id="imgcheckcode" onclick="reflushCheckCode()" title="看不清？点击刷新一下"/>
                <c:if test="${checkcode_err eq '验证码错误'}">
                    <span class="glyphicon glyphicon-remove" style="font-size: 20px;color:red;"></span>
                </c:if>
                <c:if test="${checkcode_err eq '验证码正确'}">
                    <span class="glyphicon glyphicon-ok" style="font-size: 20px;color: green;"></span>
                </c:if>
            </div>
        <div class="form-group" style="align-items: center;" >
            <button type="submit" class="btn btn-primary" style="width: 80px;margin-left: 60px; margin-top: 5px;" onclick="fun1()">立即注册</button>
        </div>
    </form>
</div>
<script>
    function isTelCode(str){
        var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
        return reg.test(str);
    }

    function isEmail(str){
        var reg = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,3}){1,2}$/;
        return reg.test(str);
    }
    function isPwd(str){
        var reg= /^(\w|\d){6,16}$/;
        return reg.test(str);
    }
    function fun1(){
        if(!(document.getElementById("password").value)){
            alert('请输入密码!');
            return false;
        }
        if(!isPwd(document.getElementById("password").value)){
            alert('密码格式错误!');
            return false;
        }
        if(!(document.getElementById("phone").value)){
            alert("请输入手机号码！");
            document.getElementById("phone").focus();
            return false;
        }
        if(!isTelCode(document.getElementById("phone").value)){
            alert("手机号码不正确！");
            document.getElementById("phone").focus();
            return false;
        }
        if(!(document.getElementById("email").value)){
            alert("请输入邮箱地址");
            document.getElementById("email").focus();
            return false;
        }
        if(!isEmail(document.getElementById("email").value)){
            alert("邮箱地址错误！");
            document.getElementById("email").focus();
            return false;
        }
        alert("恭喜您注册成功！");
        return true;
    }


</script>
</body>
</html>

