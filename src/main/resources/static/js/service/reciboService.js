angular.module("lexfirma").factory("reciboAPI", function ($http) {
    const _getRecibos = function (idUsuario) {
        return $http.get(`/recibos/${idUsuario}`)
    }
    const _saveRecibo = function (recibo) {
        return $http.post(`/recibo`, recibo)

    }
    const _deleteRecibo = function (id) {
        return $http.delete(`/recibo/${id}`)
    }
    return {
        getRecibos: _getRecibos,
        saveRecibo: _saveRecibo,
        deleteRecibo: _deleteRecibo
    }
})