package com.ibrahim.platform.mappers;


import com.ibrahim.platform.domain.dtos.PhotoDto;
import com.ibrahim.platform.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {

    PhotoDto toDto(Photo photo);
    Photo toEntity(PhotoDto photoDto);
}
