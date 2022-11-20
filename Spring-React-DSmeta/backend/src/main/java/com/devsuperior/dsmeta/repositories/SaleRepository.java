package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

/* será responsável por criar um componente que irá
salvar , deletar e buscar dentro do banco de dados
*/
public interface SaleRepository extends JpaRepository <Sale, Long> {
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
	// determinar a requisição no Postman
	/* EX: http://localhost:8080/sales?minDate=2021-11-01&maxDate=2021-12-31
	 * */
	
	

}
