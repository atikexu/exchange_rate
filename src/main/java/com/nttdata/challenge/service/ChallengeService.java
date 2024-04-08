package com.nttdata.challenge.service;

import com.nttdata.challenge.dto.ResultRequestDto;
import com.nttdata.challenge.dto.ResultResponseDto;
import com.nttdata.challenge.dto.ResultResponseQueryDto;

public interface ChallengeService {

    ResultResponseDto exchangeRate(ResultRequestDto resultRequestDto);
    ResultResponseQueryDto queryList(Integer size, Integer page);

}
