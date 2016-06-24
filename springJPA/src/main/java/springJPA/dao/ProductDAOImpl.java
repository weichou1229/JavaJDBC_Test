package springJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.transaction.annotation.Transactional;

import springJPA.domain.Product;

public class ProductDAOImpl implements ProductDAO {
	private EntityManagerFactory emf; 
		
	public void setEmf(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void drop() {
	}

	@Override
	public void create() {

	}
	
	@Override 
	@Transactional
	public void insert() {
		EntityManager em = this.emf.createEntityManager();
		em.persist(new Product("test_productA", 123));
		em.flush();
		em.close();
	}

	@Override
	public List<Product> getAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Product> products = em.createQuery(" FROM Product").getResultList();
		System.out.println("products size : " +products.size());
		em.flush();
		em.close();
		return products;
	}

}
