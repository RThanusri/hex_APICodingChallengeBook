package com.example.demo.Service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.SignupRequest;
import com.example.demo.Entity.User;
import com.example.demo.Enum.UserRole;

	



	@Service
	public class AuthServiceImplementation implements AuthService{
		 @Autowired
		    private UserRepository userRepository;

		   
		    public User createUser(SignupRequest signupRequest) {
		        User user = new User();
		        user.setName(signupRequest.getName());
		        user.setEmail(signupRequest.getEmail());
		        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));

		   
		        if (signupRequest.getUserRole() == null) {
		            user.setUserRole(UserRole.USER); 
		        } else {
		            user.setUserRole(signupRequest.getUserRole());
		        }

		        User createdUser = userRepository.save(user);

		  
		        User userDto = new User();
		        userDto.setId(createdUser.getId());
		        userDto.setName(createdUser.getName());
		        userDto.setEmail(createdUser.getEmail());
		        userDto.setUserRole(createdUser.getUserRole());

		        return userDto;
		    }

		    
		    public boolean hasCustomerWithEmail(String email) {
		        return userRepository.findFirstByEmail(email).isPresent();
		    }
	}


