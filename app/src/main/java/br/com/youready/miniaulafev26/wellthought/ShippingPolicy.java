package br.com.youready.miniaulafev26.wellthought;

import java.math.BigDecimal;

public class ShippingPolicy {
    // Valores nomeados conforme a regra de negócio
    private static final BigDecimal STANDARD_LIMIT = new BigDecimal("100" +
            ".00");
    private static final BigDecimal VIP_LIMIT = new BigDecimal("50.00");

    // Recebe Boolean (wrapper) para suportar nulos de clientes legados
    public static boolean applyFreeShipping(BigDecimal amount,
                                     Boolean isVip) {

        // Design Defensivo: Trata null como false (Retrocompatibilidade)
        BigDecimal limit = Boolean.TRUE.equals(isVip) ? VIP_LIMIT :
                STANDARD_LIMIT;

        return amount.compareTo(limit) > 0;
    }
}