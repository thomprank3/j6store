app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider){
    $routeProvider
    .when("/product", {
        templateUrl: "/assets/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/category", {
        templateUrl: "/assets/admin/category/index.html",
        controller: "category-ctrl"
    })
    .when("/account", {
        templateUrl: "/assets/admin/account/index.html",
        controller: "account-ctrl"
    })
    .when("/orders", {
        templateUrl: "/assets/admin/order/index.html",
        controller: "order-ctrl"
    })
    .when("/statistical", {
        templateUrl: "/assets/admin/statistical/index.html",
        controller: "statistical-ctrl"
    })
    .when("/authorize", {
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("/unauthorized", {
        templateUrl: "/assets/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
        template:"<h1 class='text-center' style='padding:20px'>Welcome to Administration Site !!!</h1>"
    })
})