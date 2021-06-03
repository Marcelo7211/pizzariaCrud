package com.generation.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.pizzaria.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	//TODO Implementar alguns metogos de consulta personalizada (Methods Query ou Query Anotations) e chamar no repository
}
