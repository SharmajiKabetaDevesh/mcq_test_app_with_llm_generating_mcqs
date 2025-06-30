package com.testApp.testApp.Repository;

import com.testApp.testApp.Model.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Tests,Integer> {
}
