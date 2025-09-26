package br.com.youready.article.d_2024_12_02.image7


class LinhaRefatorada {
    Ponto inicio
    Ponto fim
    def comprimento() {
        return inicio.distancia(fim)
    }
}