package az.fintech.unitechms.service;

import az.fintech.unitechms.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDto> getCurrencies();
}
