package br.com.youready.article.d_2026_01_04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadSampleExampleTest {


    @Test
    void verifySumOfTwoIntegersIsAlwaysPositive() {
        int umPositivo = 1;
        int outroPositivo = 2;

        assertThat(umPositivo).isPositive();
        assertThat(outroPositivo).isPositive();
        assertThat(Integer.sum(umPositivo, outroPositivo))
                  .isPositive();
    }

    @Test
    void failingTest() {
        int umPositivo = 1;
        int outroPositivo = 1 + Integer.MAX_VALUE;

        assertThat(umPositivo + Integer.MAX_VALUE).isPositive();
        assertThat(outroPositivo).isPositive();
        assertThat(Integer.sum(umPositivo, outroPositivo))
                .isPositive();
    }
}
