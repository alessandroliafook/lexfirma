angular
    .module("lexfirma")
    .controller("reciboCtrl", function ($scope, $modal, reciboAPI, recibos, $localStorage, processos, pessoas) {
        $scope.recibos = recibos.data
        $scope.processos = processos.data
        $scope.pessoas = pessoas.data

        $scope.delete = function (id) {
            reciboAPI.deleteRecibo(id)
            updateRecibos()
        }

        $scope.getNumeroProcesso = function(idProcesso) {
            let numProcesso = ""
            if(!idProcesso) return numProcesso

            $scope.processos.forEach(processo => {
                if(processo.id == idProcesso) {
                    numProcesso = processo.numero
                    return
                }
            })

            return numProcesso
        }

        $scope.getNomePessoa = function(idPessoa) {
            let nomePessoa = ""
            if(!idPessoa) return nomePessoa

            $scope.pessoas.forEach(pessoa => {
                if(pessoa.id == idPessoa) {
                    nomePessoa = pessoa.nome
                    return
                }
            })
            return nomePessoa
        }

        $scope.open = function (recibo) {

            if(recibo) recibo.vencimento = new Date(recibo.vencimento)

            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalRecibo.html',
                controller: 'modalReciboCtrl',
                resolve: {
                    cadastro: function () {
                        return recibo
                    },
                    pessoas: function () {
                        return $scope.pessoas
                    },
                    processos: function () {
                        return $scope.processos
                    }
                }
            })

            modalInstance.result.then(function (cadastro) {
                const recibo = {
                    id: cadastro.id,
                    valor: cadastro.valor,
                    vencimento: cadastro.vencimento,
                    titularID: cadastro.titularID,
                    processoID: cadastro.processoID,
                    pago: cadastro.pago || false,
                    usuarioID: $localStorage.userId
                }

                reciboAPI
                    .saveRecibo(recibo)
                    .success(
                        function (data) {
                            console.log("Recibo cadastrado com sucesso.")
                            if (!recibo.id)
                                $scope.recibos.push(data)
                            else {
                                updateRecibos()
                            }
                        }
                    )
                    .error(function (data, status) {
                        console.log(`Erro ${status}: ${data.message}`)
                    })
            })
        }

        const updateRecibos = function () {
            reciboAPI.getRecibos($localStorage.userId)
                .success(function (data) {
                    $scope.recibos = data
                })
                .error(function (data, status) {
                    console.log(`Erro ${status}: ${data.message}`)
                })
        }
    })