package com.fintech.unitech.service;

import com.fintech.unitech.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDto> getCurrencies();
}
