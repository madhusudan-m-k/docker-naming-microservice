package com.microservice.docker.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.microservice.docker.domain.CurrencyConversionRate;
import com.microservice.docker.repository.CurrencyConversionRateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionService {

    @Autowired
    private CurrencyConversionRateRepository repository;

    public CurrencyConversionRate getCurrencyConversionRate(String sourceCcy, String targetCcy) {

        Optional<CurrencyConversionRate> oCurrencyConversionRate = repository
                .findBySourceCurrencyAndTargetCurrency(sourceCcy, targetCcy);

        return oCurrencyConversionRate.orElse(new CurrencyConversionRate(sourceCcy, targetCcy, BigDecimal.ZERO));
    }
}