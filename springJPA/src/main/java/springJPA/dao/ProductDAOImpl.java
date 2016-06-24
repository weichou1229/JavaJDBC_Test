package springJPA.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import springJPA.domain.Product;
@Transactional
public class ProductDAOImpl implements ProductDAO {
	private JdbcTemplate jdbcTemplate; 
	
	private final String DROP_PRODUCT = "DROP TABLE IF EXISTS PRODUCT ; " ;
	private final String CREATE_PRODUCT = 
			"CREATE TABLE IF NOT EXISTS PRODUCT ( " + 
				 "PRODUCT_ID bigint NOT NULL AUTO_INCREMENT," +
				 "NAME varchar(50) NOT NULL," +
				 "PRICE int NOT NULL" +
        	")"; 
	private final String INSERT_PRODUCT1 = "INSERT INTO PRODUCT(NAME,PRICE)VALUES('PRODUCT~A','166')" ;
	private final String INSERT_PRODUCT2 = "INSERT INTO PRODUCT(NAME,PRICE)VALUES('PRODUCT~B','255')" ;
	private final String SELECT_ALL_PRODUCT = "SELECT * FROM PRODUCT" ;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void drop() {
		jdbcTemplate.execute(DROP_PRODUCT);
	}

	@Override
	public void create() {
		jdbcTemplate.execute(CREATE_PRODUCT);
	}
	
	@Override
	public void insert() {
		jdbcTemplate.execute(INSERT_PRODUCT1);
		jdbcTemplate.execute(INSERT_PRODUCT2);
		throw new RuntimeException();
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = jdbcTemplate.query("SELECT * FROM PRODUCT", new BeanPropertyRowMapper(Product.class));
		return products;
	}

}
