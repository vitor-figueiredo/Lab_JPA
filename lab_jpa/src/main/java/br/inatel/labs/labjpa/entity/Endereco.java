package br.inatel.labs.labjpa.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Endereco {
	
	@Id
	private String codigo;

	
	@PrePersist
	private void preencherCodigo() {
		this.codigo = UUID.randomUUID().toString();
	}
	
	//...
	
	@NotNull
	private String rua;
	
	@NotNull
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	@NotNull
	private String cidade;
	
	@NotNull
	@Size(max = 2)
	private String uf;

	
	
	
	
	
	//acessores...
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	

	
}
