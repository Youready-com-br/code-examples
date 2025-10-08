package br.com.youready.article.d_2025_10_06;

class BusinessRuleOneDIP {
    private final DateACL dateAPI;

    // Injeção de dependência via construtor
    public BusinessRuleOneDIP(DateACL dateAPI) {
        this.dateAPI = dateAPI;
    }

    public void doSomeWork() {
        // A regra de negócio não depende mais da implementação concreta da API de datas
        String now = dateAPI.now();
        String oneWeekLater = dateAPI.plusWeeks(now, 1);
        String interval = dateAPI.getInterval(now, oneWeekLater);
    }
}
