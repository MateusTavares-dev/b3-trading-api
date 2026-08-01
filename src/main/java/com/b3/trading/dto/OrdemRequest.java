package com.b3.trading.dto;

/**
 * Classe DTO (Data Transfer Object).
 * Padrão de projeto usado para transportar dados entre o Front-end e a API.
 * Garante que a API receba um JSON estruturado e seguro.
 */
public class OrdemRequest {
    
    private String ticker;
    private int quantidade;
    private double preco;

    // Getters e Setters (Necessários para o Spring converter o JSON em Objeto Java)
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}