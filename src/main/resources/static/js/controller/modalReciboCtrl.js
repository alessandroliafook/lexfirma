angular
    .module('lexfirma')
    .controller('modalReciboCtrl', function ($scope, $modalInstance, cadastro, pessoas, processos) {
        $scope.cadastro = cadastro
        $scope.pessoas = pessoas
        $scope.processos = processos

        $scope.ok = function () {
            $modalInstance.close($scope.cadastro)
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel')
        }
    })