package com.microservice.TimeSheetService.Services;

import org.springframework.data.domain.Page;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.dto.TimeSheetDto;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

public interface ITimeSheet {
	
	public TimeSheetDto saveTimeSheetEntity(TimeSheetDto poTimeSheetEntity);
	
	public TimeSheetDto deleteTimeSheetEntity(TimeSheetDto poTimeSheetEntity);
	
	public TimeSheetDto approveTimeSheetEntity(TimeSheetDto poTimeSheetEntity);
	
	public TimeSheetDto getTimeSheetEntry(int lnUserId) throws CustomBusinessException;
	
	public Page<TimeSheetEntity> getEntriesBasedOnPaginationAndSorting(Integer psUserId,Integer psOffset,Integer psPageSize,String psFieldName) throws CustomBusinessException;
	
}
