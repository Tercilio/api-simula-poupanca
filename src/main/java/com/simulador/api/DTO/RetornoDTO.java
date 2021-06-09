package com.simulador.api.DTO;

import java.io.Serializable;

import com.simulador.api.entities.Usuario;

public class RetornoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer ano;
	private Double salario;
	private Double contX;
	private Double contY;
	private Double total;

	public RetornoDTO() {
		
	}

	public RetornoDTO(Usuario user, Double total, Double contX, Double contY,  Integer ano) {
		super();
		this.ano = ano;
		this.salario = user.getSalario();
		this.contX = user.valorContX(user.getContX());
		this.contY = user.valorContY(user.getContY());
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

	public Double getContX() {
		return contX;
	}

	public void setContX(Double contX) {
		this.contX = contX;
	}

	public Double getContY() {
		return contY;
	}

	public void setContY(Double contY) {
		this.contY = contY;
	}
	
	
	
}
