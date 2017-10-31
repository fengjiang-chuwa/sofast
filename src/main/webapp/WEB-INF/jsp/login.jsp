<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Sofast</title>
    <%@include file="common/header.jsp" %>
</head>
<body ng-app="myApp" class="ng-scope login_body">
<%@include file="common/page_header.jsp" %>
<div class="container" ng-controller="LoginController as ctl">
    <div class="login-main">
        <div class="well">
            <form  name="frmLogin" novalidate
                  autocomplete="off" class="form-horizontal">
                <span style="color:red;" ng-if="showErrorMsg" ng-bind-html="errorMsg" id="errorMsg"></span>
                <div class="form-group">
                    <label class="col-sm-4 control-label"> <span class="glyphicon glyphicon-user"></span> Login Name
                    </label>
                    <div class="col-sm-8"
                         ng-class="{ 'has-error' : frmLogin.email.$invalid && !frmLogin.email.$pristine }">
                        <input type="email" class="form-control" name="email" ng-model="ctl.loginInfo.email"
                               required>
                        <p ng-show="frmLogin.email.$invalid && !frmLogin.email.$pristine"
                           class="help-block">Email is empty or Email format is wrong.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-4 control-label"> <span
                            class=" glyphicon glyphicon-lock"></span> Password </label>
                    <div class="col-sm-8"
                         ng-class="{ 'has-error' : frmLogin.password.$invalid && !frmLogin.password.$pristine }">
                        <input type="password" class="form-control" name="password"
                               ng-model="ctl.loginInfo.password" required>
                        <p ng-show="frmLogin.password.$invalid && !frmLogin.password.$pristine"
                           class="help-block">Password is required.</p>
                    </div>
                </div>
            </form>
            <div class="">
                <button type="submit" ng-click="ctl.checkUser()" class="btn btn-primary btn-lg btn-block"><span
                        class="glyphicon glyphicon-ok"></span> Login
                </button>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
<script src="<c:url value='/js/service/login_service.js' />"></script>
<script src="<c:url value='/js/controller/login_controller.js' />"></script>
</body>
</html>
