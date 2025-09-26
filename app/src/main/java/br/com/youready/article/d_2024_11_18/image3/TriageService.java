package br.com.youready.article.d_2024_11_18.image3;

public class TriageService {
    public boolean isWaitingTimeExceeded(Patient patient) {
        // Aplicamos o tell, dont ask!
        return patient.isWaitingTimeExceeded();
    }
}
