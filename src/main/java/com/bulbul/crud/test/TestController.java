package com.bulbul.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class TestController {


    private  final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    //create
    @PostMapping("/test")
    public ResponseEntity<Test> createTest(@Valid  @RequestBody Test test){
        return testService.save(test);
    }
}
