'use strict';

App.factory('UploadFileService', ['$http', '$rootScope', '$q', function($http, $rootScope, $q){

    return {
        checkUploadFile: function(uploadFileType) {
            var file;
            if (uploadFileType === "p") {
                file = document.getElementById("pFile").files[0];
            }
            if (uploadFileType === "at") {
                file = document.getElementById("atFile").files[0];
            }
            if (uploadFileType === "elr") {
                file = document.getElementById("elrFile").files[0];
            }
            if (uploadFileType === "i20") {
                file = document.getElementById("i20File").files[0];
            }
            if (uploadFileType === "ps") {
                file = document.getElementById("psFile").files[0];
            }
            if (uploadFileType === "cv") {
                file = document.getElementById("cvFile").files[0];
            }
            if (uploadFileType === "c") {
                file = document.getElementById("cFile").files[0];
            }
            if(!file) {
                return false;
            }
            var fileName = file.name.split(".");
            if (file.size > maxSize || fileName[1] != "pdf") {
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
                return false;
            }
            return true;
        },

        fileUpload: function(uploadFileType) {
            var formData = new FormData();
            if (uploadFileType === "p") {
                formData.append("file", document.getElementById("pFile").files[0]);
            }
            if (uploadFileType === "at") {
                formData.append("file", document.getElementById("atFile").files[0]);
            }
            if (uploadFileType === "elr") {
                formData.append("file", document.getElementById("elrFile").files[0]);
            }
            if (uploadFileType === "i20") {
                formData.append("file", document.getElementById("i20File").files[0]);
            }
            if (uploadFileType === "ps") {
                formData.append("file", document.getElementById("psFile").files[0]);
            }
            if (uploadFileType === "cv") {
                formData.append("file", document.getElementById("cvFile").files[0]);
            }
            if (uploadFileType === "c") {
                formData.append("file", document.getElementById("cFile").files[0]);
            }
            formData.append("uploadFileType", uploadFileType);
            return $http({
                method: 'POST',
                url: getFullRequestPath("/fileUpload/" + id + "/" + type),
                headers: {'Content-Type': undefined},
                data: formData,
                transformRequest: function(data, headersGetterFunction) {
                    return data;
                }
            }).success(function(data, status) {
                //alert("success");
            }).error(function(data, status){
                //alert("error");
            });
        },

        deleteFile: function(uploadFileId, id, type) {
            return $http.post(getFullRequestPath("/fileUpload/remove/" + id + "/" + type + "/" + uploadFileId)).then(
                function(response){
                    if (response.data.data === "success") {
                        return response.data;
                        //window.location = getFullRequestPath("/application/edit/" + program.reqApplication + "/additionalProgram");
                    }
                },
                function(errResponse){
                    // console.error('Error while creating user');
                    return $q.reject(errResponse);
                }
            );
        }
    };
}]);