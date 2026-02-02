package br.com.youready.miniaulafev26.wellthought;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static br.com.youready.miniaulafev26.wellthought.ShippingPolicy.applyFreeShipping;
import static org.assertj.core.api.Assertions.assertThat;

class ShippingPolicyTest {

    @Test
    @DisplayName("VIPs should get free shipping for orders above 50.00")
    void vipShouldHaveLowerLimit() {
        // Given
        var isVip = true;

        // When / Then
        assertThat(applyFreeShipping(amount("50.01"), isVip)).isTrue();
        assertThat(applyFreeShipping(amount("50.00"), isVip)).isFalse();
    }

    @Test
    @DisplayName("Standard customers should get free shipping for orders above 100.00")
    void standardShouldHaveHigherLimit() {
        // Given
        var isVip = false;

        // When / Then
        assertThat(applyFreeShipping(amount("100.01"), isVip)).isTrue();
        assertThat(applyFreeShipping(amount("100.00"), isVip)).isFalse();
    }

    @Test
    @DisplayName("Null VIP status is treated as Standard customer")
    void nullVipShouldBeTreatedAsStandard() {
        // Given
        Boolean isVip = null;

        // When / Then
        assertThat(applyFreeShipping(amount("100.01"), isVip)).isTrue();
        assertThat(applyFreeShipping(amount("100.00"), isVip)).isFalse();
    }

    private BigDecimal amount(String value) {
        return new BigDecimal(value);
    }
}
