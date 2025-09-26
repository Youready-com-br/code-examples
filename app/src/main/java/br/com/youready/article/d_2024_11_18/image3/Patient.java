package br.com.youready.article.d_2024_11_18.image3;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;

@Getter
public class Patient {
    private final String name;
    private final ManchesterProtocolClassification classification;
    private final Instant arrivalTime;

    public Patient(String name, ManchesterProtocolClassification classification) {
        this.name = name;
        this.classification = classification;
        this.arrivalTime = Instant.now();
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public ManchesterProtocolClassification getClassification() {
        return classification;
    }

    // Movemos a lógica para a classe
    public boolean isWaitingTimeExceeded() {
        Duration waitingTime = Duration.between(this.getArrivalTime(), Instant.now());

        Duration maxWaitTime =
                switch (this.getClassification()) {
                    case IMMEDIATE -> Duration.ofMinutes(0);
                    case VERY_URGENT -> Duration.ofMinutes(10);
                    case URGENT -> Duration.ofMinutes(60);
                    case STANDARD -> Duration.ofHours(2);
                    case NON_URGENT -> Duration.ofHours(4);
                };

        return waitingTime.compareTo(maxWaitTime) > 0;
    }
}
