package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

/**
  É o componente responsável pela regra de negócio(no caso as vendas)
 */

 @Service
public class SaleService {
	@Autowired
	private SaleRepository repository; // chamando a interface SaleRepository
	
	public Page<Sale> findSales(String minDate,String maxDate,Pageable pageable){
		
		// serve para pegar a hora instante do sistema atual
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		
		// Caso a data minima não seja informada(""),eu quero data de uma ano atrás
		// que é today.minusDays(365)
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		
		
		// se minha data máxima for vazia(""), eu coloco a minha data atual (que é o today)
		// e se não for eu converto para a data do LocalDate
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
	 return	repository.findSales(min, max, pageable); // busca todas as vendas, com um minimo e máximo
	}

}
