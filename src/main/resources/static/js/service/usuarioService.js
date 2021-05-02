angular.module("lexfirma").factory("usuarioAPI", function ($http) {
    const _saveUsuario = function (usuario) {
        return $http.post("/usuario", usuario)
    }
    const _getUsuario = function (email) {
        return $http.get("/usuario/" + email)
    }
    return {
        saveUsuario: _saveUsuario,
        getUsuario: _getUsuario
    }
})