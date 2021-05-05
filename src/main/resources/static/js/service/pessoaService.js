angular.module("lexfirma").factory("pessoaAPI", function ($http) {
    const _getPessoas = function (idUsuario) {
        return $http.get(`/usuario/${idUsuario}/pessoas`)
    }
    const _savePessoa = function (idUsuario, pessoa) {
        return $http.post(`/usuario/${idUsuario}/pessoas`, pessoa)

    }
    const _deletePessoa = function (idUsuario, id) {
        return $http.delete(`/usuario/${idUsuario}/pessoas/${id}`)
    }
    return {
        getPessoas: _getPessoas,
        savePessoa: _savePessoa,
        deletePessoa: _deletePessoa
    }
})