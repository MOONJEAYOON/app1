package com.sp.app.calculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {
    @Id
    @GeneratedValue
    private long calculatorId;
    private int num1;
    private String operator;
    private int num2;
    private long num3;
}
