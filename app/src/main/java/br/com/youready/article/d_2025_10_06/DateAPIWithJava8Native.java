package br.com.youready.article.d_2025_10_06;

import java.time.Duration;
import java.time.LocalDateTime;

class DateAPIWithJava8Native implements DateACL {
    @Override
    public String now() {
        return LocalDateTime.now().toString();
    }

    @Override
    public String getInterval(String start, String end) {
        return Duration.between(LocalDateTime.parse(start), LocalDateTime.parse(end))
                .toString();
    }

    @Override
    public String plusWeeks(String date, int weeks) {
        return LocalDateTime.parse(date).plusWeeks(weeks).toString();
    }

    @Override
    public String plusHours(String date, int hours) {
        return LocalDateTime.parse(date).plusHours(hours).toString();
    }
}
