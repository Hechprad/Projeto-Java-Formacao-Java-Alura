package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Relatorio {

	private Long quantidade;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@DateTimeFormat
	private Calendar dataDeGeracao;

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Calendar getDataDeGeracao() {
		return dataDeGeracao;
	}

	public void setDataDeGeracao(Calendar dataDeGeracao) {
		this.dataDeGeracao = dataDeGeracao;
	}
}
