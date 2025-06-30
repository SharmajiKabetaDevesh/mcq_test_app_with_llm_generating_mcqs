package com.testApp.testApp.Repository;

import com.testApp.testApp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Integer> {

    @Query("Select q from Questions q where q.test_Id = :testId")
    List<Questions>getQuestionsByTestId(@Param("testId") int testId);
}
