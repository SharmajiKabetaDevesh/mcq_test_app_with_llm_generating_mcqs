package com.testApp.testApp.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class Answers {


    int questionId;
    int studentAnswerIndex;

    public Answers(){};



    public int getStudentAnswerIndex() {
        return studentAnswerIndex;
    }

    public void setStudentAnswerIndex(int studentAnswerIndex) {
        this.studentAnswerIndex = studentAnswerIndex;
    }





    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
