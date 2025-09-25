package br.com.youready.article.d_2024_12_17.image4;

import java.time.LocalDate;
import java.time.YearMonth;

class DataValidade {
    private final LocalDate data;

    private DataValidade(LocalDate data) {
        this.data = data;
    }

    public static DataValidade de(int mes, int ano) {
        return new DataValidade(YearMonth.of(ano, mes).atEndOfMonth());
    }

    public static DataValidade de(int dia, int mes, int ano) {
        return new DataValidade(LocalDate.of(ano, mes, dia));
    }

    public boolean venceAntes(DataValidade validade) {
        return this.data.isBefore(validade.data);
    }

    public boolean vencido() {
        return this.data.isBefore(LocalDate.now());
    }
}
