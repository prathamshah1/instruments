package com.investapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investapp.entity.User;
import com.investapp.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	// creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		
		return this.userService.createUser(user);

	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) throws Exception {

		return this.userService.getUser(username);
	}

	// delete user by userId
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) throws Exception {
		this.userService.deleteUser(userId);

	}

	// update user by username
	@PostMapping("/{username}")
	public User updateUser(@PathVariable("username") String username, @RequestBody User user) throws Exception {
		return this.userService.updateUser(username, user);
	}

	@GetMapping("/getUsers")
	public List getAllUser() throws Exception {
		return this.userService.getAllUserNames();
	}

}
