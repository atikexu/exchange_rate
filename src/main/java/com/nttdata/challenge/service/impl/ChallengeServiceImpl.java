package com.nttdata.challenge.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.nttdata.challenge.dto.ExchangeRateResponseDto;
import com.nttdata.challenge.dto.ResultRequestDto;
import com.nttdata.challenge.dto.ResultResponseDto;
import com.nttdata.challenge.dto.ResultResponseQueryDto;
import com.nttdata.challenge.entity.QueryResult;
import com.nttdata.challenge.feign.ExchangeRateFeign;
import com.nttdata.challenge.repository.ChallengeH2Repository;
import com.nttdata.challenge.service.ChallengeService;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class ChallengeServiceImpl implements ChallengeService{
	
	@Autowired
    private ExchangeRateFeign exchangeRateFeign;
	
	@Autowired
    private ChallengeH2Repository challengeH2Repository;

    @Override
    public ResultResponseDto exchangeRate(ResultRequestDto resultRequestDto) {
    	log.info("log de exchangeRate");
    	ResultResponseDto response = new ResultResponseDto();
    	try {
    		ExchangeRateResponseDto exchangeRateResponseDto =  exchangeRateFeign.getLatestExchangeRates(resultRequestDto.getOriginCurrency());
    		Double amount = resultRequestDto.getAmount();
    		String originCurrency = resultRequestDto.getOriginCurrency();
    		String destinationCurrency = resultRequestDto.getDestinationCurrency();
    		if(exchangeRateResponseDto.getResult().equals("success")) {
    			Map<String, Double> conversionRates = exchangeRateResponseDto.getConversionRates();
        		Double exchangeRate = conversionRates.get(destinationCurrency);
        		
        		Double amountExchangeRate = amount*exchangeRate;
        		response = new ResultResponseDto(amount, amountExchangeRate, originCurrency, destinationCurrency, exchangeRate);
        		QueryResult queryResult = new QueryResult(null,LocalDateTime.now(), amount, amountExchangeRate, originCurrency, destinationCurrency, exchangeRate);
        		
                challengeH2Repository.save(queryResult);
        		return response;
    		} 
    	} catch (FeignException  e) {
    		log.error("Error de Feign " + e.getMessage());
    	} catch (HttpServerErrorException e) {
    		log.error("Error de servidor remoto: " + e.getRawStatusCode());
        } catch (Exception e) {
        	log.error("Error desconocido: " + e.getMessage());
        }
        return response;
    }

	@Override
	public ResultResponseQueryDto queryList(Integer size, Integer page) {
		List<QueryResult> listQuery =  challengeH2Repository.findAll();
		Integer size1 = listQuery.size();
		Integer pages = (int) Math.ceil((double) size1 / page);
		listQuery = listQuery.stream()
				.skip((size - 1) * page)
				.limit(page)
				.toList();
		return new ResultResponseQueryDto(size1, pages, listQuery);
	} 
}
