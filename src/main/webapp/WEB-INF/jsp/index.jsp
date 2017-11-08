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
		<p class="help-block table_msg" style="">
			<span class="success" ng-show="ctrl.showSuccess"><span class="glyphicon glyphicon-ok"></span> Email sent successfully. </span>
			<span class="failed" ng-show="ctrl.showError"><span class="glyphicon glyphicon-remove"></span> Email sent failed.</span>
		</p>
		<table datatable="" dt-options="ctrl.dtOptions" dt-columns="ctrl.dtColumns" class="table table-bordered"></table>
	</div>
</div>
<%@include file="common/footer.jsp" %>
<script src="<c:url value='/js/service/student_input_service.js' />"></script>
<script src="<c:url value='/js/controller/search_student_controller.js' />"></script>
</body>

</html>