package in.urmilait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.urmilait.binding.User;
import in.urmilait.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String loadForm(Model model)
	{
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/register")
	public String handleSubmitBtn(User user, Model model)
	{

		boolean saveuser = userService.registerUser(user);
		if(saveuser)
		{
			model.addAttribute("msg", "User registered successfully");
		}
		return "index";
	}

	//to view login form
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/forgotpwd")
	public String forgotPassword()
	{	
		return "forgotpwd";
	}

	@PostMapping("/checkUser")
	public String checkUser(User user,Model model)
	{
		boolean checkuser = userService.checkUser(user);
		if(checkuser)
		{
			model.addAttribute("msg", "Login Successfully");
			return "login";
		}
		else
		{
			model.addAttribute("msg", "User Not Found");
			return "login";
		}

	}
}