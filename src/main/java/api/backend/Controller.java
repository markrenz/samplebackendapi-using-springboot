package api.backend;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.backend.user.UserController;




@RestController
public class Controller {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserPropertiesRepository userPropertiesRepo;
	
	@GetMapping("/users")
    public List<User> index(){
		System.out.println("CHECK:\n" + userRepository.count());
        return userRepository.findAll();
    }


	@PostMapping("/users/search")
    public @ResponseBody User search(@RequestParam(required = true) Integer id){
		System.out.println("----------->" + id);
        return userRepository.findOne(id);
    }
	
	@PostMapping("/users/update")
    public @ResponseBody User Update(@RequestParam(required = true) Map<String, String> body){
		int id = Integer.parseInt(body.get("id"));
		return new UserController(userRepository).updateUser(userRepository.findOne(id), body);
    }
	
	@PostMapping("/users/create")
	public @ResponseBody User create(@RequestParam(required = true) Map<String, String> body){
		User user = new UserController(userRepository).createUser(body);
		new UserPropertiesController(userPropertiesRepo).createPropeties(user.getId(), body);
        return user;
    }

}
