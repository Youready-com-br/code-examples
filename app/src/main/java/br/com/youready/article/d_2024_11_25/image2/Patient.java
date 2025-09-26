package br.com.youready.article.d_2024_11_25.image2;

import br.com.youready.article.d_2024_11_18.image2.ManchesterProtocolClassification;
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
}
