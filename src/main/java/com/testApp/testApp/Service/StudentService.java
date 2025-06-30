package com.testApp.testApp.Service;

import com.testApp.testApp.Model.Answers;
import com.testApp.testApp.Model.Questions;
import com.testApp.testApp.Model.Results;
import com.testApp.testApp.Repository.QuestionsRepo;
import com.testApp.testApp.Repository.ResultsRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionsRepo questionsRepo;

    @Autowired
    private ResultsRepo resultsRepo;

    public List<Questions> checkTestId(int testId){
        if(testService.verifyTestId(testId)){
           return questionService.getQuestionsByTestId(testId);
        }else{
            return null;
        }
    }

    public int generateScore(int testId,String studentId,List<Answers>answers){

        int correct=0;
        int incorrect=0;
        for(Answers a:answers){
            Optional<Questions> q=questionsRepo.findById(a.getQuestionId());
            if( q.isPresent() &&  a.getStudentAnswerIndex()==q.get().getCorrectAnswerIndex()){
                correct++;
            }
        }
        addScore(testId,studentId,correct);
        return correct;
    }

    public void addScore(int testId,String studentId,int score){
        resultsRepo.save(new Results(studentId,testId,score));

    }


}
