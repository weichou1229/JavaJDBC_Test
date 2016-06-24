package springJPA.dao;

import java.util.List;

import springJPA.domain.Product;

public interface ProductDAO {
	public void drop();
	public void create();
	public void insert();
	public List<Product> getAll();
}
