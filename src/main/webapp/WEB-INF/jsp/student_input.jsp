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
				<div class="col-sm-4">
					<input type="text" class="form-control" ng-model="ctrl.studentInputData.studentBasic.firstName">
				</div>
				<label class="col-sm-2 control-label">Family Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" ng-model="ctrl.studentInputData.studentBasic.familyName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Passport Number</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" ng-model="ctrl.studentInputData.studentBasic.passportNumber">
                </div>
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" ng-model="ctrl.studentInputData.studentBasic.applicantEmailAddress">
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth</label>
				<div class="col-sm-4">
                    <div ng-controller="DatepickerPopupDemoCtrl" class="ng-scope">
                        <div class="input-group">
                            <input type="text" class="form-control ng-pristine ng-valid ng-isolate-scope ng-not-empty ng-valid-date ng-valid-required ng-touched" uib-datepicker-popup="dd-MM-yyyy" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" required="required">
                            <div uib-datepicker-popup-wrap="" ng-model="date" ng-change="dateSelection(date)" template-url="uib/template/datepickerPopup/popup.html" class="ng-not-empty ng-valid">
                                <!-- ngIf: isOpen -->
                            </div>
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-default" ng-click="open1()"> <i class="glyphicon glyphicon-calendar"></i></button>
                            </span>
                        </div>
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
                    <div class="col-xs-4">
                        <input type="text" placeholder="phone number" class="form-control" ng-model="ctrl.studentInputData.studentBasic.phoneId">
                    </div>
                </div>
			</div>
			<div class="subtitle ">Parents' Information</div>
            <span ng-repeat="relationship in ctrl.studentInputData.relationshipList">
                <div class="unit_title" ng-if="('father' === relationship.relationshipTitle)">Father's Info</div>
                <div class="unit_title" ng-if="('mother' === relationship.relationshipTitle)">Mother's Info</div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="name" class="form-control" ng-model="ctrl.studentInputData.relationship.name">
                    </div>
                    <label class="col-sm-2 control-label">Phone Number</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="phone number" class="form-control" ng-model="ctrl.studentInputData.relationship.phoneId">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Education</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="education" class="form-control" ng-model="ctrl.studentInputData.relationship.education">
                    </div>
                    <label class="col-sm-2 control-label">Profession</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="profession" class="form-control" ng-model="ctrl.studentInputData.relationship.profession">
                    </div>
                </div>
            </span>
			<div class="subtitle ">Program Type</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Start Date</label>
				<div class="col-sm-4 ">
					<select class="form-control"></select>
				</div>
				<label class="col-sm-2 control-label">Target School / Major</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">First Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label">Second Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Safety Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label">Undecided / Undeclared</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="formTitle">Education Information
				<p class="page_notice">Please list all middle/high schools attended from grade nine up to graduation from high school.</p>
			</div>
			<div class="subtitle">Most Recent Academic Study</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Name of highest qualification</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div ng-include="'/sofast/html/tmpl/school_information.html'" class="add_more"></div>
			<div class="subtitle">Other Previous Academic Study <a class="btn btn-xs btn-link pull-right" ng-click="showMore=!showMore"><span class="glyphicon glyphicon-plus"></span> Add Academic Study</a> </div>
			<div class="unit_title">School2</div>
			<div ng-include="'/sofast/html/tmpl/school_information.html'" class="add_more"></div>
			<div class="unit_title" ng-show="showMore">School3</div>
			<div ng-include="'/sofast/html/tmpl/school_information.html'" class="add_more" ng-show="showMore"></div>
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
			<div class="formTitle">Required Documents Checklist</div>
			<div class="subtitle">Recommender 1</div>
			<div ng-include="'/sofast/html/tmpl/recommender.html'"></div>
			<div class="subtitle">Recommender 2</div>
			<div ng-include="'/sofast/html/tmpl/recommender.html'"></div>
			<div class="subtitle">Recommender 3</div>
			<div ng-include="'/sofast/html/tmpl/recommender.html'"></div>
			<div class="subtitle">Other Type of Recommender</div>
			<div ng-include="'/sofast/html/tmpl/recommender.html'"></div>
			<div class="formTitle">Standardized Test Account Information</div>
			<div class="subtitle">SAT/ACT</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Username or ID</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="subtitle">TOEFL/IELTS</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Username or ID</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="subtitle">Other Test Account Info</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label">Username or ID</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="formTitle">Declaration</div>
			<div class="subtitle">Declaration Details</div>
			<div class="form-group article-room">
				<div class="">
					<p> I confirm that I Student Name have been duly appointed by Student Name, have permission to act on their behalf and confirm that to the best of my knowledge all the details supplied are accurate and correct. I understand that the giving of false or incomplete information may lead to the misguidance in college counselling process or refusal of admissions to colleges or cancellation of the applicant’s enrolment. I confirm that the applicant has received a copy of the terms and conditions. </p>
				</div>
			</div>
			<div class="form-group button-room">
				<div class="">
					<label class="checkbox-inline">
						<input type="checkbox"> I agree <span class="text-muted"></span> </label>
				</div>
			</div>
			<div class="formTitle">Counselor Brag Sheet</div>
			<div class="textarea_room">
				<div class="form-group " ng-repeat="x in bragSheet">
					<label class="col-sm-12 control-label">{{x}}</label>
					<div class="col-sm-12 ">
						<textarea class="form-control"></textarea>
					</div>
				</div>
			</div>
			<div class="form-group button-room ">
				<div class="text-center">
					<button type="button " class="btn btn-primary btn-lg" onclick="window.location.href='submit_sucess.html'"> <span class="glyphicon glyphicon-ok "></span> Submit </button>
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