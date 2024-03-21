package com.example.docker_app.dao.dto;

import java.util.List;
import java.util.Objects;

public class FibonacciBaseDto {
    private Long calculatedValues;

    public FibonacciBaseDto() {
    }

    public FibonacciBaseDto(Long calculatedValues) {
        this.calculatedValues = calculatedValues;
    }

    public Long getCalculatedValues() {
        return calculatedValues;
    }

    public void setCalculatedValues(Long calculatedValues) {
        this.calculatedValues = calculatedValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FibonacciBaseDto that = (FibonacciBaseDto) o;
        return Objects.equals(calculatedValues, that.calculatedValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculatedValues);
    }

    @Override
    public String toString() {
        return "FibonacciBaseDto{" +
                "calculatedValues=" + calculatedValues +
                '}';
    }
}
