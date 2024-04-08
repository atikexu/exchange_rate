package com.nttdata.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	@JsonIgnore
	private String user;
	@JsonIgnore
	private String pass;
	private String token;
}
