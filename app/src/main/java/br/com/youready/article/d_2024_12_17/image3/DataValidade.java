package br.com.youready.article.d_2024_12_17.image3;

public class DataValidade {
    public static DataValidade de(int mes, int ano) {
        return new DataValidade();
    }

    public static DataValidade de(int dia, int mes, int ano) {
        return new DataValidade();
    }

    public boolean venceAntes(DataValidade validade) {
        return false;
    }

    public boolean vencido() {
        return false;
    }
}
