package br.com.youready.article.d_2024_12_02.image1

class Pessoa {
    String nome
    String sobrenome

    static Pessoa comNome(String nome, String sobrenome) {
        new Pessoa(nome: nome, sobrenome: sobrenome)
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

imprimeNoArquivo(pessoa.nome() + " " + pessoa.sobrenome())
imprimeNoTerminal(pessoa.nome() + " " + pessoa.sobrenome())
enviaViaRest(pessoa.nome() + " " + pessoa.sobrenome())
