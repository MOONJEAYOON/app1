package com.sp.app.calculator.controller;

import com.sp.app.calculator.dto.CalculatorPostDto;
import com.sp.app.calculator.dto.MultiResponseDto;
import com.sp.app.calculator.dto.SingleResponseDto;
import com.sp.app.calculator.entity.Calculator;
import com.sp.app.calculator.mapper.CalculatorMapper;
import com.sp.app.calculator.service.CalculatorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
@Validated
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CalculatorMapper mapper;

    // DI
    public CalculatorController(CalculatorService calculatorService, CalculatorMapper mapper) {
        this.calculatorService = calculatorService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postCalculator(@Valid @RequestBody CalculatorPostDto calculatorPostDto) {

        Calculator calculator =
                calculatorService.createCalculator(mapper.calculatorPostDtoToCalculator(calculatorPostDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.calculatorToCalculatorResponseDto(calculator)),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCalculators(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Calculator> pageCalculators = calculatorService.findCalculators(page - 1, size);
        List<Calculator> calculators = pageCalculators.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.calculatorsToCalculatorResponseDto(calculators),
                        pageCalculators),
                HttpStatus.OK);
    }

    @DeleteMapping("/{calculator-id}")
    public ResponseEntity deleteMember(
            @PathVariable("calculator-id") @Positive long calculatorId) {
            calculatorService.deleteCalculator(calculatorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}