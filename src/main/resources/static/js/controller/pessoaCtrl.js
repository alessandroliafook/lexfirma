angular
    .module("lexfirma")
    .controller("pessoaCtrl", function ($scope, pessoas, $localStorage, pessoaAPI, $modal) {
        $scope.pessoas = pessoas.data

        $scope.delete = function (id) {
            pessoaAPI.deletePessoa(id)
            updatePessoas()
        }

        $scope.open = function (pessoa) {

            const modalInstance = $modal.open({
                animation: true,
                templateUrl: 'view/modalPessoa.html',
                controller: 'modalInstanceCtrl',
                resolve: {
                    cadastro: function () {
                        return pessoa
                    }
                }
            })

            modalInstance.result.then(function (cadastro) {
                const pessoa = {
                    id: cadastro.id,
                    nome: cadastro.nome,
                    documento: cadastro.documento,
                    contato: cadastro.contato,
                    usuarioID: $localStorage.userId
                }

                pessoaAPI
                    .savePessoa(pessoa)
                    .success(
                        function (data) {
                            console.log("Pessoa Cadastrada com sucesso.")
                            if (!pessoa.id)
                                $scope.pessoas.push(data)
                            else {
                                updatePessoas()
                            }
                        }
                    )
                    .error(function (data, status) {
                        console.log(`Erro ${status}: ${data.message}`)
                    })
            })
        }

        const updatePessoas = function () {
            pessoaAPI.getPessoas($localStorage.userId)
                .success(function (data) {
                    $scope.pessoas = data
                }).error(function (data, status) {
                console.log(`Erro ${status}: ${data.message}`)
            })
        }
    })