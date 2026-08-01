package com.b3.trading;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/ordens")
public class TradingController {

    @Autowired
    private TradingService tradingService;

    @PostMapping("/comprar")
    public String comprar(@RequestParam String ticker, @RequestParam int quantidade, @RequestParam double preco) {
        try {
            return tradingService.comprarAcao(ticker, quantidade, preco);
        } catch (IllegalArgumentException e) {
            return "Erro na B3: " + e.getMessage();
        }
    }
}