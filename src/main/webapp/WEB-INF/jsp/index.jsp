<!DOCTYPE HTML>
<html lang="en">

<head>
	<title>Sofast</title>
	<%@include file="common/header.jsp" %>
</head>
<body ng-app="myApp" class="ng-scope">
<%@include file="common/page_access_header.jsp" %>
<div class="container" ng-controller="SearchStudentController as ctrl">
	<div class="page_title">Student List <a href="${pageContext.request.contextPath}/studentdetail/new" class="btn-link btn-xs btn pull-right">
		<span class="glyphicon glyphicon-plus"></span> New Student
	</a></div>
	<div class="clearfix row-border hover">
		<table datatable="" dt-options="ctrl.dtOptions" dt-columns="ctrl.dtColumns" class="table table-bordered"></table>
	</div>
</div>
<%@include file="common/footer.jsp" %>
<script src="<c:url value='/js/controller/search_student_controller.js' />"></script>
</body>

</html>