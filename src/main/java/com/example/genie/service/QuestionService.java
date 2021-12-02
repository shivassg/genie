package com.example.genie.service;

import com.example.genie.dto.QuestionDto;
import com.example.genie.exception.ApiRequestException;

import java.util.List;

public interface QuestionService {

    public int createQuestion(QuestionDto questionDto);
    public QuestionDto getQuestionById(int questionId);
    public List<QuestionDto> getAllQuestions();
    public void deleteQuestion(int questionId) throws ApiRequestException;


}
