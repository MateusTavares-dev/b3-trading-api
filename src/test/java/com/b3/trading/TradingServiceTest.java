package com.b3.trading;

import com.b3.trading.service.TradingService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Suíte de Testes Automatizados (JUnit 5).
 * Garante que atualizações futuras no código não quebrem as regras financeiras da API.
 */
public class TradingServiceTest {

    @Test
    public void testCompraComSucesso() {
        TradingService service = new TradingService();
        
        // Tenta comprar R$ 500 (tem 1000 de saldo por padrão)
        String resultado = service.comprarAcao("PETR4", 50, 10.0);
        
        assertTrue(resultado.contains("Ordem executada"));
        assertEquals(500.0, service.getSaldo()); // Valida se o débito ocorreu
    }

    @Test
    public void testCompraSemSaldoDeveFalhar() {
        TradingService service = new TradingService();
        
        // Tenta comprar R$ 1500 (tem apenas 1000 de saldo)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.comprarAcao("VALE3", 150, 10.0);
        });
        
        // Garante que a aplicação lançou o erro correto ao invés de ficar com saldo negativo
        assertTrue(exception.getMessage().contains("Saldo insuficiente"));
    }
}