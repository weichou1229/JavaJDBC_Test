package springJPA.domain;
/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'bruce.huang' at '2016/6/17 上午 11:55' with Gradle 2.13
 *
 * @author bruce.huang, @date 2016/6/17 上午 11:55
 */
public class Product {
	private String productId;
	private String name;
	private int price;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
}