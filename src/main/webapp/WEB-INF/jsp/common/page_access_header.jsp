<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header" ng-controller="AccountInfoController as ctrl">
    <div class="sys_room">
        <div class="wrapper">
            <span>Welcome, {{ctrl.userName}}</span>
            <a href="${pageContext.request.contextPath}/user/logout" class="pull-right"><span class="glyphicon glyphicon-off "></span> Logout</a></div>
    </div>
    <%@include file="page_header_logo.jsp" %>
</div>

