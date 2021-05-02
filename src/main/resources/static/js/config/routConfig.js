angular.module("lexfirma").config(function ($routeProvider) {
    $routeProvider.otherwise({ redirectTo: "/main"})

    $routeProvider.when("/main", {
        templateUrl: "view/login.html",
        controller: "loginCtrl"
    })
})