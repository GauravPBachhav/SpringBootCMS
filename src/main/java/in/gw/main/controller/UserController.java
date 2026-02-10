
//16.48



//9.23 continue 5-2-26

package in.gw.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import in.gw.main.entities.Course;
import in.gw.main.entities.User;
import in.gw.main.repositories.UserRepository;
import in.gw.main.services.CourseService;
import in.gw.main.services.UserService;
import jakarta.validation.Valid;





@Controller
@SessionAttributes("sessionUser")
public class UserController {
	
	
	@Autowired
	private UserService userService;

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseService courseService;
	
	//succesfully fetch cources from database lecture timestamp 53.00
	
	
	
	@GetMapping({"/","/index"})
	public String openIndexPage(Model model)
	{
		
		List<Course> coursesList = courseService.getAllCourseDetails();
		model.addAttribute("coursesList", coursesList);

		
		
		return "index";
	}
	
	@GetMapping("/login")
	public String openLoginPage(Model model)
	{
		
		model.addAttribute("user" , new User());
		
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus)
	
	{
		sessionStatus.setComplete();
		
	return "login";	
	}
	
	
	// lecture 6 adding client side and server side validation @Valid tag and BindingResult result with adding dependcies of springframework validation
	
	@PostMapping("/loginform")
	public String handleLoginForm(@Valid @ModelAttribute("user") User user ,BindingResult result, Model model)
{
		
		
		boolean isAuthenticated = userService.loginUserService(user.getEmail(), user.getPassword());
		if(isAuthenticated)
		{
			User authenticatedUser = userRepository.findByEmail(user.getEmail());

			model.addAttribute("sessionUser", authenticatedUser);

			return "user-profile";
		}
		else
		{
			model.addAttribute("errormssg", "Incorrect Email id or Password");
			return "login";
		}
		
		
		
//		if(result.hasErrors())
//		{
//			return "register";
//		}
//		
//		else
//		{
//			
//			boolean isAuthenticated = userService.loginUserService(user.getEmail(), user.getPassword());
//			if(isAuthenticated)
//			{
//				return "user-profile";
//			}
//			else
//			{
//				model.addAttribute("errormssg" , "Email id Or Password Incorrect");
//				return "login";
//			}	
//		}
		
		
	
	}
	
	// register starts
	
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
	public String handlePegForm(@Valid @ModelAttribute("user") User user ,BindingResult result ,  Model model)
	{
	

		if(result.hasErrors())
		{
			return "register";
		}
		else
		{
			try
			{
				userService.registerUserService(user);
				
				model.addAttribute("successmsg", "Registered Successfully");
				return "register";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				model.addAttribute("errormsg", "Registration Failed");
				return "error";
			}
		}
//		boolean status = userService.registerUserService(user);
//		
//		if(status)
//			
//		{
//			model.addAttribute("successmsg" , "Registered Succesfully");
//			return "register";
//
//		}
//
//		else
//		{
//			model.addAttribute("errormsg" , "Register Failed ");
//			return "error";
//
//		}
//		
	}
	
	
	
	@GetMapping("/mycources")
	public String myCourcesPage()
	
	{
		
		
	return "my-cources";	
	}
	
	
	

	@GetMapping("/userProfile")
	public String openUserProfile()
	
	{
		
		
	return "user-profile";	
	}
	
	
	

}
