package com.currencyexchange.docker.service;

import java.math.BigDecimal;

import com.currencyexchange.docker.domain.CurrencyExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyConversionServiceProxy proxy;

    public CurrencyExchange exchange(String sourceCurrency, String targetCurrency, BigDecimal sourceCcyAmount) {

        ResponseEntity<CurrencyExchange> ccyExchangeResponseEntity = proxy.getConversionRate(sourceCurrency,
                targetCurrency);

        CurrencyExchange ccyExchange = new CurrencyExchange();
        if (ccyExchangeResponseEntity.getStatusCode() == HttpStatus.OK)
            ccyExchange = ccyExchangeResponseEntity.getBody();

        ccyExchange.setSourceCcyAmount(sourceCcyAmount);
        ccyExchange.setTargetCcyAmount(sourceCcyAmount.multiply(ccyExchange.getExchangeRate()));

        return ccyExchange;
    }
}