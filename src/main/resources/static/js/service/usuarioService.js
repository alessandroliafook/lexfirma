angular.module("lexfirma").factory("usuarioAPI", function ($http) {
    const _saveUsuario = function (usuario) {
        return $http.post("/usuario", usuario)
    }
    const _login = function (auth) {
        return $http.post("/login", auth)
    }
    const _getUsuario = function (id) {
        return $http.get("/usuario/" + id)
    }
    const _delete = function (id) {
        return $http.delete("/usuario/" + id)
    }
    return {
        saveUsuario: _saveUsuario,
        getUsuario: _getUsuario,
        login: _login,
        delete: _delete
    }
})