package com.nttdata.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.challenge.entity.QueryResult;

public interface ChallengeH2Repository extends JpaRepository<QueryResult, Long> {
}
