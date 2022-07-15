package com.sp.app.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResponseDto {
    private long calculatorId;
    private int num1;
    private String operator;
    private int num2;
    private long num3;

}


