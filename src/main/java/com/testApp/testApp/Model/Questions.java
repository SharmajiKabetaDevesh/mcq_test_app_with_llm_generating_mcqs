package com.testApp.testApp.Model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Questions {
    public Questions(String question,List<String>options,int correctAnswerIndex){
        this.question=question;
        this.options=options;
        this.correctAnswerIndex=correctAnswerIndex;
    }
    public Questions(){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int questionId;
    int correctAnswerIndex;
    String question;
    @ElementCollection
    List<String> options=new ArrayList<>();

    public int getTest_Id() {
        return test_Id;
    }

    public void setTest_Id(int test_Id) {
        this.test_Id = test_Id;
    }

    public int test_Id;




    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
