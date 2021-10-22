package br.com.youngdevs.alemdopoteapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;



@Entity
public class Pote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O nome do pote deve ser informado!")
	private String nome;

	@Min(value = 10, message = "O numero de porcetagem do alerta deve ser no minimo 10!")
	@Max(value = 80, message = "O numero de porcetagem do alerta deve ser no máximo 80!")
	private int numPorcentagemAlerta;

	@Min(value = 1, message = "O numero de consumidores deve ser no minimo 1!")
	@Max(value = 4, message = "O numero de consumidores deve ser no máximo 4!")
	private int numConsumidores;
	
	@NotBlank(message = "O conteudo deve ser informado!")
	private String conteudo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPorcentagemAlerta() {
		return numPorcentagemAlerta;
	}

	public void setNumPorcentagemAlerta(int numPorcentagemAlerta) {
		this.numPorcentagemAlerta = numPorcentagemAlerta;
	}

	public int getNumConsumidores() {
		return numConsumidores;
	}

	public void setNumConsumidores(int numConsumidores) {
		this.numConsumidores = numConsumidores;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	
	
}
