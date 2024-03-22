package com.example.docker_app.service;

import com.example.docker_app.dao.dto.FibonacciBaseDto;
import com.example.docker_app.dao.entity.Fibonacci;
import com.example.docker_app.dao.repository.FibonacciRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FibonacciService {

    private final FibonacciRepository fibonacciRepository;

    public FibonacciService(FibonacciRepository fibonacciRepository) {
        this.fibonacciRepository = fibonacciRepository;
    }

    public List<FibonacciBaseDto> getBasePageData() {
        return fibonacciRepository.findAll().stream()
                .map(fibonacci -> new FibonacciBaseDto(fibonacci.getIndex())).collect(Collectors.toList());

    }

    public Fibonacci getFibonacciValueByIndex(Long index) {
        if (fibonacciRepository.existsByIndex(index)) {
            return fibonacciRepository.getFibonacciByIndex(index);
        } else {
            Fibonacci newFibonacciValue = new Fibonacci(index, calculateFibonacci(index), LocalDate.now());
            fibonacciRepository.save(newFibonacciValue);
            return newFibonacciValue;
        }
    }

    private Long calculateFibonacci(Long index) {
        if (index == 0) {
            return 0L;
        } else if (index == 1) {
            return 1L;
        } else {
            return calculateFibonacci(index - 1) + calculateFibonacci(index - 2);
        }
    }
}
