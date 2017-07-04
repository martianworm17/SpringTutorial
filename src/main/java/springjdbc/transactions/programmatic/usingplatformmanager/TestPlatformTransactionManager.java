package springjdbc.transactions.programmatic.usingplatformmanager;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial11.springjdbc.IUserDao;
import tutorial11.springjdbc.User;
/**
 * 
 * @author Apurav
 *
 */

public class TestPlatformTransactionManager {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springjdbc/transactions/programmatic/usingplatformmanager/platformTxManager.xml");
		IUserDao dao = applicationContext.getBean("userDao", IUserDao.class);
		User user=new User("apurav"+generateId(), "passowrd", "F", generateId());
		dao.insertUser(user);
		dao.deleteUser(2);
		
		/*throws a checked Exception that is not automatically rolled back.Contrary to this is the RuntimeException
		which are automatically rolled back. See next try catch block. We can controll the default roll back behaviour by setting properties in xml
		SEE txAdviceWithRollBackSettings bean and txAdvice bean definations*/
		try{
			dao.updateUser(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			/*throws a runtime exception which will be automatically rolled back
			 * We can controll the default roll back behaviour by setting properties in xml. 
			 * SEE txAdviceWithRollBackSettings bean  and txAdvice bean definations*/
			dao.selectUser(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		applicationContext.close();
	}
	private static int generateId(){
		return new Random().nextInt(500);
	}
}
