package com.tbp.crud.service;

import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> updateUser(Long id, User updatedUser) {
		return userRepository.findById(id)
				.map(user -> {
					user.setFirstName(updatedUser.getFirstName());
					user.setLastName(updatedUser.getLastName());
					user.setUsername(updatedUser.getUsername());
					user.setPassword(updatedUser.getPassword());
					return userRepository.save(user);
				});
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}


