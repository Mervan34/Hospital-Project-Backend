package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ErchospitalApplication.class)
class ErchospitalApplicationTests {
	
	Calculator calculatorTest = new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
    public void test_add(){
        // given
       int firstNumber = 10;
       int secondNumber = 20;
       int expected = 30;

       // when
       int actual = calculatorTest.add(firstNumber, secondNumber);

       // then
       Assertions.assertEquals(expected, actual);
       System.out.println(" inside test ");

    }

    class Calculator{
       int add(int a, int b){
           return a + b;
       }
    }
	
	

}
