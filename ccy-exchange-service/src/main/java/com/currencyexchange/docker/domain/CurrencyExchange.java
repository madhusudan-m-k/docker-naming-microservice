package com.currencyexchange.docker.domain;

import java.math.BigDecimal;

public class CurrencyExchange {

    private long id;

    private String sourceCurrency;

    private String targetCurrency;

    private BigDecimal exchangeRate;

    private BigDecimal sourceCcyAmount;

    private BigDecimal targetCcyAmount;

    public CurrencyExchange() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getSourceCcyAmount() {
        return sourceCcyAmount;
    }

    public void setSourceCcyAmount(BigDecimal sourceCcyAmount) {
        this.sourceCcyAmount = sourceCcyAmount;
    }

    public BigDecimal getTargetCcyAmount() {
        return targetCcyAmount;
    }

    public void setTargetCcyAmount(BigDecimal targetCcyAmount) {
        this.targetCcyAmount = targetCcyAmount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CurrencyExchange [exchangeRate=").append(exchangeRate).append(", id=").append(id)
                .append(", sourceCcyAmount=").append(sourceCcyAmount).append(", sourceCurrency=").append(sourceCurrency)
                .append(", targetCcyAmount=").append(targetCcyAmount).append(", targetCurrency=").append(targetCurrency)
                .append("]");
        return builder.toString();
    }

}