package br.com.youready.article.d_2025_01_13.image1;

import org.junit.jupiter.api.Test;

class TestClass {
    @Test
    void ehAnoBissextoTest() {
        // Dados
        int ano = 2016;

        // Ação
        boolean resultado = AnoBissexto.ehAnoBissexto(ano);

        // Verificação
        Assertions.assertTrue(resultado);
    }
}
