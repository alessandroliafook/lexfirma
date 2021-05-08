angular.module("lexfirma").config(function ($routeProvider) {
    $routeProvider.otherwise({ redirectTo: "/main"})

    $routeProvider.when("/main", {
        templateUrl: "view/login.html",
        controller: "loginCtrl"
    })
        .when("/usuario", {
            templateUrl: "view/usuario.html",
            controller: "usuarioCtrl",
            resolve: {
                usuario: function (usuarioAPI, $localStorage) {
                    return usuarioAPI.getUsuario($localStorage.userId)
                }
            }
        })
        .when("/pessoas", {
            templateUrl: "view/pessoa.html",
            controller: "pessoaCtrl",
            resolve: {
                pessoas: function (pessoaAPI, $localStorage) {
                    return pessoaAPI.getPessoas($localStorage.userId)
                }
            }
        })
        .when("/processos", {
            templateUrl: "view/processo.html",
            controller: "processoCtrl",
            resolve: {
                processos: function (processoAPI, $localStorage) {
                    return processoAPI.getProcessos($localStorage.userId)
                },
                pessoas: function (pessoaAPI, $localStorage) {
                    return pessoaAPI.getPessoas($localStorage.userId)
                }
            }
        })
        .when("/recibos", {
            templateUrl: "view/recibo.html",
            controller: "reciboCtrl",
            resolve: {
                recibos: function (reciboAPI, $localStorage) {
                    return reciboAPI.getRecibos($localStorage.userId)
                },
                processos: function (processoAPI, $localStorage) {
                    return processoAPI.getProcessos($localStorage.userId)
                },
                pessoas: function (pessoaAPI, $localStorage) {
                    return pessoaAPI.getPessoas($localStorage.userId)
                }
            }
        })
})