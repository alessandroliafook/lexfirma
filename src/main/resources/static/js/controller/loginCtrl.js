angular
    .module("lexfirma")
    .controller("loginCtrl", function ($scope, $modal, usuarioAPI, $location, $rootScope) {

        $rootScope.userId = null

        $scope.realizarLogin = function (login) {
            usuarioAPI.getUsuario(login.email).success(
                function (data) {
                    $rootScope.userId = data.id
                    $location.path("/pessoas")
                }).error(function (data, status) {
                console.log(`Erro ${status}: ${data.message}`)
            })
        }

        $scope.open = function () {
            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalLogin.html',
                controller: 'modalInstanceCtrl'
            })

            modalInstance.result.then(function (cadastro) {
                const usuario = {
                    email: cadastro.email,
                    pessoa: {
                        nome: cadastro.nome,
                        documento: cadastro.documento
                    }
                }
                usuarioAPI
                    .saveUsuario(usuario)
                    .success(
                        function (data) {
                            console.log("Usuario Cadastrado com sucesso")
                        }
                    )
                    .error(function (data, status) {
                        console.log(`Erro ${status}: ${data.message}`)
                    })
            })
        }
    })
