const app = angular.module("register",[]);
app.controller("register-ctrl", function($scope, $http){
    $scope.form = {};
    $scope.items = $http.get("/rest/accounts").then(resp => {
        $scope.items = resp.data;
    });
 
    //xoa form
    $scope.reset= function(){
        $scope.form = {
            username:"",
            password:"",
            email:""
        };
    }


    //them sp moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/accounts/register`, item).then(resp => {
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Đăng ký thành công!");
        }).catch(error => {
            alert("Đăng ký thất bại!");
            console.log("Error", error);
        })
    }

});