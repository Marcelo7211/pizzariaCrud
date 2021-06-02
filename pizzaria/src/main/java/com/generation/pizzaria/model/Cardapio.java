package com.generation.pizzaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_cardapio")
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Nao pode ser nulo ou vazio")
	@Size(min = 3, max = 30, message = "Tamanho incorreto, minimo 3 e maximo 30")
	private String sabor;

	@Min(0)
	private double preco;

	@NotBlank(message = "Nao pode ser nulo ou vazio")
	@Size(min = 1, max = 1, message = "Tamanho incorreto, minimo e maximo 1")
	private String tamanho;

	private boolean bordaRecheada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
}
