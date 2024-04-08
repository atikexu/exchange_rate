package com.nttdata.challenge.dto;

import java.util.List;

import com.nttdata.challenge.entity.QueryResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseQueryDto {
	private Integer size;
	private Integer pages;
    private List<QueryResult> queryList;

}
