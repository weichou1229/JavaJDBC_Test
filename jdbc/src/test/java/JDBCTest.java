import org.junit.Test;
import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'bruce.huang' at '2016/6/17 上午 11:55' with Gradle 2.13
 *
 * @author bruce.huang, @date 2016/6/17 上午 11:55
 */
public class JDBCTest {
    @Test public void testConnectDB() {
    	EazyDAO eazyDAO = null ;
    	try {
			//Act
			eazyDAO = new EazyDAO();
			//Assert
			assertTrue("conn should not null", eazyDAO.conn!=null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(eazyDAO.conn !=null && !eazyDAO.conn.isClosed())eazyDAO.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}