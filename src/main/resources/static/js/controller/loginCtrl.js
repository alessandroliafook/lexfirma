angular
    .module("lexfirma")
    .controller("loginCtrl", function ($scope, $modal, usuarioAPI) {

        $scope.realizarLogin = function (login) {
            usuarioAPI.getUsuario(login.email).success(
                function (data) {
                    let usuario = JSON.stringify(data)
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
                console.log(cadastro)
                const usuario = {
                    email: cadastro.email,
                    pessoa: {
                        nome: cadastro.nome,
                        documento: cadastro.documento
                    }
                }
                console.log(usuario)
                usuarioAPI
                    .saveUsuario(usuario)
                    .success(
                        function (data) {
                            console.log(data)
                        }
                    )
                    .error(function (data, status) {
                        console.log(`Erro ${status}: ${data.message}`)
                    })
            })
        }
    })
