package com.testApp.testApp.Controller;

import com.testApp.testApp.Model.Answers;
import com.testApp.testApp.Model.Questions;
import com.testApp.testApp.Service.QuestionService;
import com.testApp.testApp.Service.StudentService;
import com.testApp.testApp.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/exam")
public class Student {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestService testService;

     @Autowired
     private StudentService studentService;

    @GetMapping("/testId/{testId}/questions")
    public ResponseEntity<?> getQuestions(@PathVariable int testId){
        try {
           return ResponseEntity.ok(studentService.checkTestId(testId));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()+"something failed while fetching questions");
        }

    }

    @PostMapping("/test/{testId}/submitted/{studentId}")
    public ResponseEntity<?> generateScore(@PathVariable int testId,@PathVariable String studentId,@RequestBody List<Answers> answers){
        try{
            int score=studentService.generateScore(testId,studentId,answers);
            return ResponseEntity.ok(score);
        }catch (Exception e){
           return ResponseEntity.status(500).body("Score generation failed"+e.getMessage());
        }



    }
}
