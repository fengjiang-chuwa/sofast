<!DOCTYPE HTML>
<html lang="en">
<head>
	<title>Student Info</title>
    <%@include file="common/header.jsp" %>
</head>
<body ng-app="myApp" class="ng-scope">
<%@include file="common/page_header.jsp" %>
<div class="container" ng-controller="StudentInputController as ctrl">
	<div class="well">
		<form class="form-horizontal clearfix form_container" name="studentInputForm" novalidate>
			<div class="formTitle">Personal Information</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.firstName.$invalid && !studentInputForm.firstName.$pristine }">
					<input type="text" class="form-control" name="firstName" ng-model="ctrl.studentInputData.studentBasic.firstName" required maxlength="45">
                    <p ng-show="studentInputForm.firstName.$invalid && !studentInputForm.firstName.$pristine" class="help-block">First Name is required.</p>
				</div>
				<label class="col-sm-2 control-label">Family Name</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.familyName.$invalid && !studentInputForm.familyName.$pristine }">
					<input type="text" class="form-control" name="familyName" ng-model="ctrl.studentInputData.studentBasic.familyName" required maxlength="45">
                    <p ng-show="studentInputForm.familyName.$invalid && !studentInputForm.familyName.$pristine" class="help-block">Family Name is required.</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Passport Number</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.passportNumber.$invalid && !studentInputForm.passportNumber.$pristine }">
					<input type="text" class="form-control" name="passportNumber" ng-model="ctrl.studentInputData.studentBasic.passportNumber" required maxlength="45">
                    <p ng-show="studentInputForm.passportNumber.$invalid && !studentInputForm.passportNumber.$pristine" class="help-block">Passport Number is required.</p>
                </div>
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.applicantEmailAddress.$invalid && !studentInputForm.applicantEmailAddress.$pristine }">
					<input type="text" class="form-control" name="applicantEmailAddress" ng-model="ctrl.studentInputData.studentBasic.applicantEmailAddress" required maxlength="45">
                    <p ng-show="studentInputForm.applicantEmailAddress.$invalid && !studentInputForm.applicantEmailAddress.$pristine" class="help-block">Email is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth</label>
				<div class="col-sm-4">
                    <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : studentInputForm.dateOfBirth.$invalid && !studentInputForm.dateOfBirth.$pristine }">
                        <div class="input-group">
                            <input type="text" name="dateOfBirth" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="ctrl.studentInputData.studentBasic.dateOfBirth" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                            <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                <!-- ngIf: isOpen -->
                            </div>
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                            </span>
                        </div>
                        <p ng-show="studentInputForm.dateOfBirth.$invalid && !studentInputForm.dateOfBirth.$pristine" class="help-block">Date of Birth is required.</p>
                    </div>
                </div>
				<label class="col-sm-2 control-label">Country of Birth</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.countryOfBirth.$invalid && !studentInputForm.countryOfBirth.$pristine }">
                    <select class="form-control" id="countryOfBirth" ng-model="ctrl.studentInputData.studentBasic.countryOfBirth" name="countryOfBirth"
                            convert-to-string required>
                        <option value="">Please Select</option>
                        <option ng-repeat="country in ctrl.studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                    </select>
                    <p ng-show="studentInputForm.countryOfBirth.$invalid && !studentInputForm.countryOfBirth.$pristine" class="help-block">Country is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Nationality / Citizenship</label>
                <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.nationality.$invalid && !studentInputForm.nationality.$pristine }">
                    <select class="form-control" id="nationality" ng-model="ctrl.studentInputData.studentBasic.nationality" name="nationality"
                            convert-to-string required>
                        <option value="">Please Select</option>
                        <option ng-repeat="country in ctrl.studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                    </select>
                    <p ng-show="studentInputForm.nationality.$invalid && !studentInputForm.nationality.$pristine" class="help-block">Nationality is required.</p>
                </div>
			</div>
			<div class="subtitle">Contact Details</div>
            <span ng-repeat="address in ctrl.studentInputData.addressList">
                <div class="unit_title" ng-if="('home' === address.type)">Permanent Home Address</div>
                <div class="unit_title" ng-if="('mailing' === address.type)">Mailing Address</div>
                <div class="form-group">
                    <label class="col-xs-2 control-label">Address Line 1</label>
                    <div class="col-xs-4" ng-if="('home' === address.type)" ng-class="{ 'has-error' : studentInputForm.homeLine1.$invalid && !studentInputForm.homeLine1.$pristine }">
                        <input type="text" name="homeLine1" placeholder="" class="form-control" ng-model="address.line1" required maxlength="45">
                        <p ng-show="studentInputForm.homeLine1.$invalid && !studentInputForm.homeLine1.$pristine" class="help-block">Address Line 1 is required.</p>
                    </div>
                    <div class="col-xs-4" ng-if="('mailing' === address.type)" ng-class="{ 'has-error' : studentInputForm.mailingLine1.$invalid && !studentInputForm.mailingLine1.$pristine }">
                        <input type="text" name="mailingLine1" placeholder="" class="form-control" ng-model="address.line1" required maxlength="45">
                        <p ng-show="studentInputForm.mailingLine1.$invalid && !studentInputForm.mailingLine1.$pristine" class="help-block">Address Line 1 is required.</p>
                    </div>
                    <label class="col-xs-2 control-label">Address Line 2</label>
                    <div class="col-xs-4">
                        <input type="text" placeholder="" class="form-control" ng-model="address.line2">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-2 control-label">Country</label>
                    <div ng-if="('home' === address.type)" class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.homeCountry.$invalid && !studentInputForm.homeCountry.$pristine }">
                        <select class="form-control" ng-model="address.country" name="homeCountry" convert-to-string required>
                            <option value="">Please Select</option>
                            <option ng-repeat="country in ctrl.studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                        </select>
                        <p ng-show="studentInputForm.homeCountry.$invalid && !studentInputForm.homeCountry.$pristine" class="help-block">Country is required.</p>
                    </div>
                    <div ng-if="('mailing' === address.type)" class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.mailingCountry.$invalid && !studentInputForm.mailingCountry.$pristine }">
                        <select class="form-control" ng-model="address.country" name="mailingCountry" convert-to-string required>
                            <option value="">Please Select</option>
                            <option ng-repeat="country in ctrl.studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                        </select>
                        <p ng-show="studentInputForm.mailingCountry.$invalid && !studentInputForm.mailingCountry.$pristine" class="help-block">Country is required.</p>
                    </div>
                    <label class="col-xs-2 control-label">State / Province</label>
                    <div class="col-xs-4" ng-if="('home' === address.type)" ng-class="{ 'has-error' : studentInputForm.homeState.$invalid && !studentInputForm.homeState.$pristine }">
                        <input type="text" class="form-control" name="homeState" ng-model="address.state" required maxlength="45">
                        <p ng-show="studentInputForm.homeState.$invalid && !studentInputForm.homeState.$pristine" class="help-block">State is required.</p>
                    </div>
                    <div class="col-xs-4" ng-if="('mailing' === address.type)" ng-class="{ 'has-error' : studentInputForm.mailingState.$invalid && !studentInputForm.mailingState.$pristine }">
                        <input type="text" class="form-control" name="mailingState" ng-model="address.state" required maxlength="45">
                        <p ng-show="studentInputForm.mailingState.$invalid && !studentInputForm.mailingState.$pristine" class="help-block">State is required.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-2 control-label">City</label>
                    <div class="col-xs-4" ng-if="('home' === address.type)" ng-class="{ 'has-error' : studentInputForm.homeCity.$invalid && !studentInputForm.homeCity.$pristine }">
                        <input type="text" class="form-control" name="homeCity" ng-model="address.city" required maxlength="45">
                        <p ng-show="studentInputForm.homeCity.$invalid && !studentInputForm.homeCity.$pristine" class="help-block">City is required.</p>
                    </div>
                    <div class="col-xs-4" ng-if="('mailing' === address.type)" ng-class="{ 'has-error' : studentInputForm.mailingCity.$invalid && !studentInputForm.mailingCity.$pristine }">
                        <input type="text" class="form-control" name="mailingCity" ng-model="address.city" required maxlength="45">
                        <p ng-show="studentInputForm.mailingCity.$invalid && !studentInputForm.mailingCity.$pristine" class="help-block">City is required.</p>
                    </div>
                    <label class="col-xs-2 control-label">Zip Code / Postal Code</label>
                    <div class="col-xs-4" ng-if="('home' === address.type)" ng-class="{ 'has-error' : studentInputForm.homeZip.$invalid && !studentInputForm.homeZip.$pristine }">
                        <input type="text" class="form-control" name="homeZip" ng-model="address.zip" required maxlength="45">
                        <p ng-show="studentInputForm.homeZip.$invalid && !studentInputForm.homeZip.$pristine" class="help-block">Zip Code is required.</p>
                    </div>
                    <div class="col-xs-4" ng-if="('mailing' === address.type)" ng-class="{ 'has-error' : studentInputForm.mailingZip.$invalid && !studentInputForm.mailingZip.$pristine }">
                        <input type="text" class="form-control" name="mailingZip" ng-model="address.zip" required maxlength="45">
                        <p ng-show="studentInputForm.mailingZip.$invalid && !studentInputForm.mailingZip.$pristine" class="help-block">Zip Code is required.</p>
                    </div>
                </div>
            </span>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Phone Number</label>
                <div class="row">
                    <%--<div class="col-xs-4 ">--%>
                        <%--<div ng-controller="phoneNumber" class="drop_down ng-scope">--%>
                            <%--<label class="ng-binding">+86</label> <span class="arrow"></span>--%>
                            <%--<select name="repeatSelect" id="repeatSelect" ng-model="data.model" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty">--%>
                                <%--<!-- ngRepeat: option in data.availableOptions -->--%>
                                <%--<option ng-repeat="option in data.availableOptions" value="+86" class="ng-binding ng-scope">China (+86)</option>--%>
                                <%--<!-- end ngRepeat: option in data.availableOptions -->--%>
                                <%--<option ng-repeat="option in data.availableOptions" value="2" class="ng-binding ng-scope">China (+86)China (+86)China (+86)China (+86)</option>--%>
                                <%--<!-- end ngRepeat: option in data.availableOptions -->--%>
                                <%--<option ng-repeat="option in data.availableOptions" value="3" class="ng-binding ng-scope">Option C</option>--%>
                                <%--<!-- end ngRepeat: option in data.availableOptions -->--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.phoneId.$invalid && !studentInputForm.phoneId.$pristine }">
                        <input type="text" placeholder="phone number" name="phoneId" class="form-control" ng-model="ctrl.studentInputData.studentBasic.phoneId" required maxlength="45">
                        <p ng-show="studentInputForm.phoneId.$invalid && !studentInputForm.phoneId.$pristine" class="help-block">Phone is required.</p>
                    </div>
                </div>
			</div>
			<div class="subtitle ">Parents' Information</div>
            <span ng-repeat="relationship in ctrl.studentInputData.relationshipList">
                <div class="unit_title" ng-if="('father' === relationship.relationshipTitle)">Father's Info</div>
                <div class="unit_title" ng-if="('mother' === relationship.relationshipTitle)">Mother's Info</div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherName.$invalid && !studentInputForm.fatherName.$pristine }">
                        <input type="text" placeholder="name" name="fatherName" class="form-control" ng-model="ctrl.studentInputData.relationship.name" required maxlength="45">
                        <p ng-show="studentInputForm.fatherName.$invalid && !studentInputForm.fatherName.$pristine" class="help-block">Father's Name is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherName.$invalid && !studentInputForm.motherName.$pristine }">
                        <input type="text" placeholder="name" name="motherName" class="form-control" ng-model="ctrl.studentInputData.relationship.name" required maxlength="45">
                        <p ng-show="studentInputForm.motherName.$invalid && !studentInputForm.motherName.$pristine" class="help-block">Mother's Name is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherPhoneId.$invalid && !studentInputForm.motherPhoneId.$pristine }">
                        <input type="text" placeholder="phone number" name="motherPhoneId" class="form-control" ng-model="ctrl.studentInputData.relationship.phoneId" required maxlength="45">
                        <p ng-show="studentInputForm.motherPhoneId.$invalid && !studentInputForm.motherPhoneId.$pristine" class="help-block">Mother's Phone is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherPhoneId.$invalid && !studentInputForm.fatherPhoneId.$pristine }">
                        <input type="text" placeholder="phone number" name="fatherPhoneId" class="form-control" ng-model="ctrl.studentInputData.relationship.phoneId" required maxlength="45">
                        <p ng-show="studentInputForm.fatherPhoneId.$invalid && !studentInputForm.fatherPhoneId.$pristine" class="help-block">Father's Phone is required.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Education</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherEducation.$invalid && !studentInputForm.motherEducation.$pristine }">
                        <input type="text" placeholder="education" name="motherEducation" class="form-control" ng-model="ctrl.studentInputData.relationship.education" required maxlength="45">
                        <p ng-show="studentInputForm.motherEducation.$invalid && !studentInputForm.motherEducation.$pristine" class="help-block">Mother's Education is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherEducation.$invalid && !studentInputForm.fatherEducation.$pristine }">
                        <input type="text" placeholder="education" name="fatherEducation" class="form-control" ng-model="ctrl.studentInputData.relationship.education" required maxlength="45">
                        <p ng-show="studentInputForm.fatherEducation.$invalid && !studentInputForm.fatherEducation.$pristine" class="help-block">Father's Education is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Profession</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherProfession.$invalid && !studentInputForm.motherProfession.$pristine }">
                        <input type="text" placeholder="profession" name="motherProfession" class="form-control" ng-model="ctrl.studentInputData.relationship.profession" required maxlength="45">
                        <p ng-show="studentInputForm.motherProfession.$invalid && !studentInputForm.motherProfession.$pristine" class="help-block">Mother's Profession is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherProfession.$invalid && !studentInputForm.fatherProfession.$pristine }">
                        <input type="text" placeholder="profession" name="fatherProfession" class="form-control" ng-model="ctrl.studentInputData.relationship.profession" required maxlength="45">
                        <p ng-show="studentInputForm.fatherProfession.$invalid && !studentInputForm.fatherProfession.$pristine" class="help-block">Father's Profession is required.</p>
                    </div>
                </div>
            </span>
			<div class="subtitle ">Program Type</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Start Date</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.startDate.$invalid && !studentInputForm.startDate.$pristine }">
                    <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope">
                        <div class="input-group">
                            <input type="text" name="startDate" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="ctrl.studentInputData.studentInfo.startDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                            <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                <!-- ngIf: isOpen -->
                            </div>
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                            </span>
                        </div>
                    </div>
                    <p ng-show="studentInputForm.startDate.$invalid && !studentInputForm.startDate.$pristine" class="help-block">Start Date is required.</p>
				</div>
				<label class="col-sm-2 control-label">Target School / Major</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.targetSchool.$invalid && !studentInputForm.targetSchool.$pristine }">
					<input type="text" class="form-control" name="targetSchool" ng-model="ctrl.studentInputData.studentInfo.targetSchool" required maxlength="45">
                    <p ng-show="studentInputForm.targetSchool.$invalid && !studentInputForm.targetSchool.$pristine" class="help-block">Target School is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">First Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.firstChoice.$invalid && !studentInputForm.firstChoice.$pristine }">
					<input type="text" class="form-control" name="firstChoice" ng-model="ctrl.studentInputData.studentInfo.firstChoice" required maxlength="45">
                    <p ng-show="studentInputForm.firstChoice.$invalid && !studentInputForm.firstChoice.$pristine" class="help-block">First Choice is required.</p>
                </div>
				<label class="col-sm-2 control-label">Second Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.secondChoice.$invalid && !studentInputForm.secondChoice.$pristine }">
					<input type="text" class="form-control" name="secondChoice" ng-model="ctrl.studentInputData.studentInfo.secondChoice" required maxlength="45">
                    <p ng-show="studentInputForm.secondChoice.$invalid && !studentInputForm.secondChoice.$pristine" class="help-block">Second Choice is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Safety Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.safetyChoice.$invalid && !studentInputForm.safetyChoice.$pristine }">
					<input type="text" class="form-control" name="safetyChoice" ng-model="ctrl.studentInputData.studentInfo.safetyChoice" required maxlength="45">
                    <p ng-show="studentInputForm.safetyChoice.$invalid && !studentInputForm.safetyChoice.$pristine" class="help-block">Safety Choice is required.</p>
                </div>
				<label class="col-sm-2 control-label">Undecided / Undeclared</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.undecided.$invalid && !studentInputForm.undecided.$pristine }">
					<input type="text" class="form-control" name="undecided" ng-model="ctrl.studentInputData.studentInfo.undecided" maxlength="45">
                    <p ng-show="studentInputForm.undecided.$invalid && !studentInputForm.undecided.$pristine" class="help-block">Undecided is required.</p>
                </div>
			</div>
			<div class="formTitle">
                Education Information
				<p class="page_notice">Please list all middle/high schools attended from grade nine up to graduation from high school.</p>
			</div>
			<div class="subtitle">Most Recent Academic Study</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Name of highest qualification</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.nameOfHighestQualification.$invalid && !studentInputForm.nameOfHighestQualification.$pristine }">
					<input type="text" class="form-control" name="nameOfHighestQualification" ng-model="ctrl.studentInputData.studentInfo.nameOfHighestQualification" required maxlength="45">
                    <p ng-show="studentInputForm.nameOfHighestQualification.$invalid && !studentInputForm.fatherProfession.$pristine" class="help-block">Name of highest qualification is required.</p>
                </div>
			</div>
            <span ng-repeat="education in ctrl.studentInputData.educationInfoList">
                <div class="unit_title">School {{$index + 1}}</div>
                <div class="add_more">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">School Name</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.schoolName{{$index}}.$invalid && !studentInputForm.schoolName{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="schoolName{{$index}}" ng-model="education.schoolName" required maxlength="45">
                            <p ng-show="studentInputForm.schoolName{{$index}}.$invalid && !studentInputForm.schoolName{{$index}}.$pristine" class="help-block">School Name is required.</p>
                        </div>
                        <label class="col-sm-2 control-label">School Type</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.schoolType{{$index}}.$invalid && !studentInputForm.schoolType{{$index}}.$pristine }">
                            <select class="form-control" name="schoolType{{$index}}" ng-model="education.schoolType" required>
                                <option value="">Please Select</option>
                                <option value="Public">Public</option>
                                <option value="Private">Private</option>
                            </select>
                            <p ng-show="studentInputForm.schoolType{{$index}}.$invalid && !studentInputForm.schoolType{{$index}}.$pristine" class="help-block">School Type is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Level of study</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.levelOfStudy{{$index}}.$invalid && !studentInputForm.levelOfStudy{{$index}}.$pristine }">
                            <select class="form-control" name="levelOfStudy{{$index}}" ng-model="education.levelOfStudy" required>
                                <option value="">Please Select</option>
                                <option value="High school">High school</option>
                                <option value="Vocational school">Vocational school</option>
                                <option value="Undergraduate">Undergraduate</option>
                                <option value="Zhuanke">Zhuanke</option>
                            </select>
                            <p ng-show="studentInputForm.levelOfStudy{{$index}}.$invalid && !studentInputForm.levelOfStudy{{$index}}.$pristine" class="help-block">Level of study is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Study Start Date</label>
                        <div class="col-sm-4">
                            <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : studentInputForm.startDate{{$index}}.$invalid && !studentInputForm.startDate{{$index}}.$pristine }">
                                <div class="input-group">
                                    <input type="text" name="startDate{{$index}}" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="education.startDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                                    <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                        <!-- ngIf: isOpen -->
                                    </div>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </div>
                                <p ng-show="studentInputForm.startDate{{$index}}.$invalid && !studentInputForm.startDate{{$index}}.$pristine" class="help-block">Start Date is required.</p>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Study End Date</label>
                        <div class="col-sm-4">
                            <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : studentInputForm.endDate{{$index}}.$invalid && !studentInputForm.endDate{{$index}}.$pristine }">
                                <div class="input-group">
                                    <input type="text" name="endDate{{$index}}" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="education.endDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                                    <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                        <!-- ngIf: isOpen -->
                                    </div>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </div>
                                <p ng-show="studentInputForm.endDate{{$index}}.$invalid && !studentInputForm.endDate{{$index}}.$pristine" class="help-block">End Date is required.</p>
                            </div>
                        </div>
                    </div>
                    <div class="unit_title">School Address and Contact</div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Address Line 1</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.line1{{$index}}.$invalid && !studentInputForm.line1{{$index}}.$pristine }">
                            <input type="text" name="line1{{$index}}" placeholder="" class="form-control" ng-model="education.address.line1" required maxlength="45">
                            <p ng-show="studentInputForm.line1{{$index}}.$invalid && !studentInputForm.line1{{$index}}.$pristine" class="help-block">Address Line 1 is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">Address Line 2</label>
                        <div class="col-xs-4">
                            <input type="text" placeholder="" class="form-control" ng-model="address.line2">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Country</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.country{{$index}}.$invalid && !studentInputForm.country{{$index}}.$pristine }">
                            <select class="form-control" ng-model="education.address.country" name="country{{$index}}" convert-to-string required>
                                <option value="">Please Select</option>
                                <option ng-repeat="country in ctrl.studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                            </select>
                            <p ng-show="studentInputForm.country{{$index}}.$invalid && !studentInputForm.country{{$index}}.$pristine" class="help-block">Country is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">State / Province</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.state{{$index}}.$invalid && !studentInputForm.state{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="state{{$index}}" ng-model="education.address.state" required maxlength="45">
                            <p ng-show="studentInputForm.state{{$index}}.$invalid && !studentInputForm.state{{$index}}.$pristine" class="help-block">State is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">City</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.city{{$index}}.$invalid && !studentInputForm.city{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="city{{$index}}" ng-model="education.address.city" required maxlength="45">
                            <p ng-show="studentInputForm.city{{$index}}.$invalid && !studentInputForm.city{{$index}}.$pristine" class="help-block">City is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">Zip Code / Postal Code</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.zip{{$index}}.$invalid && !studentInputForm.zip{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="zip{{$index}}" ng-model="education.address.zip" required maxlength="45">
                            <p ng-show="studentInputForm.zip{{$index}}.$invalid && !studentInputForm.zip{{$index}}.$pristine" class="help-block">Zip Code is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Phone Number</label>
                        <div class="row">
                            <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.phoneId{{$index}}.$invalid && !studentInputForm.phoneId{{$index}}.$pristine }">
                                <input type="text" placeholder="phone number" name="phoneId{{$index}}" class="form-control" ng-model="education.phoneId" required maxlength="45">
                                <p ng-show="studentInputForm.phoneId{{$index}}.$invalid && !studentInputForm.phoneId{{$index}}.$pristine" class="help-block">Phone is required.</p>
                            </div>
                        </div>
                    </div>
                    <div class="subtitle"> <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.removeEducation($index)"><span class="glyphicon glyphicon-plus"></span> Remove</a> </div>
                </div>
            </span>
			<div class="subtitle">Other Previous Academic Study <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.addEducation()"><span class="glyphicon glyphicon-plus"></span> Add Academic Study</a> </div>

			<div class="formTitle">Required Documents Checklist</div>
			<div class="subtitle">Documents Details</div>
			<div class="listUpload">
				<div class="form-group " ng-repeat="x in files">
					<label class="col-sm-3 control-label">{{x}}</label>
					<div class="col-sm-9 ">
						<input type="file">
                    </div>
				</div>
			</div>
			<div class="formTitle">Recommender Information</div>
            <span ng-repeat="recommenderInfo in ctrl.studentInputData.recommenderInfoList">
                <div class="subtitle">Recommender</div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name of Recommender</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.nameOfRecommender{{$index}}.$invalid && !studentInputForm.nameOfRecommender{{$index}}.$pristine }">
                        <input type="text" class="form-control" name="nameOfRecommender{{$index}}" ng-model="recommenderInfo.nameOfRecommender" required maxlength="45">
                        <p ng-show="studentInputForm.nameOfRecommender{{$index}}.$invalid && !studentInputForm.nameOfRecommender{{$index}}.$pristine" class="help-block">Name of Recommender is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Job Title</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.jobTitle{{$index}}.$invalid && !studentInputForm.jobTitle{{$index}}.$pristine }">
                        <input type="text" class="form-control" name="jobTitle{{$index}}" ng-model="recommenderInfo.jobTitle" required maxlength="45">
                        <p ng-show="studentInputForm.jobTitle{{$index}}.$invalid && !studentInputForm.jobTitle{{$index}}.$pristine" class="help-block">Job Title is required.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Relationship</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.relationship{{$index}}.$invalid && !studentInputForm.relationship{{$index}}.$pristine }">
                        <input type="text" class="form-control" name="relationship{{$index}}" ng-model="recommenderInfo.relationship" required maxlength="45">
                        <p ng-show="studentInputForm.relationship{{$index}}.$invalid && !studentInputForm.relationship{{$index}}.$pristine" class="help-block">Relationship is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="row">
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.recommenderPhoneId{{$index}}.$invalid && !studentInputForm.recommenderPhoneId{{$index}}.$pristine }">
                            <input type="text" placeholder="phone number" name="recommenderPhoneId{{$index}}" class="form-control" ng-model="recommenderInfo.phoneId" required maxlength="45">
                            <p ng-show="studentInputForm.recommenderPhoneId{{$index}}.$invalid && !studentInputForm.recommenderPhoneId{{$index}}.$pristine" class="help-block">Phone is required.</p>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email Address</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.email{{$index}}.$invalid && !studentInputForm.email{{$index}}.$pristine }">
                        <input type="text" class="form-control" name="email{{$index}}" ng-model="recommenderInfo.email" required maxlength="45">
                        <p ng-show="studentInputForm.email{{$index}}.$invalid && !studentInputForm.email{{$index}}.$pristine" class="help-block">Email is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Cell/Telephone Number</label>
                    <div class="row">
                        <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.cellPhoneId{{$index}}.$invalid && !studentInputForm.cellPhoneId{{$index}}.$pristine }">
                            <input type="text" placeholder="cell phone number" name="cellPhoneId{{$index}}" class="form-control" ng-model="recommenderInfo.cellPhoneId" required maxlength="45">
                            <p ng-show="studentInputForm.cellPhoneId{{$index}}.$invalid && !studentInputForm.cellPhoneId{{$index}}.$pristine" class="help-block">Cell Phone is required.</p>
                        </div>
                    </div>
                </div>
                <div class="subtitle"> <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.removeRecommender($index)"><span class="glyphicon glyphicon-plus"></span> Remove</a> </div>
            </span>
            <div class="subtitle">Other Type of Recommender <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.addRecommender()"><span class="glyphicon glyphicon-plus"></span> Add Other Recommender</a> </div>
            <div class="formTitle">Standardized Test Account Information</div>
            <span ng-repeat="testAccount in ctrl.studentInputData.standardizedTestAccountInfoList">
                <div class="subtitle">Test Account</div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Test Account Name</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.accountName{{$index}}.$invalid && !studentInputForm.accountName{{$index}}.$pristine }">
                        <input type="text" name="accountName{{$index}}" class="form-control" ng-model="testAccount.accountName" required maxlength="45">
                        <p ng-show="studentInputForm.accountName{{$index}}.$invalid && !studentInputForm.accountName{{$index}}.$pristine" class="help-block">Account Name is required.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Username or ID</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.userName{{$index}}.$invalid && !studentInputForm.userName{{$index}}.$pristine }">
                        <input type="text" name="userName{{$index}}" class="form-control" ng-model="testAccount.userName" required maxlength="45">
                        <p ng-show="studentInputForm.userName{{$index}}.$invalid && !studentInputForm.userName{{$index}}.$pristine" class="help-block">Username is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.password{{$index}}.$invalid && !studentInputForm.password{{$index}}.$pristine }">
                        <input type="text" name="password{{$index}}" class="form-control" ng-model="testAccount.password" required maxlength="45">
                        <p ng-show="studentInputForm.password{{$index}}.$invalid && !studentInputForm.password{{$index}}.$pristine" class="help-block">Password is required.</p>
                    </div>
                </div>
                <div class="subtitle"> <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.removeTestAccount($index)"><span class="glyphicon glyphicon-plus"></span> Remove</a> </div>
            </span>
            <div class="subtitle">Other Test Account <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.addTestAccount()"><span class="glyphicon glyphicon-plus"></span> Add Other Test Account</a> </div>

			<div class="formTitle">Declaration</div>
			<div class="subtitle">Declaration Details</div>
			<div class="form-group article-room">
				<div class="">
					<p> I confirm that I Student Name have been duly appointed by Student Name, have permission to act on their behalf and confirm that to the best of my knowledge all the details supplied are accurate and correct. I understand that the giving of false or incomplete information may lead to the misguidance in college counselling process or refusal of admissions to colleges or cancellation of the applicant's enrolment. I confirm that the applicant has received a copy of the terms and conditions. </p>
				</div>
			</div>
			<div class="form-group button-room">
				<div class="">
					<label class="checkbox-inline">
						<input type="checkbox" ng-model="ctrl.studentInputData.studentInfo.declarationAgree"> I agree <span class="text-muted"></span>
                    </label>
				</div>
			</div>
			<div class="formTitle">Counselor Brag Sheet</div>
			<div class="textarea_room">
				<div class="form-group" ng-repeat="questionnaireSurvey in ctrl.studentInputData.questionnaireSurveyList">
                    <label class="col-sm-12 control-label">{{$index+1}}. {{questionnaireSurvey.question}}</label>
					<textarea class="form-control" ng-model="questionnaireSurvey.answer">{{questionnaireSurvey.answer}}</textarea>
				</div>
			</div>
			<div class="form-group button-room">
				<div class="text-center">
					<button type="button" class="btn btn-primary btn-lg" onclick="ctrl.saveStudentInfo()"> <span class="glyphicon glyphicon-ok "></span> Submit </button>
				</div>
			</div>
		</form>
	</div>
</div>
<%@include file="common/footer.jsp" %>
<script>
    var linkId = '${linkId}';
</script>
<script src="<c:url value='/js/controller/student_input_controller.js' />"></script>
<script src="<c:url value='/js/service/student_input_service.js' />"></script>
</body>
</html>