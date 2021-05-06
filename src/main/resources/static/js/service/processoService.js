angular.module("lexfirma").factory("processoAPI", function ($http) {
    const _getProcessos = function (idUsuario) {
        return $http.get(`/processos/${idUsuario}`)
    }
    const _saveProcesso = function (processo) {
        return $http.post(`/processo`, processo)

    }
    const _deleteProcesso = function (id) {
        return $http.delete(`/processo/${id}`)
    }
    return {
        getProcessos: _getProcessos,
        saveProcesso: _saveProcesso,
        deleteProcesso: _deleteProcesso
    }
})