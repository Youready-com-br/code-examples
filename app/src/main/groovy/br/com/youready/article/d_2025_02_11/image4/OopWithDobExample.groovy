package br.com.youready.article.d_2025_02_11.image4;

class Pessoa {
    String nome
    int idade
    String dataNascimento

    static Pessoa com(String nome, int idade, String dataNascimento) {
        return new Pessoa(nome: nome, idade: idade, dataNascimento: dataNascimento)
    }

    String informacao() {
        return "$nome $idade $dataNascimento"
    }
}

Pessoa pessoa = Pessoa.com("Rafael Issao", 18, "01/01/2025");

void imprimeInfoPessoaNoTerminal(Pessoa pessoa) {
    println pessoa.informacao()
}

void imprimeInfoPessoaNoArquivo(Pessoa pessoa) {
    new File('infoPessoa').text = pessoa.informacao()
}
