validationApp.constant('APP_VERSION', angular_query_builder_version).config(['$httpProvider', '$logProvider', 'DemoDataProvider', function($httpProvider, $logProvider, DemoDataProvider) {
    $logProvider.debugEnabled(true);
    var interceptor = ['$rootScope', '$q', '$location', function($rootScope, $q, $location) {
        var demoData = DemoDataProvider.$get();
        return {
            'request': function(request) {
                if (request.url.indexOf("https://localhost/aqb/typeahead/object-types/") > -1 || request.url.indexOf("https://localhost/aqb/typeahead/fma/") > -1) {
                    request.timeout = 1;
                }
                return request;
            },
            'responseError': function(response) {
                if (response.config.url.indexOf("https://localhost/aqb/typeahead/object-types/") > -1) {
                    // Some object types returned by the typeahead
                    response.data = demoData.getObjectTypes();
                    response.status = 200;
                } else if (response.config.url.indexOf("https://localhost/aqb/typeahead/fma/") > -1) {
                    // Some FMA terms returned by the typeahead
                    response.data = demoData.getFMATerms();
                    response.status = 200;
                }
                return response;
            }
        };
    }];
    $httpProvider.interceptors.push(interceptor);
}]).controller('MainController', ['$scope', '$sce', '$log', 'APP_VERSION', 'AppConfig', 'DemoData', function($scope, $sce, $log, APP_VERSION, AppConfig, DemoData) {
    $scope.appVersion = APP_VERSION;
    AppConfig.setMaxGroups(4);
    AppConfig.setMaxConditions(4);
    $scope.jsonOutput = {};
    $scope.search = function(form, $event) {
        $log.debug($scope.searchContainer);
        $scope.jsonOutput = JSON.stringify($scope.searchContainer, null, 4);
    };
    $scope.$watch("searchContainer", function() {
        $scope.jsonOutput = {};
        var groups = $scope.searchContainer.groups;
        if (!!groups && groups instanceof Array && groups.length > 0) {
            $scope.output = $sce.trustAsHtml(computeOutput(groups[0]));
        }
    }, true);

    function computeOutput(group) {
        if (!group) return "";
        for (var str = "(", i = 0; i < group.conditions.length; i++) {
            i > 0 && (str += " <strong>" + group.logicalOperator.displayName + "</strong> ");
            var condition = group.conditions[i];
            if (!!condition && !!condition.sourceField && !!condition.comparisonOperator && !!condition.inputItem) {
                str += condition.sourceField.displayName + " " + condition.comparisonOperator.displayName + " '" + condition.inputItem.displayName + "'";
            }
        }
        if (!!group.groups && group.groups instanceof Array) {
            for (var x = 0; x < group.groups.length; x++) {
                if (!!group.logicalOperator && !!group.conditions) {
                    if (group.conditions.length > 0 || x > 0) {
                        str += " <strong>" + group.logicalOperator.displayName + "</strong> ";
                    }
                    str += computeOutput(group.groups[x]);
                }
            }
        }
        return str + ")";
    }
    $scope.sourceTypes = DemoData.getSourceTypes();
    $scope.logicalOperators = DemoData.getLogicalOperators();
    var emptySearchContainer = {
        "groups": [{
            "conditions": [{}]
        }]
    };
    //$scope.searchContainer = emptySearchContainer;
    $scope.searchContainer = DemoData.getSearchContainer1();
    //$scope.searchContainer = DemoData.getSearchContainer2();
}]).provider('DemoData', function DemoDataProvider() {
    function DemoData() {
        this.getObjectTypes = function() {
            return [{
                "data": "Subject",
                "displayName": "Subject"
            }, {
                "data": "Study",
                "displayName": "Study"
            }, {
                "data": "RawImage",
                "displayName": "Raw Image"
            }, {
                "data": "SegmentationImage",
                "displayName": "Segmentation Image"
            }, {
                "data": "ClinicalStudyData",
                "displayName": "Clinical Study Data"
            }, {
                "data": "ClinicalStudyDefinition",
                "displayName": "Clinical Study Definition"
            }, {
                "data": "StatisticalModel",
                "displayName": "Statistical Model"
            }, {
                "data": "GenomicData",
                "displayName": "Genomic Data"
            }, {
                "data": "GenomicSeries",
                "displayName": "Genomic Series"
            }, {
                "data": "GenomicPlatform",
                "displayName": "Genomic Platform"
            }];
        };
        this.getFMATerms = function() {
            return [{
                "data": "3734",
                "displayName": "Aorta"
            }, {
                "data": "3740",
                "displayName": "Bulb of aorta"
            }, {
                "data": "7195",
                "displayName": "Lung"
            }, {
                "data": "7203",
                "displayName": "Kidney"
            }, {
                "data": "50801",
                "displayName": "Brain"
            }];
        };
        this.getSourceFields = function() {
            return [{
                "name": "Type",
                "displayName": "Type",
                "position": 1,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/object-types/"
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 2,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/object-types/"
                }]
            }, {
                "name": "ObjectId",
                "displayName": "Id",
                "position": 2,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 2
                }, {
                    "name": "Greater",
                    "displayName": ">",
                    "position": 6
                }, {
                    "name": "Less",
                    "displayName": "<",
                    "position": 7
                }, {
                    "name": "GreaterEqual",
                    "displayName": ">=",
                    "position": 8
                }, {
                    "name": "LessEqual",
                    "displayName": "<=",
                    "position": 9
                }]
            }, {
                "name": "SubjectId",
                "displayName": "Subject Id",
                "position": 3,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 2
                }, {
                    "name": "Contains",
                    "displayName": "Contains",
                    "position": 3
                }]
            }, {
                "name": "AnatomicalRegion",
                "displayName": "Anatomical Region",
                "position": 4,
                "comparisonOperators": [{
                    "name": "Contains",
                    "displayName": "Contains",
                    "position": 1,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/fma/"
                }, {
                    "name": "Equals",
                    "displayName": "=",
                    "position": 2,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/fma/"
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 3,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/fma/"
                }]
            }, {
                "name": "Fulltext",
                "displayName": "Fulltext",
                "position": 5,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1
                }]
            }, {
                "name": "FileExtension",
                "displayName": "File Extension",
                "position": 6,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 2
                }]
            }, {
                "name": "Placeholder",
                "displayName": "Placeholder",
                "position": 7,
                "comparisonOperators": [{
                    "name": "Equals",
                    "displayName": "=",
                    "position": 1,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/object-types/"
                }, {
                    "name": "Contains",
                    "displayName": "Contains",
                    "position": 3
                }, {
                    "name": "NotEquals",
                    "displayName": "!=",
                    "position": 2,
                    "typeaheadUrl": "https://localhost/aqb/typeahead/fma/"
                }]
            }];
        };
        this.getSourceTypes = function() {
            return [{
                "name": "Objects",
                "displayName": "Objects",
                "position": 1,
                "sourceFields": this.getSourceFields()
            }, {
                "name": "RelatedObjects",
                "displayName": "Related Objects",
                "position": 2,
                "sourceFields": this.getSourceFields()
            }];
        };
        this.getLogicalOperators = function() {
            return [{
                "name": "And",
                "displayName": "AND",
                "position": 1
            }, {
                "name": "Or",
                "displayName": "OR",
                "position": 2
            }];
        };
        this.getSearchContainer1 = function() {
            return {
                "groups": [{
                    "logicalOperator": {
                        "name": "And",
                        "displayName": "AND"
                    },
                    "sourceType": {
                        "name": "Objects",
                        "displayName": "Objects"
                    },
                    "conditions": [{
                        "sourceField": {
                            "name": "Type",
                            "displayName": "Type"
                        },
                        "comparisonOperator": {
                            "name": "Equals",
                            "displayName": "="
                        },
                        "inputItem": {
                            "data": "Subject",
                            "displayName": "Subject",
                            "isTypeahead": true
                        }
                    }],
                    "groups": [{
                        "logicalOperator": {
                            "name": "And",
                            "displayName": "AND"
                        },
                        "sourceType": {
                            "name": "RelatedObjects",
                            "displayName": "Related Objects"
                        },
                        "conditions": [{
                            "sourceField": {
                                "name": "AnatomicalRegion",
                                "displayName": "Anatomical Region"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "7203",
                                "displayName": "Kidney",
                                "isTypeahead": true
                            }
                        }, {
                            "sourceField": {
                                "name": "Type",
                                "displayName": "Type"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "RawImage",
                                "displayName": "Raw Image",
                                "isTypeahead": true
                            }
                        }, {
                            "sourceField": {
                                "name": "Type",
                                "displayName": "Type"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "ClinicalStudyData",
                                "displayName": "Clinical Study Data",
                                "isTypeahead": true
                            }
                        }]
                    }]
                }]
            };
        }
        this.getSearchContainer2 = function() {
            return {
                "groups": [{
                    "logicalOperator": {
                        "name": "Or",
                        "displayName": "OR"
                    },
                    "sourceType": {
                        "name": "Objects",
                        "displayName": "Objects"
                    },
                    "conditions": [],
                    "groups": [{
                        "logicalOperator": {
                            "name": "And",
                            "displayName": "AND"
                        },
                        "sourceType": {
                            "name": "RelatedObjects",
                            "displayName": "Related Objects"
                        },
                        "conditions": [{
                            "sourceField": {
                                "name": "AnatomicalRegion",
                                "displayName": "Anatomical Region"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "7203",
                                "displayName": "Kidney",
                                "isTypeahead": true
                            }
                        }, {
                            "sourceField": {
                                "name": "Type",
                                "displayName": "Type"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "RawImage",
                                "displayName": "Raw Image",
                                "isTypeahead": true
                            }
                        }]
                    }, {
                        "logicalOperator": {
                            "name": "And",
                            "displayName": "AND"
                        },
                        "sourceType": {
                            "name": "RelatedObjects",
                            "displayName": "Related Objects"
                        },
                        "conditions": [{
                            "sourceField": {
                                "name": "AnatomicalRegion",
                                "displayName": "Anatomical Region"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "7203",
                                "displayName": "Kidney",
                                "isTypeahead": true
                            }
                        }, {
                            "sourceField": {
                                "name": "Type",
                                "displayName": "Type"
                            },
                            "comparisonOperator": {
                                "name": "Equals",
                                "displayName": "="
                            },
                            "inputItem": {
                                "data": "RawImage",
                                "displayName": "Raw Image",
                                "isTypeahead": true
                            }
                        }]
                    }]
                }]
            };
        };
    }
    this.$get = function demoDataFactory() {
        return new DemoData();
    };
});
validationApp.controller('ModalDemoCtrl', function($uibModal, $log, $document) {
    var $ctrl = this;
    $ctrl.items = ['item1', 'item2', 'item3'];
    $ctrl.animationsEnabled = true;
    $ctrl.open = function(size, parentSelector) {
        var parentElem = parentSelector ? angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
        var modalInstance = $uibModal.open({
            animation: $ctrl.animationsEnabled,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            controllerAs: '$ctrl',
            size: size,
            appendTo: parentElem,
            resolve: {
                items: function() {
                    return $ctrl.items;
                }
            }
        });
        modalInstance.result.then(function(selectedItem) {
            $ctrl.selected = selectedItem;
        }, function() {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };
    $ctrl.openComponentModal = function() {
        var modalInstance = $uibModal.open({
            animation: $ctrl.animationsEnabled,
            component: 'modalComponent',
            resolve: {
                items: function() {
                    return $ctrl.items;
                }
            }
        });
        modalInstance.result.then(function(selectedItem) {
            $ctrl.selected = selectedItem;
        }, function() {
            $log.info('modal-component dismissed at: ' + new Date());
        });
    };
    $ctrl.openMultipleModals = function() {
        $uibModal.open({
            animation: $ctrl.animationsEnabled,
            ariaLabelledBy: 'modal-title-bottom',
            ariaDescribedBy: 'modal-body-bottom',
            templateUrl: 'stackedModal.html',
            size: 'sm',
            controller: function($scope) {
                $scope.name = 'bottom';
            }
        });
        $uibModal.open({
            animation: $ctrl.animationsEnabled,
            ariaLabelledBy: 'modal-title-top',
            ariaDescribedBy: 'modal-body-top',
            templateUrl: 'stackedModal.html',
            size: 'sm',
            controller: function($scope) {
                $scope.name = 'top';
            }
        });
    };
    $ctrl.toggleAnimation = function() {
        $ctrl.animationsEnabled = !$ctrl.animationsEnabled;
    };
});
// Please note that $uibModalInstance represents a modal window (instance) dependency.
// It is not the same as the $uibModal service used above.
validationApp.controller('ModalInstanceCtrl', function($uibModalInstance, items) {
    var $ctrl = this;
    $ctrl.items = items;
    $ctrl.selected = {
        item: $ctrl.items[0]
    };
    $ctrl.ok = function() {
        $uibModalInstance.close($ctrl.selected.item);
    };
    $ctrl.cancel = function() {
        $uibModalInstance.dismiss('cancel');
    };
});
// Please note that the close and dismiss bindings are from $uibModalInstance.
validationApp.component('modalComponent', {
    templateUrl: 'myModalContent.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    },
    controller: function() {
        var $ctrl = this;
        $ctrl.$onInit = function() {
            $ctrl.items = $ctrl.resolve.items;
            $ctrl.selected = {
                item: $ctrl.items[0]
            };
        };
        $ctrl.ok = function() {
            $ctrl.close({ $value: $ctrl.selected.item });
        };
        $ctrl.cancel = function() {
            $ctrl.dismiss({ $value: 'cancel' });
        };
    }
});
// show alert
validationApp.directive('myAlert', function($timeout) {
    return {
        scope: {
            // message: '@',
            isVisible: '='
        },
        link: link,
        restrict: 'E',
        replace: true,
        template: '<div ng-if="isVisible" class="alert alert-success">message</div>'
    }

    function link(scope, element, attrs) {
        scope.isVisible = true;
        $timeout(function() {
            scope.isVisible = false;
        }, 5000);
    }
});
validationApp.controller('myCtrl', function($scope) {
    $scope.isVisible = true;
    $scope.show = show;

    function show() {
        $scope.isVisible = true;
    }
});