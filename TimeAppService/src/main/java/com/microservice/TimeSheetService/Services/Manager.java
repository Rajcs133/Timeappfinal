package com.microservice.TimeSheetService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.TimeSheetService.dto.TimeSheetDto;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@Service(Manager.BEAN_ID)
public class Manager extends AbstractUserActivity {

	public static final String BEAN_ID = "ADMIN";

	@Autowired
	ITimeSheet loTimeSheetService;

	private TimeSheetDto[] approveTimeSheet(TimeSheetDto[] loTimeSheet) {
		return null;
	}

	@Override
	public TimeSheetDto[] performTimeSheetTask(TimeSheetDto[] lsTimeSheet, String lsMode)
			throws CustomBusinessException {
		if (lsMode.equals(Mode.APPROVE.toString())) {
			lsTimeSheet = approveTimeSheet(lsTimeSheet);
			return (TimeSheetDto[]) lsTimeSheet;
		}

		if (lsMode.equals(Mode.REJECT.toString())) {
			TimeSheetDto[] poTimeSheetPaged = rejectTimeSheet(lsTimeSheet);
			return poTimeSheetPaged;
		}
		return lsTimeSheet;
	}

	private TimeSheetDto[] rejectTimeSheet(TimeSheetDto[] lsTimeSheet) {
		// TODO Auto-generated method stub
		return null;
	}

}
