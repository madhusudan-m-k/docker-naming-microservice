package com.currencyexchange.docker.service;

import java.math.BigDecimal;

import com.currencyexchange.docker.domain.CurrencyExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyConversionServiceProxy proxy;

    public CurrencyExchange exchange(String sourceCurrency, String targetCurrency, BigDecimal sourceCcyAmount) {

        CurrencyExchange ccyExchange = proxy.getConversionRate(sourceCurrency, targetCurrency);

        ccyExchange.setSourceCcyAmount(sourceCcyAmount);
        ccyExchange.setTargetCcyAmount(sourceCcyAmount.multiply(ccyExchange.getExchangeRate()));

        return ccyExchange;
    }
}