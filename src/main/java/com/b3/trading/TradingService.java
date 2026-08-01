package com.b3.trading;

import org.springframework.stereotype.Service;

@Service
public class TradingService {
    
    private double saldoDisponivel = 1000.00; // Saldo simulado do cliente

    public String comprarAcao(String ticker, int quantidade, double preco) {
        double valorTotal = quantidade * preco;

        if (valorTotal > saldoDisponivel) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar a compra.");
        }

        saldoDisponivel -= valorTotal;
        return "Ordem executada! " + quantidade + " ações da " + ticker + " compradas. Saldo restante: R$ " + saldoDisponivel;
    }

    public double getSaldo() {
        return saldoDisponivel;
    }
}