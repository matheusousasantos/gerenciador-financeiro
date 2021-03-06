package bean;

import java.util.Date;

public class Receita {
	
	private Long id;
	private Date deposito;
	private Double valor;
	private String referencia;
	private String tipo;
	private Long endereco;
	private Long usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDeposito() {
		return deposito;
	}
	public void setDeposito(Date deposito) {
		this.deposito = deposito;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getEndereco() {
		return endereco;
	}
	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
}
