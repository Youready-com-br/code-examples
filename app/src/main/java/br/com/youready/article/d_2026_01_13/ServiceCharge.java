package br.com.youready.article.d_2026_01_13;

import lombok.Getter;

@Getter
class ServiceCharge {
    private String description;
    private int amount;
    private boolean taxable;

    public ServiceCharge(String description, int amount, boolean taxable) {
        this.description = description;
        this.amount = amount;
        this.taxable = taxable;
    }

    @Override
    public String toString() {
        return String.format("%s: $%d%s", description, amount, taxable ?
                " (taxable)" : "");
    }
}
