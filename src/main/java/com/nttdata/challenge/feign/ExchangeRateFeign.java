package com.nttdata.challenge.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.challenge.dto.ExchangeRateResponseDto;

//@FeignClient(name = "ExchangeRateFeign", url = "https://v6.exchangerate-api.com")

@FeignClient(name = "ExchangeRateFeign", url = "http://demo6878816.mockable.io")
public interface ExchangeRateFeign {
	@GetMapping("{originCurrency}")
//    @GetMapping()
    ExchangeRateResponseDto getLatestExchangeRates(@RequestParam("originCurrency") String originCurrency);
//    ExchangeRateResponseDto getLatestExchangeRates();
}