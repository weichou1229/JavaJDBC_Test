package springJdbcTemplate.dao;

import java.util.List;

import springJdbcTemplate.Product;

public interface ProductDAO {
	public void drop();
	public void create();
	public void insert();
	public List<Product> getAll();
}
