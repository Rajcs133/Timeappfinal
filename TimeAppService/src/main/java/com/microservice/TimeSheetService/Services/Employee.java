package com.microservice.TimeSheetService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.TimeSheetService.Repositories.TimeSheetRepo;
import com.microservice.TimeSheetService.dto.TimeSheetDto;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@Service(Employee.BEAN_ID)
public class Employee extends AbstractUserActivity {

	public static final String BEAN_ID = "USER";

	@Autowired
	TimeSheetRepo loRepo;

	@Autowired
	ITimeSheet loTimeSheetService;

	@Override
	public TimeSheetDto[] performTimeSheetTask(TimeSheetDto[] TimeSheet, String ModeValue)
			throws CustomBusinessException {
		TimeSheetDto[] loTimeSheetDto = null;

		if (ModeValue.equals(Mode.SUBMIT.toString())) {
			loTimeSheetDto = submitTimeSheetEntry(TimeSheet);
		}

		return loTimeSheetDto;
	}

	public TimeSheetDto[] submitTimeSheetEntry(TimeSheetDto[] loTimeSheet) {
		// TODO Auto-generated method stub
		return null;
	}

}
