package com.sp.app.calculator.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CalculatorPostDto {
//    @NotBlank(message = "공백이 아니어야 합니다.")
    private int num1;
    private String operator;
//    @NotBlank(message = "공백이 아니어야 합니다.")
    private int num2;

    public int getNum1() {
        return num1;
    }

    public String getOperator() {
        return operator;
    }

    public int getNum2() {
        return num2;
    }
}