package com.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfile 
{	
	private int userId;
	private String username;
	private String email;
	private String role;
}
