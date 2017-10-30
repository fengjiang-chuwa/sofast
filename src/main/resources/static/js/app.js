'use strict';

var App = angular.module('myApp',['ui.bootstrap','ui.router', 'ngAnimate','angular-confirm','datatables', 'angularMoment']);

(function(){
    var httpInterceptor = function ($provide, $httpProvider) {
        $provide.factory('httpInterceptor', function ($q) {
            return {
                response: function (response) {
                    if(response.data && response.data.status && response.data.status!==200){
                        //TODO refactor later
                        // if(response.data.status==400){
                        //     top.location.href = getFullRequestPath("/user/error");
                        // } else {
                            top.location.href = getFullRequestPath("/user/error");
                        // }
                    } else {
                        return response || $q.when(response);
                    }
                },
                responseError: function (rejection) {
                    if(rejection.status === 401) {
                        // you are not autorized
                        top.location.href = getFullRequestPath("/user/login");
                    }
                    return $q.reject(rejection);
                }
            };
        });
        $httpProvider.interceptors.push('httpInterceptor');
    };
    var myInterceptor = function ($provide, $httpProvider) {
        $provide.factory('myInterceptor', ["$rootScope", function ($rootScope) {
            var timestampMarker = {
                request: function (config) {
                    if($rootScope.loading) {
                        $rootScope.rquest = ($rootScope.rquest || 1)+1;
                    } else {
                        $rootScope.rquest = 1;
                    }
                    $rootScope.loading = true;
                    return config;
                },
                response: function (response) {
                    if((!$rootScope.rquest) || $rootScope.rquest ===1) {
                        $rootScope.loading = false;
                    } else {
                        $rootScope.rquest = ($rootScope.rquest) -1;
                    }
                    return response;
                }
            };
            return timestampMarker;
        }]);
        $httpProvider.interceptors.push('myInterceptor');
    };
    angular.module("myApp").config(myInterceptor);
    angular.module("myApp").config(httpInterceptor);
}());

App.directive('convertToString', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModel) {
            ngModel.$formatters.push(function(val) {
                return val ? '' + val : null;
            });
            ngModel.$parsers.push(function(val) {
                return val ? '' + val : null;
            });
        }
    };
});

App.directive('convertToNumber', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModel) {
            ngModel.$formatters.push(function(val) {
                return val ? Number(val) : null;
            });
            ngModel.$parsers.push(function(val) {
                return val ? Number(val) : null;
            });
        }
    };
});
App.directive('ngMin', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, elem, attr, ctrl) {
            scope.$watch(attr.ngMin, function(){
                if (ctrl.$isDirty) ctrl.$setViewValue(ctrl.$viewValue);
            });

            var isEmpty = function (value) {
                return angular.isUndefined(value) || value === "" || value === null;
            };

            var minValidator = function(value) {
                var min = scope.$eval(attr.ngMin) || 0;
                if (!isEmpty(value) && value < min) {
                    ctrl.$setValidity('ngMin', false);
                    return undefined;
                } else {
                    ctrl.$setValidity('ngMin', true);
                    return value;
                }
            };

            ctrl.$parsers.push(minValidator);
            ctrl.$formatters.push(minValidator);
        }
    };
});
App.directive('ngMax', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, elem, attr, ctrl) {
            scope.$watch(attr.ngMax, function(){
                if (ctrl.$isDirty) ctrl.$setViewValue(ctrl.$viewValue);
            });
            var isEmpty = function (value) {
                return angular.isUndefined(value) || value === "" || value === null;
            };
            var maxValidator = function(value) {
                var max = scope.$eval(attr.ngMax) || Infinity;
                if (!isEmpty(value) && value > max) {
                    ctrl.$setValidity('ngMax', false);
                    return undefined;
                } else {
                    ctrl.$setValidity('ngMax', true);
                    return value;
                }
            };

            ctrl.$parsers.push(maxValidator);
            ctrl.$formatters.push(maxValidator);
        }
    };
});

App.directive('countryCode', ['$rootScope', function($rootScope) {
    return {
        restrict: 'AE',
        require: 'ngModel',
        scope: {
            ngModel: '='
        },
        template: '<label>{{$root.displayName}}</label>' +
                    '<span class="arrow"></span>' +
                '<select ng-model="ngModel" ng-change="showDisplayName()" name="shortCountryCode" id="shortCountryCode" class="short">' +
                    '<option ng-repeat="country in $root.countryCodeArray" value="{{country.shortCountryName}}">{{country.displayName}}</option>' +
                '</select>',
        link: function(scope, iElement, iAttrs, ngModel) {
            scope.showDisplayName = function() {
                for (var i=0; i<$rootScope.countryCodeArray.length; i++) {
                    if ($rootScope.countryCodeArray[i].shortCountryName == $("#shortCountryCode option:selected").val()) {
                        $rootScope.displayName = $rootScope.countryCodeArray[i].countryCode;
                        break;
                    }
                }
            }
        }
    };
}]);
