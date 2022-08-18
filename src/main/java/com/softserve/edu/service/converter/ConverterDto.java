package com.softserve.edu.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class ConverterDto {

    private final ModelMapper modelMapper;

    @Autowired
    public ConverterDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

//    public BookDto convertToDto(BookEntity entity) {
//        return modelMapper.map(entity, BookDto.class);
//    }

    public <T, D> T convertToDto(D entity, Type dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <T, D> D convertToEntity(T dto, D entity) {
        return modelMapper.map(dto, (Type) entity.getClass());
    }

}
