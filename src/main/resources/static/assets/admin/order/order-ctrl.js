app.controller("order-ctrl", function($scope, $http){
    $scope.items = [];
    $scope.form = {};
    $scope.statuses = [];
    $scope.initialize = function(){
        //load orders
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        //load categories
        $http.get("/rest/statuses").then(resp => {
            $scope.statuses = resp.data;
        });
    }
    //khoi dau
    $scope.initialize();

    //xoa form
    $scope.reset= function(){
        $scope.form = {
            createDate: new Date(),
            id:"",
            address:"",
        };
    }

    //hien thi len form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them order moi
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/orders`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Them moi order thanh cong!");
        }).catch(error => {
            alert("Loi them moi order!");
            console.log("Error", error);
        })
    }
    //cap nhat sp
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/orders/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(od => od.id == item.id);
            $scope.items[index] = item;
            alert("Cap nhat order thanh cong!");
        }).catch(error => {
            alert("Loi cap nhat order!");
            console.log("Error", error);
        })
    }
    //xoa sp
    $scope.delete = function(item){
        $http.delete(`/rest/orders/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(od => od.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xoa order thanh cong!");
        }).catch(error => {
            alert("Loi xoa order!");
            console.log("Error", error);
        })
    }


    //phan trang
    $scope.pager = {
        page: 0,
        size: 10,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count - 1;
        }
    }
});