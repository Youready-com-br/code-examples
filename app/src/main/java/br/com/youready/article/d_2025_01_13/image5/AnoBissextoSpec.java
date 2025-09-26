package br.com.youready.article.d_2025_01_13.image5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnoBissextoSpec {

    @Nested
    class EhBissextoQuando {
        @ParameterizedTest
        @ValueSource(ints = {320, 240, 1280, 2160})
        void seEhDivisivelPor4MasNaoPor100(int ano) {
            System.out.println(ano);
        }

        @ParameterizedTest
        @ValueSource(ints = {400, 800, 1600, 2400})
        void seEhDivisivelPor400(int ano) {
            System.out.println(ano);
        }
    }

    @Nested
    class NaoEhBissextoQuando {
        @ParameterizedTest
        @ValueSource(ints = {2018, 2017, 47, 1})
        void seNaoEhDivisivelPor4(int ano) {
            System.out.println(ano);
        }

        @ParameterizedTest
        @ValueSource(ints = {1700, 1800, 300, 100})
        void seEhDivisivelPor100MasNaoPor400(int ano) {
            System.out.println(ano);
        }
    }

    @Nested
    class NaoSuportaELancaExcecao {
        @Test
        void quando0AnoEhZero() {}

        @ParameterizedTest
        @ValueSource(ints = {-1, -100, -400})
        void quando0AnoEhNegativo(int ano) {
            System.out.println(ano);
        }
    }
}
