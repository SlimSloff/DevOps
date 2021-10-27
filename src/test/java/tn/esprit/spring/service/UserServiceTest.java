package tn.esprit.spring.service;

//import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	IUserService us;
	@Test
	public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(1, listUsers.size());
	}
	
	@Test
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1995-11-08");
		User u = new User("zakaria" , "Faltani " , d , Role.CHEF_DEPARTEMENT);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
		
	}
	public void testRetrieveUser(){
		l.info("Trying to retrieve id:2 user : ");
		try{
			
		User userRetrieved = us.retrieveUser("2");
		Assertions.assertEquals(2L, userRetrieved.getId());
		}
		catch (Exception e){
			l.error("User 2 doesn't exist");
		}
				
		}
		

}
