angular
    .module("lexfirma")
    .controller("loginCtrl", function ($scope, $modal, usuarioAPI, $location, $localStorage) {

        $localStorage.userId = null
        $localStorage.token = null

        $scope.realizarLogin = function (login) {
            usuarioAPI.login(login).success(
                function (data) {
                    if(data){
                        $localStorage.userId = data.usuarioId
                        $localStorage.token = data.chave
                        $location.path("/pessoas")
                    }
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
                    senha: cadastro.senha,
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
