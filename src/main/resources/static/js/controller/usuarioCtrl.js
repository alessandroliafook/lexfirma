angular
    .module("lexfirma")
    .controller("usuarioCtrl", function ($scope, $rootScope, usuarioAPI, usuario) {
        $scope.usuario = usuario.data

        $scope.save = function (usuario) {
            usuarioAPI.saveUsuario(usuario)
                .success(function (data) {
                    console.log("Usuario salvo com sucesso!")
                })
                .error(function (data, status) {
                    console.log(`Erro ${status}: ${data.message}`)
                })
            }
        })