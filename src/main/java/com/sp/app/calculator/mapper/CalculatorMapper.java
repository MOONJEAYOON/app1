package com.sp.app.calculator.mapper;

import com.sp.app.calculator.dto.CalculatorPostDto;
import com.sp.app.calculator.dto.CalculatorResponseDto;
import com.sp.app.calculator.entity.Calculator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component  // (1)
public class CalculatorMapper {

    public Calculator calculatorPostDtoToCalculator(CalculatorPostDto calculatorPostDto) {
        return new Calculator(0L,
                calculatorPostDto.getNum1(),
                calculatorPostDto.getOperator(),
                calculatorPostDto.getNum2(),
                0L);
    }


    public CalculatorResponseDto calculatorToCalculatorResponseDto(Calculator calculator) {
        return new CalculatorResponseDto(calculator.getCalculatorId(),
                calculator.getNum1(),
                calculator.getOperator(),
                calculator.getNum2(),
                calculator.getNum3());
    }
    public List<CalculatorResponseDto> calculatorsToCalculatorResponseDto(List<Calculator> calculators) {
        if ( calculators == null ) {
            return null;
        }

        List<CalculatorResponseDto> list = new ArrayList<CalculatorResponseDto>( calculators.size() );
        for ( Calculator calculator : calculators ) {
            list.add( calculatorToCalculatorResponseDto( calculator ) );
        }

        return list;
    }


}

//
//import com.sp.app.calculator.dto.CalculatorPostDto;
//import com.sp.app.calculator.dto.CalculatorResponseDto;
//import com.sp.app.calculator.entity.Calculator;
//import org.mapstruct.Mapper;
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface CalculatorMapper {
//    Calculator calculatorPostDtoToCalculator(CalculatorPostDto calculatorPostDto);
//    CalculatorResponseDto calculatorToCalculatorResponseDto(Calculator calculator);
//    List<CalculatorResponseDto> calculatorsToCalculatorResponseDto(List<Calculator> calculators);
//
//}