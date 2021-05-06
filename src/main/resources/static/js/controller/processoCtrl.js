angular
    .module("lexfirma")
    .controller("processoCtrl", function ($scope, $modal, processos, processoAPI, $rootScope) {
        if(processos)
            $scope.processos = processos.data
        else
            $scope.processos = []

        $scope.open = function (processo) {

            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalProcesso.html',
                controller: 'modalInstanceCtrl',
                resolve: {
                    cadastro: function () {
                        return processo
                    }
                }
            })

            modalInstance.result.then(function (cadastro) {
                const processo = {
                    id: cadastro.id,
                    numero: cadastro.numero,
                    inicio: cadastro.inicio,
                    fim: cadastro.fim,
                    valorDaCausa: cadastro.valorDaCausa,
                    usuarioID: $rootScope.userId
                }

                processoAPI
                    .saveProcesso(processo)
                    .success(
                        function (data) {
                            console.log("Processo Cadastrado com sucesso.")
                            if (!processo.id)
                                $scope.processos.push(data)
                            else {
                                updateProcessos()
                            }
                        }
                    )
                    .error(function (data, status) {
                        console.log(`Erro ${status}: ${data.message}`)
                    })
            })
        }

        const updateProcessos = function () {
            processoAPI.getProcessos($rootScope.userId)
                .success(function (data) {
                    $scope.processos = data
                }).error(function (data, status) {
                console.log(`Erro ${status}: ${data.message}`)
            })
        }
    })