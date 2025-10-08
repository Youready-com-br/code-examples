package br.com.youready.article.d_2025_10_06;

import java.time.Duration;
import java.time.LocalDateTime;

class BusinessRuleOne {
    public void doSomeWork() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekLater = now.plusWeeks(1);
        Duration interval = Duration.between(now, oneWeekLater);
        // Do some work with the interval
    }
}
