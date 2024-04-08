package com.nttdata.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResultResponseDto {
	private Double amount;
    private Double amountExchangeRate;
    private String originCurrency;
    private String destinationCurrency;
    private Double exchangeRate;

}
