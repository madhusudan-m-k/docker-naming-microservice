package com.currencyexchange.docker.service;

import com.currencyexchange.docker.domain.CurrencyExchange;

public class CurrencyConversionServiceFallback implements CurrencyConversionServiceProxy {

    @Override
    public CurrencyExchange getConversionRate(String sourceCurrency, String targetCurrency) {
        return null;
    }
}