package tutorial2.settingbeanproperties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account.
 * 
 * With Spring IOC we'll not need to change anything in code. Instead we'll update 
 * beans.xml with new set bean property like below.
 * 
 * <property name="accountNo" value="12345"></property>
 */
public class CustomerWithIOC {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial2/settingbeanproperties/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		System.out.println(bank);
		System.out.println("Account number is: "+ bank.getAccountNo());
		
		context.close();
	}
}