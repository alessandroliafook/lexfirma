angular
    .module("lexfirma")
    .factory("tokenInterceptor", function ($q, $localStorage, $location) {
        return {
            request: function (config) {
                if(config.url != "/login" &&
                    !config.url.includes("."))
                    config.headers.token = $localStorage.token
                return config
            },
            responseError: function (rejection) {
                if(rejection.status === 401) $location.path("/main")
                return $q.reject(rejection)
            }
        }
})