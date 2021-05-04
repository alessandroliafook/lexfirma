// angular
//     .module("lexfirma")
//     .controller("processoCtrl", function ($scope, $modal) {
//         $scope.pessoas = []
//
//         $scope.open = function (pessoa) {
//             const modalInstance = $modal.open({
//                 animation: true,
//                 templateUrl: 'view/modalPessoa.html',
//                 controller: 'modalInstanceCtrl',
//                 resolve: {
//                     cadastro: function () {
//                         return pessoa
//                     }
//                 }
//             })
//
//             modalInstance.result.then(function (cadastro) {
//                 const pessoa = {
//                     nome: cadastro.nome,
//                     documento: cadastro.documento,
//                     contato: cadastro.contato
//                 }
//                 pessoaAPI
//                     .savePessoa($rootScope.userId, pessoa)
//                     .success(
//                         function (data) {
//                             console.log("Pessoa Cadastrada com sucesso.")
//                             $scope.pessoas.push(data)
//                         }
//                     )
//                     .error(function (data, status) {
//                         console.log(`Erro ${status}: ${data.message}`)
//                     })
//             })
//         }
//     })