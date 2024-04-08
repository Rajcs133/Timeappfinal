package com.microservice.TimeSheetService.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Repositories.TimeSheetRepo;
import com.microservice.TimeSheetService.dto.TimeSheetDto;
import com.microservice.TimeSheetService.dto.TimeSheetMapper;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@Service
public class ITimeSheetImpl implements ITimeSheet{


	@Autowired
	TimeSheetRepo loRepo;
	
	@Autowired
    private TimeSheetMapper timeSheetMapper;
	
	@Override
	public TimeSheetDto saveTimeSheetEntity(TimeSheetDto poTimeSheetDto) {
		TimeSheetEntity poTimeSheetEntity = timeSheetMapper.toEntity(poTimeSheetDto);
		TimeSheetEntity lsTimeSheetEntity =  loRepo.save(poTimeSheetEntity);		
		return timeSheetMapper.toDto(lsTimeSheetEntity);
	}

	@Override
	public TimeSheetDto deleteTimeSheetEntity(TimeSheetDto poTimeSheetEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeSheetDto approveTimeSheetEntity(TimeSheetDto poTimeSheetEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeSheetDto getTimeSheetEntry(int lnId) throws CustomBusinessException {
		
		Optional<TimeSheetEntity> loTimeSheetEntity = loRepo.findById(lnId);
	    (loTimeSheetEntity).orElseThrow(() -> new CustomBusinessException("There is no Entry for the given Id"));
	    return timeSheetMapper.toDto(loTimeSheetEntity.get());
	}

	@Override
	public Page<TimeSheetEntity> getEntriesBasedOnPaginationAndSorting(Integer psId,Integer offset, Integer pagesize,
			String psFieldName) throws CustomBusinessException {
		
		if (pagesize != null && pagesize > 200) {
			throw new CustomBusinessException("PageSize cannot be greater than 200");
		}

		// Apply default pagination if both offset and pagesize are null
		if (offset == null && pagesize == null) {
			// Set default values or handle as per your requirements
			offset = 0; // Default offset
			pagesize = 20; // Default pagesize
		}

		Sort sort;
		if (StringUtils.hasText(psFieldName)) {
			sort = Sort.by(Sort.Direction.ASC, psFieldName);
		} else {
			// Default sorting if field name is not provided
			sort = Sort.unsorted();
		}
		
		PageRequest pageable = PageRequest.of(offset, pagesize, sort);

		Page<TimeSheetEntity> entityPage = loRepo.findById(psId,pageable); 
		
		return entityPage;
		
	}

}
