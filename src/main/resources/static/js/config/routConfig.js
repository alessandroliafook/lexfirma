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
                    return processoAPI.getProcessos($rootScope.userId)
                },
                pessoas: function (pessoaAPI, $rootScope) {
                    return pessoaAPI.getPessoas($rootScope.userId)
                }
            }
        })
        .when("/recibos", {
            templateUrl: "view/recibo.html",
            controller: "reciboCtrl",
            resolve: {
                recibos: function (reciboAPI, $rootScope) {
                    return reciboAPI.getRecibos($rootScope.userId)
                },
                processos: function (processoAPI, $rootScope) {
                    return processoAPI.getProcessos($rootScope.userId)
                },
                pessoas: function (pessoaAPI, $rootScope) {
                    return pessoaAPI.getPessoas($rootScope.userId)
                }
            }
        })
})