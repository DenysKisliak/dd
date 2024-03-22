package com.example.docker_app.dao.repository;

import com.example.docker_app.dao.dto.FibonacciBaseDto;
import com.example.docker_app.dao.entity.Fibonacci;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FibonacciRepository extends JpaRepository<Fibonacci, Long> {

    boolean existsByIndex(Long index);

    Fibonacci getFibonacciByIndex(Long index);
}
