package com.currencyexchange.docker.controller;

import java.math.BigDecimal;

import com.currencyexchange.docker.domain.CurrencyExchange;
import com.currencyexchange.docker.service.CurrencyExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencyexchange")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService ccyExchangeService;

    public CurrencyExchangeController() {
    }

    @GetMapping(value = "/")
    public String helloCurrencyExchangeController() {
        return "Hello from CurrencyExchangeController";
    }

    @GetMapping(value = "/exchangeccy/from/{sourceCcy}/to/{targetCcy}/amount/{sourceCcyAmount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<CurrencyExchange> exchangeCurrency(@PathVariable("sourceCcy") String sourceCcy,
            @PathVariable("targetCcy") String targetCcy, @PathVariable("sourceCcyAmount") BigDecimal sourceCcyAmount) {

        CurrencyExchange currencyExchange = ccyExchangeService.exchange(sourceCcy, targetCcy, sourceCcyAmount);

        ResponseEntity<CurrencyExchange> responseEntity = ResponseEntity.ok(currencyExchange);

        return responseEntity;
    }
}