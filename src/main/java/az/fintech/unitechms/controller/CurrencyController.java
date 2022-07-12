package com.fintech.unitech.controller;

import com.fintech.unitech.dto.CurrencyDto;
import com.fintech.unitech.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping()
    public List<CurrencyDto> getCurrencies() {
        return currencyService.getCurrencies();
    }
}
