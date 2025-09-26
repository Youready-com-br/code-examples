/**
 * Função para calcular o imposto de renda no Brasil com base na renda bruta mensal.
 *
 * Tabela de alíquotas (2024):
 * - Até R$ 2.112,00: Isento
 * - De R$ 2.112,01 a R$ 2.826,65: 7,5% (dedução: R$ 158,40)
 * - De R$ 2.826,66 a R$ 3.751,05: 15% (dedução: R$ 370,40)
 * - De R$ 3.751,06 a R$ 4.664,68: 22,5% (dedução: R$ 651,73)
 * - Acima de R$ 4.664,68: 27,5% (dedução: R$ 884,96)
 *
 * @param rendaBruta Renda bruta mensal (double)
 * @return O valor do imposto de renda (double)
 */
def calcularImpostoDeRenda(rendaBruta) {
    if (rendaBruta <= 2112.00) {
        return 0.0
    } else if (rendaBruta <= 2826.65) {
        return rendaBruta * 0.075 - 158.40
    } else if (rendaBruta <= 3751.05) {
        return rendaBruta * 0.15 - 370.40
    } else if (rendaBruta <= 4664.68) {
        return rendaBruta * 0.225 - 651.73
    } else {
        return rendaBruta * 0.275 - 884.96
    }
}