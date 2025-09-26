package br.com.youready.article.d_2024_11_18.image2;

import java.time.Duration;
import java.time.Instant;

public class TriageService {
    public boolean isWaitingTimeExceeded(Patient patient) {
        Duration waitingTime = Duration.between(patient.getArrivalTime(), Instant.now());

        Duration maxWaitTime =
                switch (patient.getClassification()) {
                    case IMMEDIATE -> Duration.ofMinutes(0);
                    case VERY_URGENT -> Duration.ofMinutes(10);
                    case URGENT -> Duration.ofMinutes(60);
                    case STANDARD -> Duration.ofHours(2);
                    case NON_URGENT -> Duration.ofHours(4);
                };

        return waitingTime.compareTo(maxWaitTime) > 0;
    }
}
