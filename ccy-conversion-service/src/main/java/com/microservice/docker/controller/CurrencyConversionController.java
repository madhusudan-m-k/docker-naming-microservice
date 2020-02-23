package com.microservice.docker.controller;

import com.microservice.docker.domain.CurrencyConversionRate;
import com.microservice.docker.service.CurrencyConversionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversionservice")
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyConversionService service;

    @GetMapping("/")
    public String helloConversionRate() {
        return "Hello from Currency Conversion Service";
    }

    @GetMapping(value = "/conversionrate/from/{sourceCurrency}/to/{targetCurrency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<CurrencyConversionRate> getConversionRate(
            @PathVariable("sourceCurrency") String sourceCurrency,
            @PathVariable("targetCurrency") String targetCurrency) {

        logger.debug("Received an API call source currency " + sourceCurrency + " target currency " + targetCurrency);
        CurrencyConversionRate currencyConversionRate = service.getCurrencyConversionRate(sourceCurrency,
                targetCurrency);

        ResponseEntity<CurrencyConversionRate> entity = ResponseEntity.ok(currencyConversionRate);
        return entity;
    }

}