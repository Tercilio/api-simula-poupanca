package com.simulador.api.DTO;

import java.io.Serializable;

import com.simulador.api.entities.Usuario;

public class RetornoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ano;
	private Double salario;
	private Double total;

	public RetornoDTO() {
		
	}

	public RetornoDTO(Usuario user, Double total, Integer ano) {
		super();
		this.ano = ano;
		this.salario = user.getSalario();
		this.total = total;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
