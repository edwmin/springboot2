package com.jobpost.software;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stock.Exeception.UserNotFoundExeception;

@RestController
public class UserController{
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> retrieveALlUsers() {
		return service.findALl();
	}

//	@GetMapping(path="/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//		return service.findOne(id);
//	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundExeception("id-" + id);
		}
		
		return user;
	}
	
	@GetMapping(path="/usersByLink/{id}")
	public EntityModel<User> retrieveUserByEntityModel(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundExeception("id-" + id);
		}
		
		EntityModel<User> model = EntityModel.of(user);
		
		
		WebMvcLinkBuilder  linkToUsers = 
				linkTo(methodOn(this.getClass()).retrieveALlUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		
		return model;
	}
	
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
	User savedUser =	service.save(user);
	
	// /user/user
	URI location = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(savedUser.getId())
							.toUri();
	
	return ResponseEntity.created(location).build();
	
	}
	

	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.DeleteById(id);
		
		if(user == null) {
			throw new UserNotFoundExeception("id-" + id);
		}

	}
	
	
}
