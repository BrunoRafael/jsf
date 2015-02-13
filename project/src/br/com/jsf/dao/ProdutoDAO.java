package br.com.jsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.jsf.pojo.Produto;
import br.com.jsf.util.EntityFactory;

public class ProdutoDAO {
	
	private static ProdutoDAO produtoDAO;
	
	public static ProdutoDAO getInstance(){
		if(produtoDAO == null){
			produtoDAO = new ProdutoDAO();
		}
		return produtoDAO;
	}
	
	public void save(Produto produto){
		EntityManager em = EntityFactory.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

	public List<Produto> getAllProdutos() {
		EntityManager em = EntityFactory.getInstance().createEntityManager();
		CriteriaQuery<Produto> query = em.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));
		
		List<Produto> lista = em.createQuery(query).getResultList();
		em.close();
		
		return lista;
	}
	
	public Produto getProduto(Long id){
		EntityManager em = EntityFactory.getInstance().createEntityManager();
		Produto produto = em.find(Produto.class, id);
		em.close();
		return produto;
		
	}
}
