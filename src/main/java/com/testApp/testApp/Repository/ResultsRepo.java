package com.testApp.testApp.Repository;

import com.testApp.testApp.Model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends JpaRepository<Results,Integer> {
}
