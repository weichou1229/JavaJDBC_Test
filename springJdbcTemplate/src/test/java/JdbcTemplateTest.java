import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springJdbcTemplate.Product;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'bruce.huang' at '2016/6/17 上午 11:55' with Gradle 2.13
 *
 * @author bruce.huang, @date 2016/6/17 上午 11:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:driverManagerDataSource.xml")
public class JdbcTemplateTest {
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	//==========================PRODUCT==========================
	private final String DROP_PRODUCT = "DROP TABLE IF EXISTS PRODUCT ; " ;
	private final String CREATE_PRODUCT = 
			"CREATE TABLE IF NOT EXISTS PRODUCT ( " + 
				 "PRODUCT_ID bigint NOT NULL AUTO_INCREMENT," +
				 "NAME varchar(50) NOT NULL," +
				 "PRICE int NOT NULL" +
        	")"; 
	private final String INSERT_PRODUCT1 = "INSERT INTO PRODUCT(NAME,PRICE)VALUES('PRODUCT~A','166')" ;
	private final String INSERT_PRODUCT2 = "INSERT INTO PRODUCT(NAME,PRICE)VALUES('PRODUCT~B','255')" ;
	
	@Before
	public void setup(){
		System.out.println("setup...");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
    	jdbcTemplate.execute(DROP_PRODUCT);
    	jdbcTemplate.execute(CREATE_PRODUCT);
    	jdbcTemplate.execute(INSERT_PRODUCT1);
    	jdbcTemplate.execute(INSERT_PRODUCT2);
	}
	
    @Test public void testQueryListMap() {
    	System.out.println("testQueryListMap...");
    	//Act
    	List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT * FROM PRODUCT");
    	//Assert
    	assertTrue("should have two product", products.size()==2);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
	@Test public void testQueryListObject() {
    	System.out.println("testQueryListObject...");
    	//Act
    	List<Product> products = jdbcTemplate.query("SELECT * FROM PRODUCT", new BeanPropertyRowMapper(Product.class));
    	//Assert
    	assertTrue("should have two product", products.size()==2);
    	for(Product product : products){
    		System.out.println(product);
    	}
    }
}
