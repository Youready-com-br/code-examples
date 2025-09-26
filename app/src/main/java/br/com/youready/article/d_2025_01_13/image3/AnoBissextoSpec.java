package br.com.youready.article.d_2025_01_13.image3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnoBissextoSpec {

    @Nested
    class EhBissextoQuando {
        @Test
        void seEhDivisivelPor4MasNaoPor100() {}

        @Test
        void seEhDivisivelPor400() {}
    }

    @Nested
    class NaoEhBissextoQuando {
        @Test
        void seNaoEhDivisivelPor4() {}

        @Test
        void seEhDivisivelPor100MasNaoPor400() {}
    }
}
