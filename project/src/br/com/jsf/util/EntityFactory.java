package br.com.jsf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
	
	private EntityManagerFactory emf;
	private static EntityFactory entityFactory;
	
	private EntityFactory(){
		emf = Persistence.createEntityManagerFactory("notas_fiscais");
	}
	
	public static EntityFactory getInstance(){
		if(entityFactory == null){
			entityFactory = new EntityFactory();
		}
		return entityFactory;
	}

	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	

}
