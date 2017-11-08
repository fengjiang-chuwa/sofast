'use strict';

App.controller('UploadFileController', ['$scope', '$rootScope', '$confirm', 'UploadFileService', function ($scope, $rootScope, $confirm, UploadFileService) {
    var self = this;

    $rootScope.uploadFileError0 = false;
    $rootScope.uploadFileError1 = false;
    $rootScope.uploadFileError2 = false;
    $rootScope.uploadFileError3 = false;
    $rootScope.uploadFileError4 = false;
    $rootScope.uploadFileError5 = false;

    self.fileUpload = function (uploadFileType){
        if(UploadFileService.checkUploadFile(uploadFileType)) {
            UploadFileService.fileUpload(uploadFileType).then(
                function (d) {
                    if (200 === d.status) {
                        if (d.data.data !== undefined) {
                            if (uploadFileType === "p") {
                                $rootScope.showUpload0 = false;
                            }
                            if (uploadFileType === "at") {
                                $rootScope.showUpload1 = false;
                            }
                            if (uploadFileType === "elr") {
                                $rootScope.showUpload2 = false;
                            }
                            if (uploadFileType === "i20") {
                                $rootScope.showUpload3 = false;
                            }
                            if (uploadFileType === "ps") {
                                $rootScope.showUpload4 = false;
                            }
                            if (uploadFileType === "cv") {
                                $rootScope.showUpload5 = false;
                            }
                            if (uploadFileType === "c") {
                                $rootScope.showUpload6 = false;
                            }
                            if ($scope.studentInputData.uploadFileList == null) {
                                $scope.studentInputData.uploadFileList = [];
                                $scope.studentInputData.uploadFileList.push(d.data.data);
                            } else {
                                $scope.studentInputData.uploadFileList.push(d.data.data);
                            }
                        } else {
                            if (uploadFileType === "p") {
                                $rootScope.uploadFileError0 = true;
                            }
                            if (uploadFileType === "at") {
                                $rootScope.uploadFileError1 = true;
                            }
                            if (uploadFileType === "elr") {
                                $rootScope.uploadFileError2 = true;
                            }
                            if (uploadFileType === "i20") {
                                $rootScope.uploadFileError3 = true;
                            }
                            if (uploadFileType === "ps") {
                                $rootScope.uploadFileError4 = true;
                            }
                            if (uploadFileType === "cv") {
                                $rootScope.uploadFileError5 = true;
                            }
                            if (uploadFileType === "c") {
                                $rootScope.uploadFileError6 = true;
                            }
                        }
                    } else {
                        // error handler
                        console.error('Error while uploading file');
                    }
                },
                function (errResponse) {
                    console.error('Error while uploading file');
                }
            );
        }
    };

    self.deleteFile = function (index, uploadFileId, uploadFileType){
        $scope.studentInputData.uploadFileList.splice(index, 1);
        UploadFileService.deleteFile(uploadFileId, id, type).then(
            function (d) {
                if(200 === d.status){
                    if (uploadFileType === "p") {
                        $rootScope.showUpload0 = true;
                    }
                    if (uploadFileType === "at") {
                        $rootScope.showUpload1 = true;
                    }
                    if (uploadFileType === "elr") {
                        $rootScope.showUpload2 = true;
                    }
                    if (uploadFileType === "i20") {
                        $rootScope.showUpload3 = true;
                    }
                    if (uploadFileType === "ps") {
                        $rootScope.showUpload4 = true;
                    }
                    if (uploadFileType === "cv") {
                        $rootScope.showUpload5 = true;
                    }
                    if (uploadFileType === "c") {
                        $rootScope.showUpload6 = true;
                    }
                } else {
                    // error handler
                    console.error('Error while deleting file');
                }
            },
            function (errResponse) {
                console.error('Error while deleting file');
            }
        );
    };
}]);