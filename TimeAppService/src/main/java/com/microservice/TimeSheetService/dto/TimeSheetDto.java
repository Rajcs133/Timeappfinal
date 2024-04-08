package com.microservice.TimeSheetService.dto;

import java.sql.Date;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TimeSheetDto {
    
    private Integer id;
    private Integer userId; // Assuming this is the ID of the user
    private Date entryDate;
    private String inputChannel;
    private String description;
    private HashMap<String, Object> optionalData; // Optional HashMap variable
    
    // Constructor without optionalData
    public TimeSheetDto(Integer id, Integer userId, Date entryDate, String inputChannel, String description) {
        this.id = id;
        this.userId = userId;
        this.entryDate = entryDate;
        this.inputChannel = inputChannel;
        this.description = description;
    }
}
