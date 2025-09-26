package br.com.youready.article.d_2024_12_02.image6

import static java.lang.Double.MAX_VALUE

class TabelaImpostoRenda {
    List<Faixa> faixas

    TabelaImpostoRenda(List<Faixa> faixas) {
        this.faixas = faixas
    }

    Faixa encontraFaixa(double renda) {
        faixas.find { it.inferior <= renda && renda <= it.superior }
    }

    static TabelaImpostoRenda com(Faixa... faixas) {
        new TabelaImpostoRenda(faixas.toList())
    }

    static Faixa faixa(Map<String, Double> params) {
        new Faixa(params)
    }

    static final double MAX_VALUE = Double.MAX_VALUE
}

class Faixa {
    double inferior
    double superior
    double aliquota
    double deducao
}