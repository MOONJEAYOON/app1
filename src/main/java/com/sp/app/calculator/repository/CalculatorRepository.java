package com.sp.app.calculator.repository;

import com.sp.app.calculator.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

}

