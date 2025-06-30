package com.testApp.testApp.Service;

import com.testApp.testApp.Model.Tests;
import com.testApp.testApp.Repository.TestRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    public void  generateTest(String testName){
        int r_num=generateRandom();
        Optional<Tests> id=testRepo.findById(r_num);
        while(testRepo.findById(r_num).isPresent()){
            r_num=generateRandom();
        }
        testRepo.save(new Tests(r_num,testName));

    }
    public int generateRandom(){
        Random rand=new Random();

        return (int)( 1000+rand.nextInt(9000));
    }

    public boolean verifyTestId(int testId){
        return testRepo.existsById(testId);
    }
}
