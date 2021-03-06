package com.senai.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Estado implements Serializable {
	public static final long serialVersionUID = 1L;

	@Column(name="id_estado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_estado")
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	//teste função SOMA junit
	public double somar(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtracao (double num1, double num2) {
		return num1 - num2;
	}
	
	public double divisao (double num1, double num2) {
		return num1 / num2;
	}
	
	public double multiplicacao (double num1, double num2) {
		return num1 * num2;
	}
	
	public Estado() {
}

	public Estado(Integer id, String nome, List<Cidade> cidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidades = cidades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (id.equals(other.id))
			return false;
		return true;
	}
}
