package com.currencyexchange.docker.service;

import com.currencyexchange.docker.domain.CurrencyExchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//@FeignClient(name = "currencyconversionservice", url = "${CCY_CONVERSION_SERVICE:localhost:8080/conversionservice/}", fallback = CurrencyConversionServiceFallback.class)
@FeignClient(name = "CURRENCY-CONVERSION-SERVICE", fallback = CurrencyConversionServiceFallback.class, decode404 = true)
public interface CurrencyConversionServiceProxy {

    @GetMapping(value = "/conversionservice/conversionrate/from/{sourceCurrency}/to/{targetCurrency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<CurrencyExchange> getConversionRate(
            @PathVariable("sourceCurrency") String sourceCurrency,
            @PathVariable("targetCurrency") String targetCurrency);

}