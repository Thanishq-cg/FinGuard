package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.EmailRequest;
import com.main.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	NotificationService notificationservice;

	// Endpoint to send account creation email
	@PostMapping("/sendEmail")
	public ResponseEntity<Void> sendEmail(@RequestBody EmailRequest emailRequest) 
	{
		// Call the service method to send the email
		notificationservice.sendEmail(emailRequest);
		return new ResponseEntity<>(HttpStatus.OK); // Return success status
	}
}
