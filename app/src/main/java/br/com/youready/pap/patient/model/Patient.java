package br.com.youready.pap.patient.model;

import java.time.Duration;
import java.time.Instant;
import lombok.Getter;

/**
 * API do pacote br.com.youready.pap.patient.model
 */
public class Patient {
    /**
     * Único getter necessário para API
     */
    @Getter
    private final String name;

    /**
     * Campos que são detalhes de implementação. Não devemos criar getter para eles.
     */
    private final ManchesterProtocolClassification classification;

    private final Instant arrivalTime;

    /**
     * Construtor privado para evitar o vazamento do detalhe de implementação.
     * Neste caso, o enum ManchesterProtocolClassification é detalhe de implementação
     * que não deve vazar deste pacote
     */
    private Patient(String name, ManchesterProtocolClassification classification) {
        this.name = name;
        this.classification = classification;
        this.arrivalTime = Instant.now();
    }

    /**
     * Métodos de fábrica para cada estado possível do paciente.
     * Com isso:
     * - Evitamos paciente com classification com valor nulo.
     * - Deixamos claro, via API, que tipo de pacientes é possível criar.
     */
    public static Patient nonUrgent(String name) {
        return new Patient(name, ManchesterProtocolClassification.NON_URGENT);
    }

    public static Patient standard(String name) {
        return new Patient(name, ManchesterProtocolClassification.STANDARD);
    }

    public static Patient urgent(String name) {
        return new Patient(name, ManchesterProtocolClassification.URGENT);
    }

    public static Patient veryUrgent(String name) {
        return new Patient(name, ManchesterProtocolClassification.VERY_URGENT);
    }

    public static Patient immediate(String name) {
        return new Patient(name, ManchesterProtocolClassification.IMMEDIATE);
    }

    public boolean isWaitingTimeExceeded() {
        Duration waitingTime = Duration.between(this.arrivalTime, Instant.now());
        return this.classification.isWaitingTimeExceed(waitingTime);
    }
}
