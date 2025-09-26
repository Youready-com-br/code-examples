package br.com.youready.article.d_2025_02_11.image1;

def pessoa = [
    nome: 'Rafael Issao',
    idade: 18
]

void imprimeInfoPessoaNoTerminal(pessoa) {
    println "${pessoa.nome} ${pessoa.idade}"
}

void imprimeInfoPessoaNoArquivo(pessoa) {
    new File('infoPessoa').text = "${pessoa.nome} ${pessoa.idade}"
}
