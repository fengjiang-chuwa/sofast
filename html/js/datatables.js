// staff add / drop courses in student
validationApp.controller('add_courses', add_courses);

function add_courses($scope, $compile, DTOptionsBuilder, DTColumnBuilder) {
  var self = this;
  //self.dtOptions = DTOptionsBuilder.fromSource('https://l-lin.github.io/angular-datatables/data.json')
  self.dtOptions = DTOptionsBuilder.fromSource('/sofast/html/json/student.json').withPaginationType('full_numbers').withOption('createdRow', createdRow);
  self.dtColumns = [
    // DTColumnBuilder.newColumn('').withTitle('#').renderWith(function(data, type, row, meta) {
    //   return (meta.row + 1);
    // }),
    DTColumnBuilder.newColumn('name').withTitle('Student Name'),
    DTColumnBuilder.newColumn('email').withTitle('Email'),
    DTColumnBuilder.newColumn('student_status').withTitle('Status'),
    DTColumnBuilder.newColumn('').withTitle('Actions').renderWith(actionHtml)
  ];
  $scope.searchApplicant = function() {
    top.location = getFullRequestPath('/applicant/search/result?') + $httpParamSerializer(self.searchCondition);
  };

  function createdRow(row, data, dataIndex) {
    // Recompiling so we can bind Angular directive to the DT
    $compile(angular.element(row).contents())($scope);
  }

  function actionHtml(data, type, row) {
    var btn;
    if (row.student_status == "replied") {
      btn = '<a href = "student_details.html" class = "btn-default btn btn-xs"> <span class = "glyphicon glyphicon-search"> </span> View Details</a>'
    } else if (row.student_status == "New") {
      btn = '<a href = "student_details.html" class = "btn-default btn btn-xs"> <span class = "glyphicon glyphicon-envelope"> </span> Send Email</a>'
    } else btn = '';
    return btn;
  }
}