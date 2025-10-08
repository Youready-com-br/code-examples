package br.com.youready.article.d_2025_10_06;

class BusinessRuleTwoDIP {
    private final DateACL dateAPI;

    // Injeção de dependência via construtor
    public BusinessRuleTwoDIP(DateACL dateAPI) {
        this.dateAPI = dateAPI;
    }

    public void doMoreWork() {
        String now = dateAPI.now();
        String sixHoursLater = dateAPI.plusHours(now, 6);
        String interval = dateAPI.getInterval(now, sixHoursLater);
    }
}
