const app = angular.module("edit-profile",[]);
app.controller("edit-profile-ctrl", function($scope, $http){
    $scope.items = [];
    $scope.form = {};


    //cap nhat sp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/accounts/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(acc => acc.id == item.id);
            $scope.items[index] = item;
            alert("Cap nhat account thanh cong!");
        }).catch(error => {
            alert("Loi cap nhat account!");
            console.log("Error", error);
        })
    }


    //upload hinh
    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Loi upload hinh anh");
            console.log("Error", error);
        })
    }

});