angular.module("lexfirma").factory("usuarioAPI", function ($http) {
    const _saveUsuario = function (usuario) {
        return $http.post("/usuario", usuario)
    }
    const _login = function (email) {
        return $http.get("/login/" + email)
    }
    const _getUsuario = function (id) {
        return $http.get("/usuario/" + id)
    }
    return {
        saveUsuario: _saveUsuario,
        getUsuario: _getUsuario,
        login: _login
    }
})