// Return to previous page
function goBack() {
    window.history.go(-1)
}

var validationApp = angular.module('soFast', ['ui.bootstrap', 'datatables']);
// Date Picker
validationApp.controller('DatepickerPopupDemoCtrl', function($scope) {
    $scope.today = function() {
        $scope.dt = new Date();
    };
    $scope.today();
    $scope.clear = function() {
        $scope.dt = null;
    };
    $scope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };
    $scope.dateOptions = {
        dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };
    // Disable weekend selection
    function disabled(data) {
        var date = data.date,
            mode = data.mode;
        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }
    $scope.toggleMin = function() {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };
    $scope.toggleMin();
    $scope.open1 = function() {
        $scope.popup1.opened = true;
    };
    $scope.open2 = function() {
        $scope.popup2.opened = true;
    };
    $scope.setDate = function(year, month, day) {
        $scope.dt = new Date(year, month, day);
    };
    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.altInputFormats = ['M!/d!/yyyy'];
    $scope.popup1 = {
        opened: false
    };
    $scope.popup2 = {
        opened: false
    };
    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 1);
    $scope.events = [{
        date: tomorrow,
        status: 'full'
    }, {
        date: afterTomorrow,
        status: 'partially'
    }];

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);
            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);
                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }
        return '';
    }
});

// Create Phone Number Controller
validationApp.controller('phoneNumber', ['$scope', function($scope) {
    $scope.data = {
        model: '+86',
        availableOptions: [{ id: '+86', name: 'China (+86)' }, { id: '2', name: 'China (+86)China (+86)China (+86)China (+86)' }, { id: '3', name: 'Option C' }]
    };
}]);

// Show Information
validationApp.controller('showInfo', function($scope, $window) {
    $scope.level = ['Undergraduate', 'Postgraduate', 'Postgraduated Researcher'];
    $scope.files = ['Passport', 'Academic Transcript', 'English Language Report/Certificate', 'Existing I-20', 'Personal Statement/Admission Essay', 'CV', 'Certificate (Optional)']
    $scope.bragSheet = [
        '1. List 1-3 occupations you are considering in order of preference and explain what it is about the occupation that interests you and why you might be successful in such a field.',
        '2. Describe how a particular event or activity (positive or negative) has had the most significant impact on you in your life and shaped you as a person and why?',
        "3. Please describe your family in detail (ex: siblings and their age, which do you, live with, mother/father's occupation and education etc.).",
        "4. Pick five original adjectives that you believe best describes who you. For each, write a sentence as to why you chose it.",
        "5. Discuss any significant decrease or increase in your academic performance and why?",
        "6.  Compare yourself from 9th grade to now.",
        "7. What hobby, talents or endeavor are you passionate about and why? How have you pursued this passion?",
        "8. Do you work or are completing an internship? If so, where do you work or serve as an intern? What have you learned on the job or through your internship that school couldn't have taught? What do you do with your work income?",
        "9. Discuss one act of leadership you have demonstrated in your life.",
        "10. What is your favorite quote and why?",
        "11. Describe a class or extracurricular activity that you are most proud of, and how it illustrates your best qualities.",
        "12. School Related Activities: Please describe and indicate the dates of affiliations (clubs, teams, service organizations, student government, etc.). If you hold/held an office or had a specific responsibility, please describe each activity with the most recent first.",
        "13. Non School Related Activities: That you have participated in (work experience, internships non-school sponsored organizations) where, what and when you started and how long (be specific):",
        "14. Community Service: Where, what and when you started and how long (be specific):",
        "15. Awards and honors: That you have earned; where, what and why (be specific):",
        "16. Anything you think is of importance to your application to colleges, that without this you application will be incomplete"

    ];
});