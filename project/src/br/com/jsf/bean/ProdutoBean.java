package br.com.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.jsf.dao.ProdutoDAO;
import br.com.jsf.pojo.Produto;

@RequestScoped
@ManagedBean
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	private List<Produto> savedProducts;
	
	public Produto getProduto(){
		return produto;
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			produtos = ProdutoDAO.getInstance().getAllProdutos();
		}
		return produtos;
	}
	
	public void save(){
		ProdutoDAO.getInstance().save(getProduto());
		produto = new Produto();
	}
	
	public List<Produto> getSavedProducts(){
		return savedProducts;
	}
	
	

}
