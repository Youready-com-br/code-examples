package br.com.youready.article.d_2024_12_02.image2

class Pessoa {
    String nome
    String sobrenome

    static Pessoa comNome(String nome, String sobrenome) {
        new Pessoa(nome: nome, sobrenome: sobrenome)
    }

    //Unica representação e autoritativa do
    // nome completo.
    def nomeCompleto() {
        return nome + " " + sobrenome
    }
}

def imprimeNoArquivo(String texto) {
    // dummy implementation
}

def imprimeNoTerminal(String texto) {
    // dummy implementation
}

def enviaViaRest(String texto) {
    // dummy implementation
}

Pessoa pessoa = Pessoa.comNome("Rafael", "Issao")

imprimeNoArquivo(pessoa.nomeCompleto())
imprimeNoTerminal(pessoa.nomeCompleto())
enviaViaRest(pessoa.nomeCompleto())
