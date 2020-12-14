package com.vr;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.vr.entities.Cart;
//import com.vr.entities.Customer;
//import com.vr.repositories.CartRepository;
//import com.vr.repositories.CustomerRepository;

@SpringBootApplication
public class CustomersApplication{
//	public class CustomersApplication implements CommandLineRunner{
	
//	@Autowired
//	private CustomerRepository custRepo;
//
//    @Autowired
//    private CartRepository cartRepo;
	    
	public static void main(String[] args)  {
		SpringApplication.run(CustomersApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Customer customer = new Customer("Pim", "Natcha", "pimnat@me.com",
//                "Khao Tao Road", "Bandung" , "Indonesia", "12345");
//		Cart cart = new Cart("Iphone 11" , 11000000);
//		customer.setCart(cart);
//		cart.setCustomer(customer);
//		custRepo.save(customer);
//	}

}
