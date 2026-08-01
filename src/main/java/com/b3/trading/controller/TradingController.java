package com.b3.trading.controller;

import com.b3.trading.service.TradingService;
import com.b3.trading.dto.OrdemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Camada de Controle (@RestController).
 * Responsável exclusivamente por gerenciar as requisições HTTP da web.
 * Não contém regras de negócio, apenas orquestra a comunicação.
 */
@RestController
@RequestMapping("/api/ordens")
public class TradingController {

    @Autowired
    private TradingService tradingService;

    /**
     * Endpoint para processar compras de ações via JSON.
     * Utiliza ResponseEntity para devolver o Código HTTP correto (201 ou 400).
     */
    @PostMapping("/comprar")
    public ResponseEntity<String> comprar(@RequestBody OrdemRequest ordem) {
        try {
            // Repassa os dados recebidos via JSON para a camada de serviço
            String recibo = tradingService.comprarAcao(ordem.getTicker(), ordem.getQuantidade(), ordem.getPreco());
            
            // Retorna HTTP 201 (Created) em caso de sucesso
            return ResponseEntity.status(HttpStatus.CREATED).body(recibo);
            
        } catch (IllegalArgumentException e) {
            // Retorna HTTP 400 (Bad Request) em caso de falta de saldo
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de Validação: " + e.getMessage());
        }
    }
}