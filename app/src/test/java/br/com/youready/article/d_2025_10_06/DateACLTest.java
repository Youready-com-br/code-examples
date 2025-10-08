package br.com.youready.article.d_2025_10_06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;

public class DateACLTest {

    @ParameterizedTest
    @ValueSource(classes = {DateAPIWithJava8Native.class, DateAPIWithJodaTime.class})
    void plusWeeksTest(Class<DateACL> dateACLClass) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        var dateACL = dateACLClass.getDeclaredConstructor()
                                    .newInstance();

        String result = dateACL.plusWeeks("2025-10-06T10:00:00", 7);
        Assertions.assertThat(result).isEqualTo("2025-11-24T10:00");
    }
}
