package springJdbcTemplate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springJdbcTemplate.dao.ProductDAO;

public class MyApp {

	public static void main(String[] args) {
		List<Product> products = null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("driverManagerDataSource.xml");
        ProductDAO productDAO = (ProductDAO) ctx.getBean("productDAO");
        productDAO.drop();
        productDAO.create();
        products = productDAO.getAll();
        for(Product product : products) System.out.println(product);
        productDAO.insert();


	}

}
