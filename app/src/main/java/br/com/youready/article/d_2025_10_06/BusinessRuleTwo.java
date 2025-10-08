package br.com.youready.article.d_2025_10_06;

import java.time.Duration;
import java.time.LocalDateTime;

class BusinessRuleTwo {
    public void doMoreWork() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixHoursLater = now.plusHours(6);
        Duration interval = Duration.between(now, sixHoursLater);
        // Do some work with the interval
    }
}
