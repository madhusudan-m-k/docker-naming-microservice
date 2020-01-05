package com.microservice.docker.repository;

import java.util.Optional;

import com.microservice.docker.domain.CurrencyConversionRate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRateRepository extends JpaRepository<CurrencyConversionRate, Long> {

    public Optional<CurrencyConversionRate> findBySourceCurrencyAndTargetCurrency(String sourceCurrency,
            String tagetCurrency);
}