package br.com.youready.article.d_2024_12_02.image6

import static br.com.youready.article.d_2024_12_02.image6.TabelaImpostoRenda.com
import static br.com.youready.article.d_2024_12_02.image6.TabelaImpostoRenda.faixa
import static br.com.youready.article.d_2024_12_02.image6.TabelaImpostoRenda.MAX_VALUE

def calculaImpostoDeRendaBrasil2024(rendaBruta) {
    def tabelaImpostoRenda = com(
            faixa(inferior: 0.00, superior: 2112.00, aliquota: 0, deducao: 0.00),
            faixa(inferior: 2112.01, superior: 2826.65, aliquota: 7.5, deducao: 158.40),
            faixa(inferior: 2826.66, superior: 3751.05, aliquota: 15, deducao: 370.40),
            faixa(inferior: 3751.06, superior: 4664.68, aliquota: 22.5, deducao: 651.73),
            faixa(inferior: 4664.69, superior: MAX_VALUE, aliquota: 27.5, deducao: 884.96)
    )

    def faixa = tabelaImpostoRenda.encontraFaixa(rendaBruta)

    return rendaBruta * faixa.aliquota - faixa.deducao
}
