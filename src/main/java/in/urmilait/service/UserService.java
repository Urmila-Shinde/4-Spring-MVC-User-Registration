package in.urmilait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import in.urmilait.binding.User;
import in.urmilait.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public boolean registerUser(User user)
	{
		userRepo.save(user);
		return user.getUserId()>0;
	}
	
	public boolean checkUser(User user)
	{
		return userRepo.checkUser(user.getUname(),user.getPassword()) >0;
	}
	

}
