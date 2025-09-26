package br.com.youready.article.d_2024_11_25.image2;

public class BadImplementationLeakageExample {

    private Patient patient;

    public void exemploRuimDeVazamentoDeImplementacao() {
        if (patient.getClassification().equals(ManchesterProtocolClassification.IMMEDIATE)) {
            // faz algo
        } else if (patient.getClassification().equals(ManchesterProtocolClassification.URGENT)) {
            // faz algo
        } // etc
    }
}
