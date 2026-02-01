package in.gw.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gw.main.entities.User;
import in.gw.main.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public boolean registerUserService(User user)
	{
		try {
		userRepository.save(user);
		return true;
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
}
