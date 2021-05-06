angular
    .module('lexfirma')
    .controller('modalProcessoCtrl', function ($scope, $modalInstance, cadastro, pessoas) {
        $scope.cadastro = cadastro
        $scope.pessoas = pessoas

        $scope.ok = function () {
            $modalInstance.close($scope.cadastro)
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel')
        }
    })