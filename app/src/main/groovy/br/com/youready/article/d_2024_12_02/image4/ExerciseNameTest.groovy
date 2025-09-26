package br.com.youready.article.d_2024_12_02.image4

import org.junit.jupiter.api.Test
import static org.assertj.core.api.Assertions.assertThat

class ExerciseName {
    String fullTitle

    ExerciseName(String title) {
        this.fullTitle = title.trim()
    }

    static ExerciseName with(String title) {
        return new ExerciseName(title)
    }

    String buildVideoFileName() {
        return fullTitle.toLowerCase()
    }
}

class ExerciseNameTest {

    @Test
    void "O titulo nao deve ter espacos em volta"() {
        ExerciseName exerciseName = ExerciseName.with(" Agachamento ")

        assertThat(exerciseName.fullTitle)
                .isEqualTo("Agachamento")
    }

    @Test
    void "O nome do arquivo nao deve ter espacos em volta e deve comecar com minusculo"() {
        ExerciseName exerciseName = ExerciseName.with(" Agachamento ")

        assertThat(exerciseName.buildVideoFileName())
                .isEqualTo("agachamento")
    }
}