angular.module("lexfirma").factory("pessoaAPI", function ($http) {
    const _getPessoas = function (idUsuario) {
        return $http.get(`/pessoas/${idUsuario}`)
    }
    const _savePessoa = function (pessoa) {
        return $http.post(`/pessoas`, pessoa)

    }
    const _deletePessoa = function (id) {
        return $http.delete(`/pessoas/${id}`)
    }
    return {
        getPessoas: _getPessoas,
        savePessoa: _savePessoa,
        deletePessoa: _deletePessoa
    }
})