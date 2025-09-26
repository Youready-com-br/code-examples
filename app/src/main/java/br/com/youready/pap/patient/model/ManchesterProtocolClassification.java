package br.com.youready.pap.patient.model;

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
