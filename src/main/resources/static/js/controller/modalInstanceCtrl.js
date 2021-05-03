angular
    .module('lexfirma')
    .controller('modalInstanceCtrl', function ($scope, $modalInstance, cadastro) {
        $scope.cadastro = cadastro
        console.log("Parametro: " + cadastro)
        console.log("Escopo: " + $scope.cadastro)

        $scope.ok = function () {
            $modalInstance.close($scope.cadastro)
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel')
        }
    })