package com.tbp.crud.controller;

import com.tbp.crud.entity.User;
import com.tbp.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller to perform CRUD operations for User
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private  UserService userService;

	/**
	 * Method for getting list of users
	 * @return List
	 */
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/**
	 * Methdd to get the user details by Id
	 * @param id
	 * @return User
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id)
				.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Method to create user
	 * @param user
	 * @return User
	 */
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	/**
	 * Method to update the user
	 * @param id
	 * @param updatedUser
	 * @return User
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		return userService.updateUser(id, updatedUser)
				.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Method to delete the user
	 * @param id
	 * @return Http Status
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
