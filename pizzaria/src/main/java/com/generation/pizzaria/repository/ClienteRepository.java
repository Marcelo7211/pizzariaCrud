package com.generation.pizzaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.pizzaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	/**
	 * Através do MethodQuery podes criar metodos abstrados ("sem corpo") para fazer
	 * nossas consutas
	 * 
	 * Atente-se ao retorno do metodo Ex List<Cliente>
	 * 
	 * Mais informações
	 * 
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	 * 
	 */
		public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);

	/**
	 * Através do query Anotations podemos executar quelquer query nativa do banco
	 * de dados Sempre quando precisar passar um parametro para a query ex: idade
	 * usar o @Param("idade")
	 * 
	 * Mais informações
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
	 * 
	 */
	@Query(value = "select * from tb_cliente where idade > :idade", nativeQuery = true)
	public List<Cliente> pegarPorIdadeMaiorQue(@Param("idade") int idade);
}
