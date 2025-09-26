package br.com.youready.article.d_2025_01_13.image2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestClass {
    @Test
    void ehAnoBissextoTest() {
        // Dados + Ação + Verificação
        Assertions.assertTrue(AnoBissexto.ehAnoBissexto(2016));
    }
}
