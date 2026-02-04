package in.gw.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gw.main.entities.User;
import in.gw.main.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public void registerUserService(User user)
	{
		
		userRepository.save(user);
		
	}
	
	public boolean loginUserService(String email, String password)
	{
	
		User user = userRepository.findByEmail(email);
		if(user != null)
		{
			return password.equals(user.getPassword());  // if user is not null it means it contains some information and so if its passwords is equal to user.getpassword from database then it return true;
			
		}
		else
		{
			return false;
		}
		

	}
	
}
