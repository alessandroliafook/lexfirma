angular
    .module("lexfirma")
    .controller("usuarioCtrl", function ($scope, $rootScope, $location, usuarioAPI, usuario) {
        $scope.usuario = usuario.data

        $scope.delete = function (id) {
            usuarioAPI.delete(id)
            $location.path("/main")
        }

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