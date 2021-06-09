package com.simulador.api.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.simulador.api.DTO.RetornoDTO;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double salario;
	private Double reajusteAnual;
	private Double contX;
	private Double contY;
	private Integer anos;

	public Usuario() {

	}

	public Usuario(Long id, String nome, Double salario, Double reajusteAnual, Double contX, Double contY,
			Integer anos) {

		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.reajusteAnual = reajusteAnual;
		this.contX = contX;
		this.contY = contY;
		this.anos = anos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getReajusteAnual() {
		return reajusteAnual;
	}

	public void setReajusteAnual(Double reajusteAnual) {
		this.reajusteAnual = reajusteAnual;
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

	public Integer getAnos() {
		return anos;
	}

	public void setAnos(Integer anos) {
		this.anos = anos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double valorContX(Double percent) {
		return (percent / 100) * salario;
	}

	public Double valorContY(Double percent) {

		Double contribuicaoFinal = 0.0;

		if (salario > 2500.00) {

			Double excedente = salario - 2500.00;
			contribuicaoFinal = (percent / 100) * excedente;

		} 
		
		return contribuicaoFinal;
	}



	public Double contMensal() {
		Double total = valorContX(contX) + valorContY(contY);
		return total;
	}

	public List<RetornoDTO> valorTotalCont(Usuario user) {

		Locale ptBr = new Locale("pt", "BR");
		Double montante = 0.0;
		List<RetornoDTO> valores = new ArrayList<>();

		for (int i = 1; i <= anos; i++) {
			Double valorAno = 12 * contMensal();

			montante += valorAno;
			RetornoDTO newRetorno = new RetornoDTO(user,  montante, user.valorContX(contX) , user.valorContY(contY), i);
			salario += (salario * (reajusteAnual / 100));
			valores.add((newRetorno));

			System.out.println(i + "° " + "Ano" + "= " + NumberFormat.getCurrencyInstance(ptBr).format(montante));

		}

		return valores;
	}

}
