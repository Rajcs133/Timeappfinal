package com.microservice.TimeSheetService.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservice.TimeSheetService.Entity.TimeSheetEntity;

@Mapper
public interface TimeSheetMapper {
    TimeSheetMapper INSTANCE = Mappers.getMapper(TimeSheetMapper.class);
    
    TimeSheetDto toDto(TimeSheetEntity entity);
    
    TimeSheetEntity toEntity(TimeSheetDto dto);
}