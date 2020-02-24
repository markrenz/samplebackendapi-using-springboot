package api.backend.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import api.backend.User;
import api.backend.UserRepository;

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User updateUser(User user, Map<String, String> body) {
		user.setUsername(body.get("username"));
		user.setPassword(body.get("password"));
		userRepository.save(user);
		return user;
	}
	
	public User createUser(Map<String, String> body){
		String username = body.get("username");
		String password = body.get("password");
		String email = body.get("email");
		return userRepository.save(new User(username, password, email));
	}
	
}
