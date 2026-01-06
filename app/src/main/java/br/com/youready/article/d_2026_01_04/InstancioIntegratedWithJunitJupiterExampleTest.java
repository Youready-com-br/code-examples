package br.com.youready.article.d_2026_01_04;

import org.instancio.junit.*;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

// Anotação obrigatória para usar, por exemplo, @Given, @WithSettings, @Seed e @InstancioSource
@ExtendWith(InstancioExtension.class)
public class InstancioIntegratedWithJunitJupiterExampleTest {

    @Given
    PessoaFisica pessoaFisica;

    // Possibilidade de configurar o Instancio na classe
    @WithSettings
    private static final Settings settings = Settings.create()
                                              .set(Keys.BEAN_VALIDATION_ENABLED, true)
                                              .set(Keys.JPA_ENABLED, true);

    @Test
    void noNeedToUseInstancioDirectly() {
        // Injetado via @Given
        assertThat(pessoaFisica).hasNoNullFieldsOrProperties();

        System.out.println("pessoaFisica = " + pessoaFisica);
    }

    @ParameterizedTest
    @InstancioSource
    void letsUseTheRandomDataMultipleTimes(PessoaFisica pessoaFisica) {
        // Data Driven Testing. 100 amostras é o valor padrão
        assertThat(pessoaFisica).hasNoNullFieldsOrProperties();

        System.out.println("pessoaFisica = " + pessoaFisica);
    }

    @Test
    @Seed(666919272848427237L) // Esta anotação garante que será gerado os mesmos dados para facilitar o debug
    void aSeedIsProvidedWhenErrorOccurs() {
        // Esse teste falha com dados aleatórios, mas o instancio provê a semente utilizada para gerar os dados aleatórios:
        // O texto abaixo é fornecido quando um teste falha:
        //  Test method 'aSeedIsProvidedWhenErrorOccurs' failed with seed: 666919272848427237 (seed source: random seed)
        assertThat(pessoaFisica).hasNoNullFieldsOrProperties()
                .extracting(PessoaFisica::getName)
                .isEqualTo("Nome não existente");

        System.out.println("pessoaFisica = " + pessoaFisica);
    }
}
