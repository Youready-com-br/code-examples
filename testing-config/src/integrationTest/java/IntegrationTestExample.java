
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTestExample {

    @Test
    void integrationTest() {
        int a = 1;

        Assertions.assertThat(a)
                  .isEqualTo(1);
    }
}
