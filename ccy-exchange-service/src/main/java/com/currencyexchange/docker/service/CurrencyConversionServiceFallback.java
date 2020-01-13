package com.currencyexchange.docker.service;

import com.currencyexchange.docker.domain.CurrencyExchange;

import org.springframework.http.ResponseEntity;

public class CurrencyConversionServiceFallback implements CurrencyConversionServiceProxy {

    @Override
    public ResponseEntity<CurrencyExchange> getConversionRate(String sourceCurrency, String targetCurrency) {
        return null;
    }
}