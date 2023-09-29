package com.attrecto.academy.java.courseapp.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attrecto.academy.java.courseapp.model.dto.CourseDto;
import com.attrecto.academy.java.courseapp.model.dto.CreateCourseDto;
import com.attrecto.academy.java.courseapp.model.dto.UserDto;
import com.attrecto.academy.java.courseapp.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "List all user" ,security = {@SecurityRequirement(name = "token")})
	
	public List<UserDto> getAllUser(){
		return userService.listAllUser();
	}
	
	@GetMapping(value= "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get a user by id" ,security = {@SecurityRequirement(name = "token")})
	public UserDto getUserById(@PathVariable final Integer id) {
		return UserService.getCourseById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Create a new user" ,security = {@SecurityRequirement(name = "token")})
	public UserDto createCourse(@Valid @RequestBody CreateUserDto createUserDto) {
		return UserService.createUser(createUserDto);
	}
	    
    @PutMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update an existing user" ,security = {@SecurityRequirement(name = "token")})
    public UserDto updateUser(@PathVariable final Integer id, @Valid @RequestBody CreateUserDto createUserDto) {
    	return userService.updateCourse(id, createUserDto);
    }    
    
    @DeleteMapping(value= "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete an existing user" ,security = {@SecurityRequirement(name = "token")})
    public void deleteUser(@PathVariable final Integer id) {
    	userService.deleteUser(id);
    }  
	
	
	
}