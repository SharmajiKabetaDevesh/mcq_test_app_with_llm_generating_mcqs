package com.testApp.testApp.Controller;

import com.testApp.testApp.Model.Questions;

import com.testApp.testApp.Service.QuestionService;
import com.testApp.testApp.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Admin {
    @Autowired
     private QuestionService questionService;

    @Autowired
    private TestService testService;


    @GetMapping("/generateId/{testname}")
    public ResponseEntity<?> generateTestId(@PathVariable String testname){
        try{
            testService.generateTest(testname);
            return ResponseEntity.ok("Test Creation Successful");
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage()+"Failed to create an test");
        }
    }

    @PostMapping("/test/{testId}/addquestions")
    public void addQuestions(@PathVariable int testId,@RequestBody List<Questions> questions){

        questionService.addQuestions(testId,questions);
        for(Questions q:questions){
            System.out.println(q.getQuestion());
            System.out.println(q.getCorrectAnswerIndex());

        }

    }

    @GetMapping("/getquestions")
    public ResponseEntity<?> getQuestions(){

     try{
         List<Questions>qs=questionService.getAllQuestions();
           return ResponseEntity.ok(qs);
        }catch(Exception e) {
            return ResponseEntity.status(500).body("Error Occured: "+e.getMessage());
        }
    }

    @PutMapping("/editquestion")
    public ResponseEntity<?> editQuestion(@RequestBody Questions questions){
        try {
            questionService.modifyQuestion(questions);
            return ResponseEntity.ok("Question updated successfully");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage()+"something failed while modifying an question");

        }

    }
    @DeleteMapping("/deletequestion/{qId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable int qId){
        try{
            questionService.deleteQuestion(qId);
            return ResponseEntity.ok("Question deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()+"error while deleting an question");
        }
    }





}

