angular.module("lexfirma").config(function ($routeProvider) {
    $routeProvider.otherwise({ redirectTo: "/main"})

    $routeProvider.when("/main", {
        templateUrl: "view/login.html",
        controller: "loginCtrl"
    })
        .when("/pessoas", {
            templateUrl: "view/pessoa.html",
            controller: "pessoaCtrl",
            resolve: {
                pessoas: function (pessoaAPI, $rootScope) {
                    return pessoaAPI.getPessoas($rootScope.userId)
                }
            }
        })
        .when("/processos", {
            templateUrl: "view/processo.html",
            controller: "processoCtrl",
            resolve: {
                processos: function (processoAPI, $rootScope) {
                    processoAPI.getProcessos($rootScope.userId)
                }
            }
        })
})