package com.bulbul.crud.test;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public ResponseEntity<Test> save(Test test) {
        return ResponseEntity.ok(testRepository.save(test));
    }
}
