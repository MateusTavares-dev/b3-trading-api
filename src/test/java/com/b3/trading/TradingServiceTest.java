package com.b3.trading;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TradingServiceTest {

    @Test
    public void testCompraComSucesso() {
        TradingService service = new TradingService();
        // Tenta comprar R$ 500 (tem 1000 de saldo)
        String resultado = service.comprarAcao("PETR4", 50, 10.0);
        assertTrue(resultado.contains("Ordem executada"));
        assertEquals(500.0, service.getSaldo());
    }

    @Test
    public void testCompraSemSaldoDeveFalhar() {
        TradingService service = new TradingService();
        // Tenta comprar R$ 1500 (só tem 1000 de saldo)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.comprarAcao("VALE3", 150, 10.0);
        });
        assertEquals("Saldo insuficiente para realizar a compra.", exception.getMessage());
    }
}