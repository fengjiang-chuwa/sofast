'use strict';

App.controller('SearchStudentController', ['$compile','$rootScope','$scope','$httpParamSerializer',
    'DTOptionsBuilder', 'DTColumnBuilder', 'StudentInputService','$sce',
    function ($compile,$rootScope,$scope,$httpParamSerializer, DTOptionsBuilder, DTColumnBuilder, StudentInputService,$sce) {
        var self = this;
        self.searchStudent =function () {
            var searchUrl = getFullRequestPath('/studentdetail/search/result/');
            self.dtOptions = DTOptionsBuilder.fromSource(searchUrl).withOption({'bFilter': false,'order': [0, 'asc']})
                .withPaginationType('full_numbers').withOption('createdRow', createdRow);
            self.dtColumns = [
                DTColumnBuilder.newColumn('userName').withTitle('Student Name'),
                DTColumnBuilder.newColumn('applicantEmailAddress').withTitle('Email'),
                DTColumnBuilder.newColumn('statusStr').withTitle('Status'),
                DTColumnBuilder.newColumn('id').withTitle('Actions').renderWith(function (data, type, row) {
                    var btnHtml ='';
                    if(row.status === 'new'){
                        btnHtml += '<a ng-click ="ctrl.sendEmail(\''+data+'\')" class = "btn-default btn btn-xs" confirm="Do you want to send email to student?"> <span class = "glyphicon glyphicon-envelope"> </span> Send Email</a>';
                    }
                    var editLink = getFullRequestPath('/student/studentBasicId/') + data;
                    btnHtml += '<a href='+editLink+' class = "btn-default btn btn-xs"> <span class = "glyphicon glyphicon-pencil"> </span> Edit Details</a>';
                    return btnHtml;
                }),
                DTColumnBuilder.newColumn('id').withTitle('id').notVisible()
            ];
        };

        function createdRow(row, data, dataIndex) {
            // Recompiling so we can bind Angular directive to the DT
            $compile(angular.element(row).contents())($scope);
        }
        self.sendEmail = sendEmail;

        self.showSuccess = false;
        self.showError = false;
        function sendEmail(studentId) {
            StudentInputService.sendEmail(studentId).then(
                function (d) {
                    if(d.data === "success") {
                        self.showSuccess = true;
                        self.showError = false;
                        self.errorMsg = $sce.trustAsHtml("Mail send successfully!");
                    } else {
                        self.showSuccess = false;
                        self.showError = true;
                        self.errorMsg = $sce.trustAsHtml(d.data);
                    }
                },
                function (errResponse) {
                    // console.error('Error while checking User');
                }
            );
        }
        self.searchStudent();
    }]
);