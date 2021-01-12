package com.javatpoint;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.context.ConfigurableApplicationContext;  
import org.springframework.context.annotation.EnableAspectJAutoProxy;  
import com.javatpoint.service.BankService;  
@SpringBootApplication  
//@EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation. It is similar to tag in the xml configuration.  
@EnableAspectJAutoProxy  
public class AopAroundAdviceExampleApplication   
{  
public static void main(String[] args)   
{  
ConfigurableApplicationContext context = SpringApplication.run(AopAroundAdviceExampleApplication.class, args);  
// Fetching the employee object from the application context.  
BankService bank = context.getBean(BankService.class);  
// Displaying balance in the account  
String accnumber = "12345";  
bank.displayBalance(accnumber);  
// Closing the context object  
context.close();  
}  
} 