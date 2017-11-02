'use strict';

App.factory('UploadFileService', ['$http', '$rootScope', '$q', function($http, $rootScope, $q){
    self.checkFileFailed= function (file){
        if(!file || !file.name){
            return true;
        }
        var fileName = file.name.split(".");
        return file.size > maxSize || fileName[1] != "pdf";

    };
    return {
        checkUploadFile: function(uploadStatus, tabData) {
            var file;
            var res = false;
            if (uploadStatus === "pcgid") {
                var pcOrGidFile = document.getElementById("pcOrGidFile");
                file =  pcOrGidFile.files[0];
                res = $rootScope.uploadFileError[0] = self.checkFileFailed(file);
            }
            if (uploadStatus === "fsd") {
                var financialFile = document.getElementById("financialFile");
                file =  financialFile.files[0];
                res = $rootScope.uploadFileError[1] = self.checkFileFailed(file);
            }
            if (uploadStatus === "pc") {
                var passportFile = document.getElementById("passportFile");
                file =  passportFile.files[0];
                res = $rootScope.uploadFileError[2] = self.checkFileFailed(file);
            }
            if (uploadStatus === "vc") {
                var visaFile = document.getElementById("visaFile");
                file =  visaFile.files[0];
                res = $rootScope.uploadFileError[3] = self.checkFileFailed(file);
            }
            if (uploadStatus === "ic") {
                var i94File = document.getElementById("i94File");
                file =  i94File.files[0];
                res = $rootScope.uploadFileError[4] = self.checkFileFailed(file);
            }
            if (uploadStatus === "copusui") {
                var copusuiFile = document.getElementById("copusuiFile");
                file =  copusuiFile.files[0];
                res = $rootScope.uploadFileError[5] = self.checkFileFailed(file);
            }
            if (uploadStatus === "College" ||
                uploadStatus === "IBT" ||
                uploadStatus === "CBT" ||
                uploadStatus === "PBT" ||
                uploadStatus === "IELTS" ||
                uploadStatus === "EPE") {
                var englishFile = document.getElementById("englishFile");
                file =  englishFile.files[0];
                res = $rootScope.uploadFileErrorEng = self.checkFileFailed(file);
            }
            if (uploadStatus === "GMAT" || uploadStatus === "GRE") {
                var examFile = document.getElementById("examFile");
                file =  examFile.files[0];
                res = $rootScope.uploadFileErrorExam = self.checkFileFailed(file);
            }
            var tempData = tabData.split(",");
            if (tempData && tempData[1]) {
                if(tempData[1] === "OT") {
                    var eduOTFile = document.getElementById("eduOTFile");
                    file =  eduOTFile.files[0];
                    res = $rootScope.uploadFileErrorOT = self.checkFileFailed(file);
                }else if(tempData[1] === "Diploma") {
                    var eduDiplomaFile = document.getElementById("eduDiplomaFile");
                    file =  eduDiplomaFile.files[0];
                    res = $rootScope.uploadFileErrorDip = self.checkFileFailed(file);
                }
            }
            return !res;
        },

        fileUpload: function(uploadStatus, description, tabName, tabData, fileId) {
            var formData = new FormData();
            if (uploadStatus === "pcgid") {
                var pcOrGidFile = document.getElementById("pcOrGidFile");
                formData.append("file", pcOrGidFile.files[0]);
            }
            if (uploadStatus === "fsd") {
                var financialFile = document.getElementById("financialFile");
                formData.append("file", financialFile.files[0]);
            }
            if (uploadStatus === "pc") {
                var passportFile = document.getElementById("passportFile");
                formData.append("file", passportFile.files[0]);
            }
            if (uploadStatus === "vc") {
                var visaFile = document.getElementById("visaFile");
                formData.append("file", visaFile.files[0]);
            }
            if (uploadStatus === "ic") {
                var i94File = document.getElementById("i94File");
                formData.append("file", i94File.files[0]);
            }
            if (uploadStatus === "copusui") {
                var copusuiFile = document.getElementById("copusuiFile");
                formData.append("file", copusuiFile.files[0]);
            }
            if (uploadStatus === "College" ||
                uploadStatus === "IBT" ||
                uploadStatus === "CBT" ||
                uploadStatus === "PBT" ||
                uploadStatus === "IELTS" ||
                uploadStatus === "EPE") {
                var englishFile = document.getElementById("englishFile");
                formData.append("file", englishFile.files[0]);
            }
            if (uploadStatus === "GMAT" || uploadStatus === "GRE") {
                var examFile = document.getElementById("examFile");
                formData.append("file", examFile.files[0]);
            }
            var tempData = tabData.split(",");
            if (tempData && tempData[1]) {
                if(tempData[1] === "OT") {
                    var eduOTFile = document.getElementById("eduOTFile");
                    formData.append("file", eduOTFile.files[0]);
                }
                if(tempData[1] === "Diploma") {
                    var eduDiplomaFile = document.getElementById("eduDiplomaFile");
                    formData.append("file", eduDiplomaFile.files[0]);
                }
            }
            formData.append("uploadStatus", uploadStatus);
            formData.append("description", description);
            if(!fileId){
                fileId = "";
            }
            return $http({
                        method: 'POST',
                        url: getFullRequestPath("/fileUpload/"+tabName+"/"+tabData+"?fileId="+fileId),
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
        clearFileStatus: function(appId,fileId) {
            return $http.post(getFullRequestPath("/process/"+appId+"/file/"+fileId+"/clearStatus"))
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    return $q.reject(errResponse);
                }
            );
        },
        deleteFile: function(id, tabName) {
            return $http.post(getFullRequestPath("/fileUpload/remove/" + tabName + "/" + id)).then(
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
