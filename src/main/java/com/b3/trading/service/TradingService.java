package com.b3.trading.service;

import org.springframework.stereotype.Service;

/**
 * Camada de Serviço (@Service).
 * Mantém o estado da aplicação em memória (Escopo Singleton do Spring) 
 * e abriga as regras de negócio rígidas do mercado financeiro.
 */
@Service
public class TradingService {
    
    // Saldo simulado da conta do cliente (Mantido em memória)
    private double saldoDisponivel = 1000.00; 

    /**
     * Valida e executa a compra de um ativo.
     * @return String com o comprovante de sucesso.
     * @throws IllegalArgumentException se o saldo for insuficiente.
     */
    public String comprarAcao(String ticker, int quantidade, double preco) {
        double valorTotal = quantidade * preco;

        // Validação Crítica de Negócio: Bloqueia transações sem fundo
        if (valorTotal > saldoDisponivel) {
            throw new IllegalArgumentException("Saldo insuficiente. Operação recusada pela B3.");
        }

        // Executa o débito na conta
        saldoDisponivel -= valorTotal;
        return "Ordem executada com sucesso! " + quantidade + " cotas da " + ticker + " adquiridas. Saldo restante: R$ " + saldoDisponivel;
    }

    public double getSaldo() {
        return saldoDisponivel;
    }
}