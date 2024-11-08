package com.user.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.user.test.dao.UserRepository;
import com.user.test.entity.User;

@SpringBootApplication
public class DatabaseAcessApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DatabaseAcessApplication.class, args);
	
		UserRepository userRepo = context.getBean(UserRepository.class);
		
		User user = new User();
		
		user.setName("Yash");
		user.setCity("Chhapra");
		user.setStatus("Just some info");
		
		User user1 = userRepo.save(user);
		
		System.out.println(user);
		
	}

}
