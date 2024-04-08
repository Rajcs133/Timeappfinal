package com.microservice.TimeSheetService.Services;

public interface UserFactory {
	
	public AbstractUserActivity getUserObj(String role);

}
