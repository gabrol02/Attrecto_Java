package com.attrecto.academy.java.courseapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attrecto.academy.java.courseapp.model.dto.LoginDto;
import com.attrecto.academy.java.courseapp.model.dto.TokenDto;
import com.attrecto.academy.java.courseapp.model.dto.UserDto;
import com.attrecto.academy.java.courseapp.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
@Tag(name = "Account API")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
    @PostMapping(value= "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Give back information about the logged user")
	public UserDto me() {
		return accountService.getLoggedUser();
	}
	
    @PostMapping(value= "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a login token")
	public TokenDto login(@RequestBody @Valid LoginDto loginDto) {
		return accountService.generateJwtToken(loginDto);
	}
}
