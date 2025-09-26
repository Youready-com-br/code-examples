package br.com.youready.article.d_2025_02_11.image3;

class Pessoa {
    String nome
    int idade

    static Pessoa com(String nome, int idade) {
        return new Pessoa(nome: nome, idade: idade)
    }

    String informacao() {
        return "$nome $idade"
    }
}

Pessoa pessoa = Pessoa.com("Rafael Issao", 18);

void imprimeInfoPessoaNoTerminal(Pessoa pessoa) {
    println pessoa.informacao()
}

void imprimeInfoPessoaNoArquivo(Pessoa pessoa) {
    new File('infoPessoa').text = pessoa.informacao()
}
