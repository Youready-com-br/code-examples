package br.com.youready.article.d_2024_12_02.image4

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

class ExerciseNameTest extends Specification {

    def "O título não deve ter espaços em volta"() {
        given:
        ExerciseName exerciseName = ExerciseName.with(" Agachamento ", "")

        expect:
        assertThat(exerciseName.fullTitle)
                .isEqualTo("Agachamento")
    }

    def "O nome do arquivo não deve ter espaços em volta e deve começar com minúsculo"() {
        given:
        ExerciseName exerciseName = ExerciseName.with(" Agachamento ", "")

        expect:
        assertThat(exerciseName.buildVideoFileName())
                .isEqualTo("agachamento")
    }
}

class ExerciseName {
    private String title
    private String subtitle

    private ExerciseName(String title, String subtitle) {
        this.title = title
        this.subtitle = subtitle
    }

    static ExerciseName with(String title, String subtitle) {
        return new ExerciseName(title.trim(), subtitle)
    }

    String getFullTitle() {
        return title
    }

    String buildVideoFileName() {
        return title.toLowerCase()
    }
}
