package com.sp.app.calculator.service;
import com.sp.app.calculator.entity.Calculator;
import com.sp.app.calculator.repository.CalculatorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public Calculator createCalculator(Calculator calculator) {
        calculator.setNum3(cal(calculator));
        return calculatorRepository.save(calculator);
    }
    public Page<Calculator> findCalculators(int page, int size) {
        return calculatorRepository.findAll(PageRequest.of(page, size,
                Sort.by("calculatorId").descending()));
    }

    public void deleteCalculator(long calculatorId) {
        calculatorRepository.deleteById(calculatorId);

    }

    public Long cal(Calculator calculator) {
        long result;
        if (calculator.getOperator().equals("+")) {
            result = calculator.getNum1() + calculator.getNum2();
        } else if (calculator.getOperator().equals("-")) {
            result = calculator.getNum1() - calculator.getNum2();
        } else if (calculator.getOperator().equals("*")) {
            result = calculator.getNum1() * calculator.getNum2();
        } else if (calculator.getOperator().equals("/")) {
            result = calculator.getNum1() / calculator.getNum2();
        } else {
           throw new IllegalStateException("사칙 연산만 가능합니다. +,-,*,/");
        }
        return result;
    }
}


