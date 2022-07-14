package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class NotaCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "notaCompra")
	private List<NotaCompraItem> listaNotaCompraItem;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@NotNull
	@Past
	private LocalDate dataEmissao;
	
	
	//construtores...
	
	public NotaCompra() {}
	
	public NotaCompra(LocalDate dataEmissao, Fornecedor fornecedor) {
		super();
		this.dataEmissao = dataEmissao;
		this.fornecedor = fornecedor;
	}


	
	//util...

	public BigDecimal getCalculoTotalNota() {
		BigDecimal total = this.listaNotaCompraItem.stream()
			.map( i -> i.getCalculoTotalItem() )
			.reduce( BigDecimal.ZERO, BigDecimal::add );
		
		return total;
	}

	
	
	//acessores...

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<NotaCompraItem> getListaNotaCompraItem() {
		return listaNotaCompraItem;
	}


	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		this.listaNotaCompraItem = listaNotaCompraItem;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public LocalDate getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}
