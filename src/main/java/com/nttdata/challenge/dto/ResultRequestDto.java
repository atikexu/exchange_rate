package com.nttdata.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultRequestDto {
	private Double amount;
    private String originCurrency;
    private String destinationCurrency;
}
