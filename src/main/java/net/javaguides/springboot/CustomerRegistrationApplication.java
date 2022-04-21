package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}
//    @Autowired
//    private CustomerRepository customerRepository;
//    
//    public void run(String... args) throws Exception
//    {
//        Customer student1 = new Customer("Ramesh","Fadatare","ramesh@gmail.com","0000");
//        customerRepository.save(student1);
//        
//        Customer student2 = new Customer("joel","tuy","tuy@gmail.com","484848");
//        customerRepository.save(student2);
//        
//        Customer student3 = new Customer("esther","poli","polie@gmail.com","488487");
//        customerRepository.save(student3);
//        
//        
//    }

}
