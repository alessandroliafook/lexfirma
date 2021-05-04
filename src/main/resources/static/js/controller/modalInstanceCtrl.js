angular
    .module('lexfirma')
    .controller('modalInstanceCtrl', function ($scope, $modalInstance, cadastro) {
        $scope.cadastro = cadastro

        $scope.ok = function () {
            $modalInstance.close($scope.cadastro)
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel')
        }
    })