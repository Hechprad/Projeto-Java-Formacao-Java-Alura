package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Relatorio {

	@DateTimeFormat
	private Calendar dataGeracao;

	private int quantidade;
	private List<Produto> produtos = new ArrayList<Produto>();
	

	public Calendar getDataGeracao() {
		return dataGeracao;
	}
	
	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade() {
		this.quantidade = produtos.size();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
