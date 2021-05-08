angular
    .module("lexfirma")
    .controller("loginCtrl", function ($scope, $modal, usuarioAPI, $location, $localStorage) {

        $localStorage.userId = null

        $scope.realizarLogin = function (login) {
            usuarioAPI.login(login.email).success(
                function (data) {
                    $localStorage.userId = data
                    $location.path("/pessoas")
                }).error(function (data, status) {
                console.log(`Erro ${status}: ${data.message}`)
            })
        }

        $scope.open = function () {
            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalLogin.html',
                controller: 'modalInstanceCtrl',
                resolve: {
                    cadastro: function () {
                        return {}
                    }
                }
            })

            modalInstance.result.then(function (cadastro) {
                const usuario = {
                    email: cadastro.email,
                    nome: cadastro.nome,
                    documento: cadastro.documento
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
