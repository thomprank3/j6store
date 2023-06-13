app.controller("statistical-ctrl", function($scope, $http){
    // $scope.items = [];
    // $scope.form = {
    //     createDate: new Date(),
    //         image: 'cloud-upload.jpg',
    //         available: true,
    // };
    // $scope.cates = [];

    // $scope.initialize = function(){
    //     //load product
    //     $http.get("/rest/products").then(resp => {
    //         $scope.items = resp.data;
    //         $scope.items.forEach(item => {
    //             item.createDate = new Date(item.createDate)
    //         })
    //     });
    //     //load categories
    //     $http.get("/rest/categories").then(resp => {
    //         $scope.cates = resp.data;
    //     });
    // }
    //khoi dau
    // $scope.initialize();

    // //xoa form
    // $scope.reset= function(){
    //     $scope.form = {
    //         createDate: new Date(),
    //         image: 'cloud-upload.jpg',
    //         available: true,
    //         discount:"",
    //         price:""
    //     };
    // }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them sp moi
    // $scope.create = function(){
    //     var item = angular.copy($scope.form);
    //     $http.post(`/rest/products`, item).then(resp => {
    //         resp.data.createDate = new Date(resp.data.createDate)
    //         $scope.items.push(resp.data);
    //         $scope.reset();
    //         alert("Them moi sp thanh cong!");
    //     }).catch(error => {
    //         alert("Loi them moi sp!");
    //         console.log("Error", error);
    //     })
    // }
    //cap nhat sp
    // $scope.update = function(){
    //     var item = angular.copy($scope.form);
    //     $http.put(`/rest/products/${item.id}`, item).then(resp => {
    //         var index = $scope.items.findIndex(p => p.id == item.id);
    //         $scope.items[index] = item;
    //         $scope.reset();
    //         alert("Cap nhat sp thanh cong!");
    //     }).catch(error => {
    //         alert("Loi cap nhat sp!");
    //         console.log("Error", error);
    //     })
    // }
    //xoa sp
    // $scope.delete = function(item){
    //     $http.delete(`/rest/products/${item.id}`).then(resp => {
    //         var index = $scope.items.findIndex(p => p.id == item.id);
    //         $scope.items.splice(index, 1);
    //         $scope.reset();
    //         alert("Xoa sp thanh cong!");
    //     }).catch(error => {
    //         alert("Loi xoa sp!");
    //         console.log("Error", error);
    //     })
    // }

    //upload hinh
    // $scope.imageChanged = function(files){
    //     var data = new FormData();
    //     data.append('file', files[0]);
    //     $http.post('/rest/upload/images', data, {
    //         transformRequest: angular.identity,
    //         headers: {'Content-Type': undefined}
    //     }).then(resp => {
    //         $scope.form.image = resp.data.name;
    //     }).catch(error => {
    //         alert("Loi upload hinh anh");
    //         console.log("Error", error);
    //     })
    // }

    //phan trang
    // $scope.pager = {
    //     page: 0,
    //     size: 10,
    //     get items(){
    //         var start = this.page * this.size;
    //         return $scope.items.slice(start, start + this.size);
    //     },
    //     get count(){
    //         return Math.ceil(1.0 * $scope.items.length / this.size);
    //     },
    //     first(){
    //         this.page = 0;
    //     },
    //     prev(){
    //         this.page--;
    //         if(this.page < 0){
    //             this.last();
    //         }
    //     },
    //     next(){
    //         this.page++;
    //         if(this.page >= this.count){
    //             this.first();
    //         }
    //     },
    //     last(){
    //         this.page = this.count - 1;
    //     }
    // }
});