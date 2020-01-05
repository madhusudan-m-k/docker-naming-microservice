package com.currencyexchange.docker.service;

import com.currencyexchange.docker.domain.CurrencyExchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "currencyconversionservice", url = "${CCY_CONVERSION_SERVICE:localhost:8080/conversionservice/}", fallback = CurrencyConversionServiceFallback.class)
public interface CurrencyConversionServiceProxy {

    @GetMapping(value = "/conversionrate/from/{sourceCurrency}/to/{targetCurrency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyExchange getConversionRate(@PathVariable("sourceCurrency") String sourceCurrency,
            @PathVariable("targetCurrency") String targetCurrency);
}