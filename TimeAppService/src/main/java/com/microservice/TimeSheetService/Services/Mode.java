package com.microservice.TimeSheetService.Services;

public enum Mode {
	INSERT, DELETE, APPROVE, RETRIEVE,SUBMIT, REJECT;

	@Override
	public String toString() {
		return name();
	}

}
