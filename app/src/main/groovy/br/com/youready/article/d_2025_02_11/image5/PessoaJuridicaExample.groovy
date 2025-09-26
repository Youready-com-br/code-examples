package br.com.youready.article.d_2025_02_11.image5;

class PessoaJuridica {
    String razaoSocial
    String cnpj

    String informacao() {
        return "$razaoSocial $cnpj"
    }
}

def pessoa = new PessoaJuridica(razaoSocial: "Youready", cnpj: "50.090.353/0001-06");

void imprimeInfoPessoaNoTerminal(PessoaJuridica pessoa) {
    println pessoa.informacao()
}

void imprimeInfoPessoaNoArquivo(PessoaJuridica pessoa) {
    new File('infoPessoa').text = pessoa.informacao()
}
