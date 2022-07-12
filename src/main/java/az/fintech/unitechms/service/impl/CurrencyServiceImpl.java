package com.fintech.unitech.service.impl;

import com.fintech.unitech.dto.CurrencyDto;
import com.fintech.unitech.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final com.fintech.unitech.service.CurrencyService2 currencyService2;

    @Override
    public List<CurrencyDto> getCurrencies() {
        return currencyService2.getCurrencies()
                .entrySet()
                .stream()
                .map(c -> new CurrencyDto(c.getKey().split("/")[0], c.getKey().split("/")[1], c.getValue()))
                .collect(Collectors.toList());
    }
}
