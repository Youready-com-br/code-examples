package br.com.youready.article.d_2025_02_11.image2;

def pessoa = [
    nome: 'Rafael Issao',
    idade: 18,
    dataNascimento: '01/01/2025'
]

void imprimeInfoPessoaNoTerminal(pessoa) {
    println "${pessoa.nome} ${pessoa.idade} ${pessoa.dataNascimento}"
}

void imprimeInfoPessoaNoArquivo(pessoa) {
    new File('infoPessoa').text = "${pessoa.nome} ${pessoa.idade} ${pessoa.dataNascimento}"
}
