//16.48



package in.gw.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.gw.main.entities.User;
import in.gw.main.services.UserService;



@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	
	
	@GetMapping({"/","/index"})
	public String openIndexPage()
	{
		
		
		return "index";
	}
	
	@GetMapping("/login")
	public String openLoginPage()
	{
		
		
		return "login";
		
	}
	
	
	//Link
	@GetMapping("/register")
	public String openRegisterPage(Model model)
	
	{
		// this means that when we open the register page then it
		//will take new User() object along with model-view for register page
	
		model.addAttribute("user", new User());
		//view name
		return "register";
		
	}
	
	
	@PostMapping("/regform")
	public String handlePegForm(@ModelAttribute("user") User user , Model model)
	{
		
		boolean status = userService.registerUserService(user);
		
		if(status)
			
		{
			model.addAttribute("successmsg" , "Registered Succesfully");
			return "register";

		}

		else
		{
			model.addAttribute("errormsg" , "Register Failed ");
			return "error";

		}
		
	}
	
	

}
