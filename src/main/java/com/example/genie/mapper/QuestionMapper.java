package com.example.genie.mapper;

import com.example.genie.dto.QuestionDto;
import com.example.genie.model.question.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper INSTANCE  = Mappers.getMapper(QuestionMapper.class);

    QuestionDto converToDto(Question question);
    Question convertDtoToQuestion(QuestionDto questionDto);
}
