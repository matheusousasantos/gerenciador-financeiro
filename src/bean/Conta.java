package bean;

import java.util.Date;

public class Conta {
	
	private Long id;
	private int quantidadeParcela;
	private int quantidadeParcelaPagas;
	private Date dataVencimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidadeParcela() {
		return quantidadeParcela;
	}
	public void setQuantidadeParcela(int quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}
	public int getQuantidadeParcelaPagas() {
		return quantidadeParcelaPagas;
	}
	public void setQuantidadeParcelaPagas(int quantidadeParcelaPagas) {
		this.quantidadeParcelaPagas = quantidadeParcelaPagas;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	

}
