angular.module("lexfirma").factory("pessoaAPI", function ($http) {
    const _getPessoas = function (id) {
        return $http.get("/pessoas/" + id)
    }
    const _savePessoa = function (id, pessoa) {
        return $http.post("/pessoas/" + id, pessoa)

    }
    return {
        getPessoas: _getPessoas,
        savePessoa: _savePessoa
    }
})