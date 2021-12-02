package com.example.genie.controller;

import com.example.genie.dto.QuestionDto;
import com.example.genie.exception.ApiRequestException;
import com.example.genie.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @PostMapping
    public ResponseEntity<Integer> createQuestion(@RequestBody QuestionDto question, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int questionId = questionService.createQuestion(question);
        return new ResponseEntity<>(questionId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable("id") int questionId){
        QuestionDto questionDTO =  questionService.getQuestionById(questionId);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        List<QuestionDto> questionDTOS = questionService.getAllQuestions();
        return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable("id") int quetionId,  HttpServletRequest request) throws ApiRequestException {
        questionService.deleteQuestion(quetionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
