package com.example.genie.service;

import com.example.genie.dto.QuestionDto;
import com.example.genie.exception.ApiRequestException;
import com.example.genie.mapper.QuestionMapper;
import com.example.genie.model.question.Question;
import com.example.genie.repo.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int createQuestion(QuestionDto questionDTO) {
        Question question = createQuestionEntity(questionDTO);
        return questionRepository.save(question).getQuestionId();
    }

    @Override
    public QuestionDto getQuestionById(int questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ApiRequestException("Question ID not found"));
        return convertToDTO(question);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questionsList = questionRepository.findAll();
        return questionsList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Question createQuestionEntity (QuestionDto questionDto){
       return modelMapper.map(questionDto, Question.class);
    }

    private QuestionDto convertToDTO(Question question){
        return modelMapper.map(question, QuestionDto.class);
    }


    @Override
    public void deleteQuestion(int questionId) throws  ApiRequestException{
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ApiRequestException("Question ID not found"));
        questionRepository.deleteById(questionId);
    }

}
