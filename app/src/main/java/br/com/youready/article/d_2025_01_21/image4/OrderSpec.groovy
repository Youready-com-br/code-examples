package br.com.youready.article.d_2025_01_21.image4;

import spock.lang.Specification
import static org.junit.jupiter.api.Assertions.assertEquals

class OrderSpec extends Specification {

    def "Teclado e mouse deve ter um desconto de 25% no blackfriday"() {
        setup:
        Item teclado = new Item('Teclado', 100, 10)
        Item mouse = new Item('Mouse', 50, 5)

        List<String> itensComDesconto = [teclado.name(), mouse.name()]

        Order order = new Order(1L, [teclado, mouse])

        when:
        def total = order.getTotal(itensComDesconto)

        then:
        def expectedTotal = teclado.price() * teclado.quantity() * 0.75
        expectedTotal += mouse.price() * mouse.quantity() * 0.75

        assertEquals(expectedTotal, total)
    }
}