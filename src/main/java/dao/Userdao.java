package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import dto.Userdto;

public class Userdao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public void saveUser(Userdto dto) {
		manager.getTransaction().begin();
		manager.persist(dto);
		manager.getTransaction().commit();
	}

	public Userdto findByEmail(String email) {
		Query query=manager.createQuery("select x from Userdto x where email=?1").setParameter(1, email);
		List<Userdto> list=(query).getResultList();
		if(!list.isEmpty())
			return list.get(0);
		else
			return null;

	}

}
