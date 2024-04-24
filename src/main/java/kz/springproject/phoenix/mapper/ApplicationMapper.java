package kz.springproject.phoenix.mapper;

import kz.springproject.phoenix.dto.ApplicationDto;
import kz.springproject.phoenix.model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    ApplicationDto toDto(Application entity);

    Application toEntity(ApplicationDto dto);

    List<ApplicationDto> toDtoList(List<Application> entityList);

    void updateEntity(ApplicationDto dto, @MappingTarget Application entity);

}
