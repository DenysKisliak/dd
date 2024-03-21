package com.example.second_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("second")
public class MockDataController {

    @GetMapping()
    public FibonacciBaseDto getData(){
        return new FibonacciBaseDto(221L);
    }

}
