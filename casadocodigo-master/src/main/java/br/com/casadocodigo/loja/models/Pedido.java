package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)	//Totas as variáveis que não são definidas na classe serão ignoradas
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")	//Anotação que liga os valores às variáveis   
    private int id;

    @JsonProperty("valor")   
    private BigDecimal valor;

    @JsonProperty("data")   
    @DateTimeFormat
    private Calendar data;

    @JsonProperty("produtos")   
    private List<Produto> produtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
