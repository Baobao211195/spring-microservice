package com.webservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.entity.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	
	@Query("Select c from CurrencyExchange c where c.from = :from and c.to = :to ")
	Optional<CurrencyExchange> findByFromAndTo(@Param("from") String from, @Param("to") String to);

}
