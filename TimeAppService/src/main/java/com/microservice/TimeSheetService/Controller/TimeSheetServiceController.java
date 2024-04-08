package com.microservice.TimeSheetService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;
import com.microservice.TimeSheetService.Services.TimeSheetService;
import com.microservice.TimeSheetService.dto.TimeSheetDto;
import com.microservice.TimeSheetService.exceptionadvice.CustomBusinessException;

@RestController
@RequestMapping
public class TimeSheetServiceController {

	@Autowired
	TimeSheetService loTimeSheetService;

	@PostMapping(path = "/saveTimeSheetEntry")
	public ResponseEntity<TimeSheetDto> saveTimeSheetEntry(@RequestBody TimeSheetDto poTimeSheet)
			throws CustomBusinessException {
		poTimeSheet = loTimeSheetService.saveTimeSheetEntry(poTimeSheet);
		return new ResponseEntity<>(poTimeSheet, HttpStatus.OK);

	}

	@GetMapping(path = "/getEntry/{Id}")
	public ResponseEntity<TimeSheetDto> getEntryBasedOnTimeSheetId(@PathVariable("Id") int Id) throws Exception {

		TimeSheetDto poTimeSheetDto = loTimeSheetService.getEntryBasedOnTimeSheetId(Id);
		return new ResponseEntity<>(poTimeSheetDto, HttpStatus.OK);
	}

	@PostMapping(path = "/processTimeSheet/{Mode}")
	public ResponseEntity<TimeSheetDto[]> processTimeSheet(@RequestBody TimeSheetDto[] poTimeSheet,
			@PathVariable("Mode") String psMode) throws CustomBusinessException {
		poTimeSheet = loTimeSheetService.performTimeSheetTask(poTimeSheet, psMode);
		return new ResponseEntity<>(poTimeSheet, HttpStatus.OK);

	}

	@GetMapping(path = "/getSortedPaginatedEntries/{Mode}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Page<TimeSheetEntity>> getEntriesBasedOnPaginationAndSorting(
			@RequestParam(name = "offset", required = false) Integer psOffset,
			@RequestParam(name = "pagesize", required = false) Integer psPageSize,
			@RequestParam(name = "fieldName", required = false) String psFieldName,
			@PathVariable("lsUserId") String lsUserId) throws Exception {

		return new ResponseEntity<Page<TimeSheetEntity>>(
				loTimeSheetService.getEntriesBasedOnPaginationAndSorting(psPageSize, psOffset, psPageSize, psFieldName),
				HttpStatus.OK);

	}

}
