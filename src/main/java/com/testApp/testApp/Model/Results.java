package com.testApp.testApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultId;
    private String studentId;
    private int score;
    private int testId;

    public Results(){};

    public Results(String studentId,int testId,int score){
        setStudentId(studentId);
        setTestId(testId);
        setScore(score);
    };


    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
