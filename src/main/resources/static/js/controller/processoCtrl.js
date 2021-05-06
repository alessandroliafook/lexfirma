angular
    .module("lexfirma")
    .controller("processoCtrl", function ($scope, $modal, processos, pessoas, processoAPI, $rootScope) {
        $scope.processos = processos.data
        $scope.pessoas = pessoas.data

        $scope.getNomeCliente = function(clienteID) {
            let nomeCliente = ""
            if(!clienteID) return nomeCliente

            $scope.pessoas.forEach(pessoa => {
                if(pessoa.id === clienteID) {
                    nomeCliente = pessoa.nome
                    return
                }
            })

            return nomeCliente
        }

        $scope.delete = function (id) {
            processoAPI.deleteProcesso(id)
            updateProcessos()
        }

        $scope.open = function (processo) {

            if(processo) {
                processo.inicio = new Date(processo.inicio)
                processo.fim = new Date (processo.fim)
            }

            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalProcesso.html',
                controller: 'modalProcessoCtrl',
                resolve: {
                    cadastro: function () {
                        return processo
                    },
                    pessoas: function () {
                        return $scope.pessoas
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
                    usuarioID: $rootScope.userId,
                    clienteID: cadastro.clienteID
                }
                console.log(processo)

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