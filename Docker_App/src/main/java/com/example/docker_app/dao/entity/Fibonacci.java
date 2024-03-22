package com.example.docker_app.dao.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fibonacci_calculation")
public class Fibonacci {

    @Id
    @SequenceGenerator(name = "fibonacci_s",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long index;
    private Long value;
    @Column(name = "create_date")
    private LocalDate createDate;

    public Fibonacci() {
    }

    public Fibonacci(Long index, Long value, LocalDate createDate) {
        this.index = index;
        this.value = value;
        this.createDate = createDate;
    }

    public Fibonacci(Long id, Long index, Long value, LocalDate createDate) {
        this.id = id;
        this.index = index;
        this.value = value;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Fibonacci{" +
                "id=" + id +
                ", index=" + index +
                ", value=" + value +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fibonacci fibonacci = (Fibonacci) o;
        return id == fibonacci.id && index == fibonacci.index && value == fibonacci.value && Objects.equals(createDate, fibonacci.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, value, createDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
