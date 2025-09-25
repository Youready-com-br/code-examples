package br.com.youready.article.d_2024_12_17.image1;

import java.util.Calendar;
import java.util.Date;

class ProdutoComDate {
    private final Date validade;

    private ProdutoComDate(Date validade) {
        this.validade = validade;
    }

    public static ProdutoComDate comValidade(int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes - 1); // Lembrar que é zero-based index
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new ProdutoComDate(calendar.getTime());
    }

    public static ProdutoComDate comValidade(int dia, int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes - 1); // Lembrar que é zero-based index
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new ProdutoComDate(calendar.getTime());
    }

    public boolean venceAntes(ProdutoComDate outroProduto) {
        return this.validade.before(outroProduto.validade);
    }

    public boolean vencido() {
        return this.validade.before(Calendar.getInstance().getTime());
    }
}
