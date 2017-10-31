'use strict';

App.controller('SearchStudentController', ['$rootScope','$scope','$httpParamSerializer','DTOptionsBuilder', 'DTColumnBuilder',
    function ($rootScope,$scope,$httpParamSerializer, DTOptionsBuilder, DTColumnBuilder) {
        var self = this;
        self.searchStudent =function () {
            var searchUrl = getFullRequestPath('/studentdetail/search/result/');
            self.dtOptions = DTOptionsBuilder.fromSource(searchUrl).withOption({'bFilter': false,'order': [0, 'asc']})
                .withPaginationType('full_numbers');
            self.dtColumns = [
                DTColumnBuilder.newColumn('userName').withTitle('Student Name'),
                DTColumnBuilder.newColumn('applicantEmailAddress').withTitle('Email'),
                DTColumnBuilder.newColumn('statusStr').withTitle('Status'),
                DTColumnBuilder.newColumn('id').withTitle('Actions').renderWith(function (data, type, row) {
                    var btnHtml ='';
                    if(row.status === 'new'){
                        var viewLink = getFullRequestPath('/payment/detail/view/') + data;
                        btnHtml += '<a href='+viewLink+' class = "btn-default btn btn-xs"> <span class = "glyphicon glyphicon-envelope"> </span> Send Email</a>';
                        return btnHtml;
                    }
                    var editLink = getFullRequestPath('/payment/detail/paid/') + data;
                    btnHtml += '<a href='+editLink+' class = "btn-default btn btn-xs"> <span class = "glyphicon glyphicon-pencil"> </span> Edit Details</a>';
                    return btnHtml;
                }),
                DTColumnBuilder.newColumn('id').withTitle('id').notVisible()
            ];
        };
        self.searchStudent();
    }]
);