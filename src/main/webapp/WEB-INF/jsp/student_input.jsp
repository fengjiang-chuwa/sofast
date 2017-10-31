<!DOCTYPE HTML>
<html lang="en">
<head>
	<title>Sofast</title>
    <%@include file="common/header.jsp" %>
</head>
<body ng-app="myApp" class="ng-scope">
<%@include file="common/page_header.jsp" %>
<div class="container">
	<div class="well">
		<form class="form-horizontal clearfix form_container">
			<div class="formTitle">Personal Information</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
				</div>
				<label class="col-sm-2 control-label">Family Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Passport Number</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
                </div>
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth</label>
				<div class="col-sm-4" ng-include="'/sofast/html/tmpl/datepicker.html'"></div>
				<label class="col-sm-2 control-label">Country of Birth</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Nationality / Citizenship</label>
				<div class="col-sm-4">
					<input type="text" class="form-control">
                </div>
			</div>
			<div class="subtitle">Contact Details</div>
			<div class="unit_title">Permanent Home Address</div>
			<div ng-include="'/sofast/html/tmpl/address.html'"></div>
			<div class="unit_title">Mailing Address</div>
			<div ng-include="'/sofast/html/tmpl/address.html'"></div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Phone Number</label>
				<div class="col-sm-4 " ng-include="'/sofast/html/tmpl/phone.html'"></div>
			</div>
			<div class="subtitle ">Parents' Information</div>
			<div class="unit_title">Father’s Name</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Phone Number</label>
				<div class="col-sm-4 " ng-include="'/sofast/html/tmpl/phone.html'"></div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Education</label>
				<div class="col-sm-4 ">
					<select class="form-control"></select>
				</div>
				<label class="col-sm-2 control-label ">Profession</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="unit_title ">Mother’s Name</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Phone Number</label>
				<div class="col-sm-4 " ng-include="'/sofast/html/tmpl/phone.html'"></div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Education</label>
				<div class="col-sm-4 ">
					<select class="form-control"></select>
				</div>
				<label class="col-sm-2 control-label ">Profession</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="subtitle ">Program Type</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Start Date</label>
				<div class="col-sm-4 ">
					<select class="form-control"></select>
				</div>
				<label class="col-sm-2 control-label ">Target School / Major</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">First Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label ">Second Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Safety Choice</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
				<label class="col-sm-2 control-label ">Undecided / Undeclared</label>
				<div class="col-sm-4 ">
					<input type="text " class="form-control">
                </div>
			</div>
			<div class="formTitle">Education Information
				<p class="page_notice">Please list all middle/high schools attended from grade nine up to graduation from high school.</p>
			</div>
			<div class="subtitle">Most Recent Academic Study</div>
			<div class="form-group ">
				<label class="col-sm-2 control-label ">Name of highest qualification</label>
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
<%--<script src="<c:url value='/js/controller/search_student_controller.js' />"></script>--%>
</body>
</html>