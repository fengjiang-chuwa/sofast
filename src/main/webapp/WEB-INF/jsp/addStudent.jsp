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
<div class="container" ng-controller="StudentBasicController as ctrl">
    <div class="well">
        <div class="page_title">New Student</div>
        <form name="frmStudent" novalidate autocomplete="off" class="form-horizontal clearfix form_container">
            <div class="form-group">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-4"
                     ng-class="{ 'has-error' : frmStudent.firstName.$invalid && !frmStudent.firstName.$pristine }">
                    <input type="text" class="form-control" name="firstName"
                           ng-model="ctrl.studentBasicEntity.firstName"
                           required>
                    <p ng-show="!frmStudent.firstName.$pristine && frmStudent.firstName.$invalid"
                       class="help-block">First Name is required.</p>
                </div>
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-4"
                     ng-class="{ 'has-error' : frmStudent.familyName.$invalid && !frmStudent.familyName.$pristine }">
                    <input type="text" class="form-control" name="familyName"
                           ng-model="ctrl.studentBasicEntity.familyName"
                           required>
                    <p ng-show="frmStudent.familyName.$invalid && !frmStudent.familyName.$pristine"
                       class="help-block">Last Name is empty or Email format is wrong.</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Email</label>
                <div class="col-sm-4"
                     ng-class="{ 'has-error' : frmStudent.email.$invalid && !frmStudent.email.$pristine }">
                    <input type="email" class="form-control" name="email"
                           ng-model="ctrl.studentBasicEntity.applicantEmailAddress"
                           required>
                    <p ng-show="!frmStudent.email.$pristine && frmStudent.email.$error.required"
                       class="help-block">Email is required.</p>
                    <p ng-show="!frmStudent.email.$pristine && frmStudent.email.$error.email"
                       class="help-block">Email format is wrong.</p>
                </div>
                <label class="col-sm-2 control-label">Phone Number</label>
                <div class="col-sm-4"
                     ng-class="{ 'has-error' : frmStudent.phoneNumber.$invalid && !frmStudent.phoneNumber.$pristine }">
                    <input type="text" class="form-control"
                           ng-pattern="/1[0-9]{10}/"
                           name="phoneNumber" ng-model="ctrl.studentBasicEntity.phoneNumber"
                           required>
                    <p ng-show="frmStudent.phoneNumber.$invalid && !frmStudent.phoneNumber.$pristine"
                       class="help-block">Phone number is empty or Phone number format is wrong.</p>
                </div>
            </div>
            <div class="button-room ">
                <div class="alert alert-danger" role="alert" ng-show="showErrorMsg">{{errorMsg}}</div>
                <div class="text-center">
                    <button type="button" class="btn btn-primary" ng-click="ctrl.saveStudent()">
                        <span class="glyphicon glyphicon-ok "></span> Submit
                    </button>
                    <button type="button" class="btn btn-default" ng-click="ctrl.cancel()">
                        <span class="glyphicon glyphicon-ok "></span> Cancel
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@include file="common/footer.jsp" %>
<script src="<c:url value='/js/service/add_student_service.js' />"></script>
<script src="<c:url value='/js/controller/add_student_controller.js' />"></script>
</body>
</html>
