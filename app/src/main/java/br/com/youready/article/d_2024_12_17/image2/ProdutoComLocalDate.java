package br.com.youready.article.d_2024_12_17.image2;

import java.time.LocalDate;
import java.time.YearMonth;

class ProdutoComLocalDate {
    private final LocalDate validade;

    private ProdutoComLocalDate(LocalDate validade) {
        this.validade = validade;
    }

    public static ProdutoComLocalDate comValidade(int mes, int ano) {
        return new ProdutoComLocalDate(YearMonth.of(ano, mes).atEndOfMonth());
    }

    public static ProdutoComLocalDate comValidade(int dia, int mes, int ano) {
        return new ProdutoComLocalDate(LocalDate.of(dia, mes, ano));
    }

    public boolean venceAntes(ProdutoComLocalDate outroProduto) {
        return this.validade.isBefore(outroProduto.validade);
    }

    public boolean vencido() {
        return this.validade.isBefore(LocalDate.now());
    }
}
