package com.technoturtle.example_parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;	


public class TestFunctionCallExpression extends ExampleGrammarTest {
	

	@Test
	public void testFunctionCallExpression_In() throws ParseException {
		initialiseInput("double fp(A) {print(A);} double fp2(B) { fp(5) ;} fp(2); fp2(3);@");		
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}		
		printout();
		assertEquals("2.0\n5.0\n", baos.toString());	
		
	}
	
	@Test
	public void testFunctionCallExpression_Order_Change() throws ParseException {
		initialiseInput("double fp2(B) { fp(5) ;} double fp(A) {print(A);}  fp(2); fp2(3);@");		
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n5.0\n", baos.toString());	
		
	}
	
	
	@Test
	public void testFibonacci() throws ParseException{
		initialiseInput("double fib(n) { if( n :=1){ return 1;}else if( n :=2){ return 1;}else{ return fib(n-1)+fib(n-2);}; } A=fib(25); print(A);@  \n" + 
				"	");		
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("75025.0\n", baos.toString());
		
		
	}
	
	@Test
	public void testFactorias() throws ParseException{
		initialiseInput("double fact(n) { if( n :=1){ return 1;}else{ return n * fact(n - 1);};} a = fact(10); print(a);@");		
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("3628800.0\n", baos.toString());
		
	}

}
