package br.com.youready.article.d_2024_12_02.image2;

// Helper methods to simulate external interactions
def imprimeNoArquivo(texto) {
    println "Imprimindo no arquivo: ${texto}"
}

def imprimeNoTerminal(texto) {
    println "Imprimindo no terminal: ${texto}"
}

def enviaViaRest(texto) {
    println "Enviando via REST: ${texto}"
}

class Pessoa {
    String nome
    String sobrenome

    // Static factory method
    static Pessoa comNome(String nome, String sobrenome) {
        return new Pessoa(nome: nome, sobrenome: sobrenome)
    }

    // Unica representacao e autoritativa do nome completo.
    def nomeCompleto() {
        return "${nome} ${sobrenome}"
    }
}

Pessoa pessoa = Pessoa.comNome("Rafael", "Issao")
imprimeNoArquivo(pessoa.nomeCompleto())
imprimeNoTerminal(pessoa.nomeCompleto())
enviaViaRest(pessoa.nomeCompleto())