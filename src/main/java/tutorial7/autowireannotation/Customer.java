package tutorial7.autowireannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial7/autowireannotation/beans.xml");
		
		Bank bank = context.getBean("hdfc", Bank.class);
		System.out.println(bank.showStatus());
		
		context.close();
	}
}