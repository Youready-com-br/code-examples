package br.com.youready.article.d_2024_12_17.image3;

class Produto {
    private final DataValidade validade;

    private Produto(DataValidade validade) {
        this.validade = validade;
    }

    public static Produto comValidade(int mes, int ano) {
        return new Produto(DataValidade.de(mes, ano));
    }

    public static Produto comValidade(int dia, int mes, int ano) {
        return new Produto(DataValidade.de(dia, mes, ano));
    }

    public boolean venceAntes(Produto outroProduto) {
        return this.validade.venceAntes(outroProduto.validade);
    }

    public boolean vencido() {
        return this.validade.vencido();
    }
}
