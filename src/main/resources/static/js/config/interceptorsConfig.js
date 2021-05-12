angular
    .module("lexfirma")
    .config(function ($httpProvider) {
        $httpProvider.interceptors.push("tokenInterceptor")
})