package br.com.youready.article.d_2024_12_17.image5;

import java.time.LocalDate;

class DataValidade {
    private final int dia, mes, ano;

    private DataValidade(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static DataValidade de(int mes, int ano) {
        return new DataValidade(99, mes, ano);
    }

    public static DataValidade de(int dia, int mes, int ano) {
        return new DataValidade(dia, mes, ano);
    }

    public boolean venceAntes(DataValidade validade) {
        return venceAntes(validade.dia, validade.mes, validade.ano);
    }

    public boolean vencido() {
        LocalDate agora = LocalDate.now();
        int dia = agora.getDayOfMonth();
        int mes = agora.getMonthValue();
        int ano = agora.getYear();
        return venceAntes(dia, mes, ano);
    }

    private boolean venceAntes(int outroDia, int outroMes, int outroAno) {
        if (this.ano < outroAno) {
            return true;
        } else if (this.ano == outroAno) {
            if (this.mes < outroMes) {
                return true;
            } else if (this.mes == outroMes) {
                return this.dia < outroDia;
            }
        }
        return false;
    }
}
