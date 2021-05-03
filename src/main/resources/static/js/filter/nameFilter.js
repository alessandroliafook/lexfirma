angular.module("lexfirma").filter("name", function() {
    return function(input) {
        var listaDeNomes = input.split(" ")
        var listaDeNomesFormatada = listaDeNomes.map(function(nome) {
            if(!/(da|de)/.test(nome))
                return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase()
            else
                return nome.toLowerCase()
        })

        return listaDeNomesFormatada.join(" ")
    }
})