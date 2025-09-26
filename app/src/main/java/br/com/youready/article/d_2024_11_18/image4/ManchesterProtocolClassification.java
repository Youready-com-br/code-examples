package br.com.youready.article.d_2024_11_18.image4;

import java.time.Duration;

enum ManchesterProtocolClassification {
    IMMEDIATE(Duration.ofMinutes(0)),
    VERY_URGENT(Duration.ofMinutes(10)),
    URGENT(Duration.ofMinutes(60)),
    STANDARD(Duration.ofHours(2)),
    NON_URGENT(Duration.ofHours(4));

    private final Duration maxWaitTime;

    ManchesterProtocolClassification(Duration maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public boolean isWaitingTimeExceed(Duration waitingTime) {
        return waitingTime.compareTo(maxWaitTime) > 0;
    }
}
