package com.testApp.testApp.Service;

import com.testApp.testApp.Model.Questions;
import com.testApp.testApp.Repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepo questionsRepo;

    public void addQuestions(int testId,List<Questions> questions){
        try{
             for(Questions q:questions){
                 q.test_Id=testId;
             }
            questionsRepo.saveAll(questions);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error at saving all questions");
        }

    }
    public List<Questions>getAllQuestions(){
        return questionsRepo.findAll();
    }
    public void modifyQuestion(Questions questions){
        Questions que= questionsRepo.findById(questions.getQuestionId()).get();
        que.setQuestion(questions.getQuestion());
        que.setOptions(questions.getOptions());
        que.setCorrectAnswerIndex(questions.getCorrectAnswerIndex());
        questionsRepo.save(que);

    }
    public void deleteQuestion(int qId){
        questionsRepo.deleteById(qId);
    }

    public List<Questions> getQuestionsByTestId(int testId) {
        return questionsRepo.getQuestionsByTestId(testId);
    }
}
