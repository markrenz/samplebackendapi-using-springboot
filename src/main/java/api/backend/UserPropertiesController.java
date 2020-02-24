package api.backend;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class UserPropertiesController {
	@Autowired
	UserPropertiesRepository userPropertiesRepo;
	
	public UserPropertiesController(UserPropertiesRepository userPropertiesRepo) {
		this.userPropertiesRepo = userPropertiesRepo;
	}
	
	public UserProperties createPropeties(int userId, Map<String, String> body) {
		return userPropertiesRepo.save(new UserProperties(userId,
				body.get("firstName"), body.get("lastName"), body.get("telephone")));
	}
}
