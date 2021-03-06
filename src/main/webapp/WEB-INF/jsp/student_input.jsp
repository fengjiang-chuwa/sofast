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
					<input type="text" class="form-control" name="firstName" ng-model="studentInputData.studentBasic.firstName" required maxlength="45">
                    <p ng-show="studentInputForm.firstName.$invalid && !studentInputForm.firstName.$pristine" class="help-block">First Name is required.</p>
				</div>
				<label class="col-sm-2 control-label">Family Name</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.familyName.$invalid && !studentInputForm.familyName.$pristine }">
					<input type="text" class="form-control" name="familyName" ng-model="studentInputData.studentBasic.familyName" required maxlength="45">
                    <p ng-show="studentInputForm.familyName.$invalid && !studentInputForm.familyName.$pristine" class="help-block">Family Name is required.</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Passport Number</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.passportNumber.$invalid && !studentInputForm.passportNumber.$pristine }">
					<input type="text" class="form-control" name="passportNumber" ng-model="studentInputData.studentBasic.passportNumber" required maxlength="45">
                    <p ng-show="studentInputForm.passportNumber.$invalid && !studentInputForm.passportNumber.$pristine" class="help-block">Passport Number is required.</p>
                </div>
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.applicantEmailAddress.$invalid && !studentInputForm.applicantEmailAddress.$pristine }">
					<input type="email" class="form-control" name="applicantEmailAddress" ng-model="studentInputData.studentBasic.applicantEmailAddress" required maxlength="45">
                    <p ng-show="studentInputForm.applicantEmailAddress.$invalid && !studentInputForm.applicantEmailAddress.$pristine" class="help-block">Email is empty or Email format is wrong.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth</label>
				<div class="col-sm-4">
                    <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : studentInputForm.dateOfBirth.$invalid && !studentInputForm.dateOfBirth.$pristine }">
                        <div class="input-group">
                            <input type="text" name="dateOfBirth" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="studentInputData.studentBasic.dateOfBirth" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
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
                    <select class="form-control" id="countryOfBirth" ng-model="studentInputData.studentBasic.countryOfBirth" name="countryOfBirth"
                            convert-to-string required>
                        <option value="">Please Select</option>
                        <option ng-repeat="country in studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                    </select>
                    <p ng-show="studentInputForm.countryOfBirth.$invalid && !studentInputForm.countryOfBirth.$pristine" class="help-block">Country is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Nationality / Citizenship</label>
                <div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.nationality.$invalid && !studentInputForm.nationality.$pristine }">
                    <select class="form-control" id="nationality" ng-model="studentInputData.studentBasic.nationality" name="nationality"
                            convert-to-string required>
                        <option value="">Please Select</option>
                        <option ng-repeat="country in studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                    </select>
                    <p ng-show="studentInputForm.nationality.$invalid && !studentInputForm.nationality.$pristine" class="help-block">Nationality is required.</p>
                </div>
			</div>
			<div class="subtitle">Contact Details</div>
            <span ng-repeat="address in studentInputData.addressList">
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
                            <option ng-repeat="country in studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                        </select>
                        <p ng-show="studentInputForm.homeCountry.$invalid && !studentInputForm.homeCountry.$pristine" class="help-block">Country is required.</p>
                    </div>
                    <div ng-if="('mailing' === address.type)" class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.mailingCountry.$invalid && !studentInputForm.mailingCountry.$pristine }">
                        <select class="form-control" ng-model="address.country" name="mailingCountry" convert-to-string required>
                            <option value="">Please Select</option>
                            <option ng-repeat="country in studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
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
			<div class="form-group">
				<label class="col-xs-2 control-label ">Phone Number</label>
                <div class="col-xs-4" ng-class="{ 'has-error' : studentInputForm.phoneId.$invalid && !studentInputForm.phoneId.$pristine }">
                    <input type="text" placeholder="phone number" name="phoneId" class="form-control" ng-model="studentInputData.studentBasic.phoneId" required maxlength="45">
                    <p ng-show="studentInputForm.phoneId.$invalid && !studentInputForm.phoneId.$pristine" class="help-block">Phone is required.</p>
                </div>
			</div>
			<div class="subtitle ">Parents' Information</div>
            <span ng-repeat="relationship in studentInputData.relationshipList">
                <div class="unit_title" ng-if="('father' === relationship.relationshipTitle)">Father's Info</div>
                <div class="unit_title" ng-if="('mother' === relationship.relationshipTitle)">Mother's Info</div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherName.$invalid && !studentInputForm.fatherName.$pristine }">
                        <input type="text" placeholder="name" name="fatherName" class="form-control" ng-model="relationship.name" required maxlength="45">
                        <p ng-show="studentInputForm.fatherName.$invalid && !studentInputForm.fatherName.$pristine" class="help-block">Father's Name is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherName.$invalid && !studentInputForm.motherName.$pristine }">
                        <input type="text" placeholder="name" name="motherName" class="form-control" ng-model="relationship.name" required maxlength="45">
                        <p ng-show="studentInputForm.motherName.$invalid && !studentInputForm.motherName.$pristine" class="help-block">Mother's Name is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherPhoneId.$invalid && !studentInputForm.motherPhoneId.$pristine }">
                        <input type="text" placeholder="phone number" name="motherPhoneId" class="form-control" ng-model="relationship.phoneId" required maxlength="45">
                        <p ng-show="studentInputForm.motherPhoneId.$invalid && !studentInputForm.motherPhoneId.$pristine" class="help-block">Mother's Phone is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherPhoneId.$invalid && !studentInputForm.fatherPhoneId.$pristine }">
                        <input type="text" placeholder="phone number" name="fatherPhoneId" class="form-control" ng-model="relationship.phoneId" required maxlength="45">
                        <p ng-show="studentInputForm.fatherPhoneId.$invalid && !studentInputForm.fatherPhoneId.$pristine" class="help-block">Father's Phone is required.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Education</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherEducation.$invalid && !studentInputForm.motherEducation.$pristine }">
                        <input type="text" placeholder="education" name="motherEducation" class="form-control" ng-model="relationship.education" required maxlength="45">
                        <p ng-show="studentInputForm.motherEducation.$invalid && !studentInputForm.motherEducation.$pristine" class="help-block">Mother's Education is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherEducation.$invalid && !studentInputForm.fatherEducation.$pristine }">
                        <input type="text" placeholder="education" name="fatherEducation" class="form-control" ng-model="relationship.education" required maxlength="45">
                        <p ng-show="studentInputForm.fatherEducation.$invalid && !studentInputForm.fatherEducation.$pristine" class="help-block">Father's Education is required.</p>
                    </div>
                    <label class="col-sm-2 control-label">Profession</label>
                    <div class="col-sm-4" ng-if="('mother' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.motherProfession.$invalid && !studentInputForm.motherProfession.$pristine }">
                        <input type="text" placeholder="profession" name="motherProfession" class="form-control" ng-model="relationship.profession" required maxlength="45">
                        <p ng-show="studentInputForm.motherProfession.$invalid && !studentInputForm.motherProfession.$pristine" class="help-block">Mother's Profession is required.</p>
                    </div>
                    <div class="col-sm-4" ng-if="('father' === relationship.relationshipTitle)" ng-class="{ 'has-error' : studentInputForm.fatherProfession.$invalid && !studentInputForm.fatherProfession.$pristine }">
                        <input type="text" placeholder="profession" name="fatherProfession" class="form-control" ng-model="relationship.profession" required maxlength="45">
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
                            <input type="text" name="startDate" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="studentInputData.studentInfo.startDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
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
					<input type="text" class="form-control" name="targetSchool" ng-model="studentInputData.studentInfo.targetSchool" required maxlength="45">
                    <p ng-show="studentInputForm.targetSchool.$invalid && !studentInputForm.targetSchool.$pristine" class="help-block">Target School is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">First Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.firstChoice.$invalid && !studentInputForm.firstChoice.$pristine }">
					<input type="text" class="form-control" name="firstChoice" ng-model="studentInputData.studentInfo.firstChoice" required maxlength="45">
                    <p ng-show="studentInputForm.firstChoice.$invalid && !studentInputForm.firstChoice.$pristine" class="help-block">First Choice is required.</p>
                </div>
				<label class="col-sm-2 control-label">Second Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.secondChoice.$invalid && !studentInputForm.secondChoice.$pristine }">
					<input type="text" class="form-control" name="secondChoice" ng-model="studentInputData.studentInfo.secondChoice" required maxlength="45">
                    <p ng-show="studentInputForm.secondChoice.$invalid && !studentInputForm.secondChoice.$pristine" class="help-block">Second Choice is required.</p>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Safety Choice</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.safetyChoice.$invalid && !studentInputForm.safetyChoice.$pristine }">
					<input type="text" class="form-control" name="safetyChoice" ng-model="studentInputData.studentInfo.safetyChoice" required maxlength="45">
                    <p ng-show="studentInputForm.safetyChoice.$invalid && !studentInputForm.safetyChoice.$pristine" class="help-block">Safety Choice is required.</p>
                </div>
				<label class="col-sm-2 control-label">Undecided / Undeclared</label>
				<div class="col-sm-4" ng-class="{ 'has-error' : studentInputForm.undecided.$invalid && !studentInputForm.undecided.$pristine }">
					<input type="text" class="form-control" name="undecided" ng-model="studentInputData.studentInfo.undecided" maxlength="45" required>
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
					<input type="text" class="form-control" name="nameOfHighestQualification" ng-model="studentInputData.studentInfo.nameOfHighestQualification" required maxlength="45">
                    <p ng-show="studentInputForm.nameOfHighestQualification.$invalid && !studentInputForm.fatherProfession.$pristine" class="help-block">Name of highest qualification is required.</p>
                </div>
			</div>
            <span ng-repeat="education in studentInputData.educationInfoList">
                <div class="subtitle">School {{$index + 1}}<a class="btn btn-xs btn-link btn_link_red pull-right" ng-click="ctrl.removeEducation($index)"><span class="glyphicon glyphicon-trash"></span> Remove</a></div>
                <div class="add_more" ng-form="educationForm{{$index}}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">School Name</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : educationForm{{$index}}.schoolName{{$index}}.$invalid && !educationForm{{$index}}.schoolName{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="schoolName{{$index}}" ng-model="education.schoolName" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.schoolName{{$index}}.$invalid && !educationForm{{$index}}.schoolName{{$index}}.$pristine" class="help-block">School Name is required.</p>
                        </div>
                        <label class="col-sm-2 control-label">School Type</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : educationForm{{$index}}.schoolType{{$index}}.$invalid && !educationForm{{$index}}.schoolType{{$index}}.$pristine }">
                            <select class="form-control" name="schoolType{{$index}}" ng-model="education.type" required>
                                <option value="">Please Select</option>
                                <option value="Public">Public</option>
                                <option value="Private">Private</option>
                            </select>
                            <p ng-show="educationForm{{$index}}.schoolType{{$index}}.$invalid && !educationForm{{$index}}.schoolType{{$index}}.$pristine" class="help-block">School Type is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Level of study</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : educationForm{{$index}}.levelOfStudy{{$index}}.$invalid && !educationForm{{$index}}.levelOfStudy{{$index}}.$pristine }">
                            <select class="form-control" name="levelOfStudy{{$index}}" ng-model="education.levelOfStudy" required>
                                <option value="">Please Select</option>
                                <option value="High school">High school</option>
                                <option value="Vocational school">Vocational school</option>
                                <option value="Undergraduate">Undergraduate</option>
                                <option value="Zhuanke">Zhuanke</option>
                            </select>
                            <p ng-show="educationForm{{$index}}.levelOfStudy{{$index}}.$invalid && !educationForm{{$index}}.levelOfStudy{{$index}}.$pristine" class="help-block">Level of study is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Study Start Date</label>
                        <div class="col-sm-4">
                            <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : educationForm{{$index}}.startDate{{$index}}.$invalid && !educationForm{{$index}}.startDate{{$index}}.$pristine }">
                                <div class="input-group">
                                    <input type="text" name="startDate{{$index}}" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="education.startDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                                    <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                        <!-- ngIf: isOpen -->
                                    </div>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </div>
                                <p ng-show="educationForm{{$index}}.startDate{{$index}}.$invalid && !educationForm{{$index}}.startDate{{$index}}.$pristine" class="help-block">Start Date is required.</p>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Study End Date</label>
                        <div class="col-sm-4">
                            <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope" ng-class="{ 'has-error' : educationForm{{$index}}.endDate{{$index}}.$invalid && !educationForm{{$index}}.endDate{{$index}}.$pristine }">
                                <div class="input-group">
                                    <input type="text" name="endDate{{$index}}" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="education.endDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                                    <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                        <!-- ngIf: isOpen -->
                                    </div>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                                    </span>
                                </div>
                                <p ng-show="educationForm{{$index}}.endDate{{$index}}.$invalid && !educationForm{{$index}}.endDate{{$index}}.$pristine" class="help-block">End Date is required.</p>
                            </div>
                        </div>
                    </div>
                    <div class="unit_title">School Address and Contact</div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Address Line 1</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.line1{{$index}}.$invalid && !educationForm{{$index}}.line1{{$index}}.$pristine }">
                            <input type="text" name="line1{{$index}}" placeholder="" class="form-control" ng-model="education.address.line1" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.line1{{$index}}.$invalid && !educationForm{{$index}}.line1{{$index}}.$pristine" class="help-block">Address Line 1 is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">Address Line 2</label>
                        <div class="col-xs-4">
                            <input type="text" placeholder="" class="form-control" ng-model="address.line2">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Country</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.country{{$index}}.$invalid && !educationForm{{$index}}.country{{$index}}.$pristine }">
                            <select class="form-control" ng-model="education.address.country" name="country{{$index}}" convert-to-string required>
                                <option value="">Please Select</option>
                                <option ng-repeat="country in studentInputData.allCountryList" value="{{country.id}}">{{country.name}}</option>
                            </select>
                            <p ng-show="educationForm{{$index}}.country{{$index}}.$invalid && !educationForm{{$index}}.country{{$index}}.$pristine" class="help-block">Country is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">State / Province</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.state{{$index}}.$invalid && !educationForm{{$index}}.state{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="state{{$index}}" ng-model="education.address.state" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.state{{$index}}.$invalid && !educationForm{{$index}}.state{{$index}}.$pristine" class="help-block">State is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">City</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.city{{$index}}.$invalid && !educationForm{{$index}}.city{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="city{{$index}}" ng-model="education.address.city" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.city{{$index}}.$invalid && !educationForm{{$index}}.city{{$index}}.$pristine" class="help-block">City is required.</p>
                        </div>
                        <label class="col-xs-2 control-label">Zip Code / Postal Code</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.zip{{$index}}.$invalid && !educationForm{{$index}}.zip{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="zip{{$index}}" ng-model="education.address.zip" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.zip{{$index}}.$invalid && !educationForm{{$index}}.zip{{$index}}.$pristine" class="help-block">Zip Code is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Phone Number</label>
                        <div class="col-xs-4" ng-class="{ 'has-error' : educationForm{{$index}}.eduPhoneId{{$index}}.$invalid && !educationForm{{$index}}.eduPhoneId{{$index}}.$pristine }">
                            <input type="text" placeholder="phone number" name="eduPhoneId{{$index}}" class="form-control" ng-model="education.phoneId" required maxlength="45">
                            <p ng-show="educationForm{{$index}}.eduPhoneId{{$index}}.$invalid && !educationForm{{$index}}.eduPhoneId{{$index}}.$pristine" class="help-block">Phone is required.</p>
                        </div>
                    </div>
                </div>
            </span>
			<div class="subtitle">Other Previous Academic Study <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.addEducation()"><span class="glyphicon glyphicon-plus"></span> Add Academic Study</a> </div>
            <div class="formTitle">Recommender Information</div>
            <span ng-repeat="recommenderInfo in studentInputData.recommenderInfoList">
                <div class="subtitle">Recommender{{$index+1}}<a class="btn btn-xs btn-link btn_link_red pull-right" ng-click="ctrl.removeRecommender($index)"><span class="glyphicon glyphicon-trash"></span> Remove</a></div>
                <span ng-form="recommenderInformationForm{{$index}}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Name of Recommender</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.nameOfRecommender{{$index}}.$invalid && !recommenderInformationForm{{$index}}.nameOfRecommender{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="nameOfRecommender{{$index}}" ng-model="recommenderInfo.nameOfRecommender" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.nameOfRecommender{{$index}}.$invalid && !recommenderInformationForm{{$index}}.nameOfRecommender{{$index}}.$pristine" class="help-block">Name of Recommender is required.</p>
                        </div>
                        <label class="col-sm-2 control-label">Job Title</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.jobTitle{{$index}}.$invalid && !recommenderInformationForm{{$index}}.jobTitle{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="jobTitle{{$index}}" ng-model="recommenderInfo.jobTitle" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.jobTitle{{$index}}.$invalid && !recommenderInformationForm{{$index}}.jobTitle{{$index}}.$pristine" class="help-block">Job Title is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Relationship</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.relationship{{$index}}.$invalid && !recommenderInformationForm{{$index}}.relationship{{$index}}.$pristine }">
                            <input type="text" class="form-control" name="relationship{{$index}}" ng-model="recommenderInfo.relationship" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.relationship{{$index}}.$invalid && !recommenderInformationForm{{$index}}.relationship{{$index}}.$pristine" class="help-block">Relationship is required.</p>
                        </div>
                        <label class="col-sm-2 control-label">Phone Number</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.recommenderPhoneId{{$index}}.$invalid && !recommenderInformationForm{{$index}}.recommenderPhoneId{{$index}}.$pristine }">
                            <input type="text" placeholder="phone number" name="recommenderPhoneId{{$index}}" class="form-control" ng-model="recommenderInfo.phoneId" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.recommenderPhoneId{{$index}}.$invalid && !recommenderInformationForm{{$index}}.recommenderPhoneId{{$index}}.$pristine" class="help-block">Phone is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Email Address</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.email{{$index}}.$invalid && !recommenderInformationForm{{$index}}.email{{$index}}.$pristine }">
                            <input type="email" class="form-control" name="email{{$index}}" ng-model="recommenderInfo.email" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.email{{$index}}.$invalid && !recommenderInformationForm{{$index}}.email{{$index}}.$pristine" class="help-block">Email is empty or Email format is wrong.</p>
                        </div>
                        <label class="col-sm-2 control-label">Cell/Telephone Number</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : recommenderInformationForm{{$index}}.cellPhoneId{{$index}}.$invalid && !recommenderInformationForm{{$index}}.cellPhoneId{{$index}}.$pristine }">
                            <input type="text" placeholder="cell phone number" name="cellPhoneId{{$index}}" class="form-control" ng-model="recommenderInfo.cellPhoneId" required maxlength="45">
                            <p ng-show="recommenderInformationForm{{$index}}.cellPhoneId{{$index}}.$invalid && !recommenderInformationForm{{$index}}.cellPhoneId{{$index}}.$pristine" class="help-block">Cell Phone is required.</p>
                        </div>
                    </div>
                </span>
            </span>
            <div class="subtitle">Other Type of Recommender <a class="btn btn-xs btn-link pull-right" ng-click="ctrl.addRecommender()"><span class="glyphicon glyphicon-plus"></span> Add Other Recommender</a> </div>
            <div class="formTitle">Standardized Test Account Information</div>
            <span ng-repeat="testAccount in studentInputData.standardizedTestAccountInfoList">
                <div class="subtitle">Test Account{{$index+1}}<a class="btn btn-xs btn-link btn_link_red pull-right" ng-click="ctrl.removeTestAccount($index)"><span class="glyphicon glyphicon-trash"></span> Remove</a></div>
                <span ng-form="testAccountForm{{$index}}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Test Account Name</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : testAccountForm{{$index}}.accountName{{$index}}.$invalid && !testAccountForm{{$index}}.accountName{{$index}}.$pristine }">
                            <input type="text" name="accountName{{$index}}" class="form-control" ng-model="testAccount.accountName" required maxlength="45">
                            <p ng-show="testAccountForm{{$index}}.accountName{{$index}}.$invalid && !testAccountForm{{$index}}.accountName{{$index}}.$pristine" class="help-block">Account Name is required.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Username or ID</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : testAccountForm{{$index}}.userName{{$index}}.$invalid && !testAccountForm{{$index}}.userName{{$index}}.$pristine }">
                            <input type="text" name="userName{{$index}}" class="form-control" ng-model="testAccount.userName" required maxlength="45">
                            <p ng-show="testAccountForm{{$index}}.userName{{$index}}.$invalid && !testAccountForm{{$index}}.userName{{$index}}.$pristine" class="help-block">Username is required.</p>
                        </div>
                        <label class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-4" ng-class="{ 'has-error' : testAccountForm{{$index}}.password{{$index}}.$invalid && !testAccountForm{{$index}}.password{{$index}}.$pristine }">
                            <input type="password" name="password{{$index}}" class="form-control" ng-model="testAccount.password" required maxlength="45">
                            <p ng-show="testAccountForm{{$index}}.password{{$index}}.$invalid && !testAccountForm{{$index}}.password{{$index}}.$pristine" class="help-block">Password is required.</p>
                        </div>
                    </div>
                </span>
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
                <div ng-class="{ 'has-error' : studentInputForm.declarationAgree.$invalid && !studentInputForm.declarationAgree.$pristine }">
                    <label class="checkbox-inline">
                        <input type="checkbox" name="declarationAgree" ng-model="studentInputData.studentInfo.declarationAgree" required> I agree <span class="text-muted"></span>
                    </label>
                    <p ng-show="studentInputForm.declarationAgree.$invalid && !studentInputForm.declarationAgree.$pristine" class="help-block">Declaration is required.</p>
                </div>
            </div>
            <div class="formTitle">Counselor Brag Sheet</div>
            <div class="textarea_room">
                <div class="form-group" ng-repeat="questionnaireSurvey in studentInputData.questionnaireSurveyList">
                    <span ng-form="bragForm{{$index}}">
                        <label class="col-sm-12 control-label">{{$index+1}}. {{questionnaireSurvey.question}}</label>
                        <div class="col-sm-12" ng-class="{ 'has-error' : bragForm{{$index}}.answer{{$index}}.$invalid && !bragForm{{$index}}.answer{{$index}}.$pristine }">
                            <textarea class="form-control" name="answer{{$index}}" ng-model="questionnaireSurvey.answer" required>{{questionnaireSurvey.answer}}</textarea>
                            <p ng-show="bragForm{{$index}}.answer{{$index}}.$invalid && !bragForm{{$index}}.answer{{$index}}.$pristine" class="help-block">Answer is required.</p>
                        </div>
                    </span>
                </div>
            </div>
            <div class="formTitle">Required Documents Checklist</div>
        </form>
        <div class="form_container form-horizontal">
            <div class="subtitle">Documents Details</div>
            <div class="notice_room">
                <div>Help: INSTRUCTIONS FOR UPLOADING FILES</div>
                <p>Please make sure that all upload files follow the requirements below:
                    <br> 1.The file is in PDF format (${maxSizeValue} file size limit);
                    <br> 2.The document is legible and in full focus;
                    <br> 3.The document must be correctly oriented (e.g., do not provide a sideways or upside down image);</p >
            </div>
            <div class="listUpload">
                <div class="dataTables_wrapper" ng-controller="UploadFileController as uCtrl">
                    <table class="table-bordered table" id="uploadFileList" ng-if="studentInputData.uploadFileList.length > 0">
                        <tr>
                            <th>#</th>
                            <th>Type</th>
                            <th>File Name</th>
                            <th>Upload Date</th>
                            <%--<th>Upload For</th>--%>
                            <th>Action</th>
                        </tr>
                        <tr ng-repeat="uploadFile in studentInputData.uploadFileList">
                            <td>{{$index+1}}</td>
                            <td ng-if="uploadFile.type === 'p'">&nbsp;Passport</td>
                            <td ng-if="uploadFile.type === 'at'">&nbsp;Academic Transcript</td>
                            <td ng-if="uploadFile.type === 'elr'">&nbsp;English Language Report/Certificate</td>
                            <td ng-if="uploadFile.type === 'i20'">&nbsp;Existing I-20</td>
                            <td ng-if="uploadFile.type === 'ps'">&nbsp;Personal Statement/Admission Essay</td>
                            <td ng-if="uploadFile.type === 'cv'">&nbsp;CV</td>
                            <td ng-if="uploadFile.type === 'c'">&nbsp;Certificate</td>
                            <td>{{uploadFile.fileDispName}}</td>
                            <td>&nbsp;{{uploadFile.uploadDate | date:'M/dd/yyyy'}}</td>
                            <%--<td>&nbsp;{{uploadFile.uploadBy}}</td>--%>
                            <td>
                                <button class="btn btn-default btn-xs" confirm="Are you sure you want to delete this file?" ng-click="uCtrl.deleteFile($index, uploadFile.id, uploadFile.type)"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                            </td>
                        </tr>
                    </table>
                </div>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload0" method="post" id="pFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('p')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Passport <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="pFile" data-rule-required="true" id="pFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError0" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload1" method="post" id="atFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('at')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Academic Transcript <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="atFile" data-rule-required="true" id="atFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError1" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload2" method="post" id="elrFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('elr')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">English Language Report/Certificate <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="elrFile" data-rule-required="true" id="elrFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError2" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload3" method="post" id="i20FileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('i20')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Existing I-20 <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="i20File" data-rule-required="true" id="i20File" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError3" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload4" method="post" id="psFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('ps')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Personal Statement/Admission Essay (PDF file only) <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="psFile" data-rule-required="true" id="psFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError4" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload5" method="post" id="cvFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('cv')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">CV (PDF file only) <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="cvFile" data-rule-required="true" id="cvFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError5" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
                <form ng-controller="UploadFileController as uCtrl" ng-show="$root.showUpload6" method="post" id="cFileUpload" enctype="multipart/form-data" ng-submit="uCtrl.fileUpload('c')">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Certificate (PDF file only) <!--span class="orange">(Required)</span--></label>
                        <div class="col-sm-9">
                            <input type="file" name="cFile" data-rule-required="true" id="cFile" accept=".pdf" class="control-label">
                            <span ng-show="$root.uploadFileError6" class="orange">Uploaded file size exceeded max size or not pdf file.</span>
                            <button type="submit" class="btn btn-default btn-xs">Upload</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="form-group button-room">
                <div class="text-center">
                    <button type="button" class="btn btn-primary btn-lg" ng-click="ctrl.saveStudentInfo()"> <span class="glyphicon glyphicon-ok "></span> Submit </button>
                </div>
            </div>
        </div>
	</div>
</div>
<%@include file="common/footer.jsp" %>
<script>
    var id = '${id}';
    var type = '${type}';
    var maxSize = '${maxSize}';
</script>
<script src="<c:url value='/js/controller/student_input_controller.js' />"></script>
<script src="<c:url value='/js/service/student_input_service.js' />"></script>
<script src="<c:url value='/js/controller/upload_file_controller.js' />"></script>
<script src="<c:url value='/js/service/upload_file_service.js' />"></script>
</body>
</html>