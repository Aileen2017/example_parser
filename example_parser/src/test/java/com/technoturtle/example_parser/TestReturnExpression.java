package com.technoturtle.example_parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;


public class TestReturnExpression extends ExampleGrammarTest {
	
	@Test
	public void testSimpleReturn() throws ParseException {
		initialiseInput("double fib(A) {return 1+2;} A=fib(1); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("3.0\n", baos.toString());
				
	}
	
	@Test
	public void testComplicatedReturn() throws ParseException{
		
		initialiseInput("double fib(A) { if( A:=1){ return 1;}else{ return 3;};} A=fib(5); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("3.0\n", baos.toString());	
		
	}
	
	@Test
	public void testComplicatedReturn2() throws ParseException{
		
		initialiseInput("double fib(A) { if( A:=1){ return 1;}else{ return 3;};} double fib2(B) { return fib(1); } "
				+ "A=fib(5) + fib2(3); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("4.0\n", baos.toString());	
		
	}
	
	@Test
	public void testComplicatedReturn3() throws ParseException{
		
		initialiseInput("double fib(A) { if( A:=1){ return 2;}else{ return fib(A-1);};}"
				+ "A=fib(5); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n", baos.toString());	
		
	}
	
	
	
	@Test
	public void testComplicatedReturn4() throws ParseException{
		initialiseInput("double fib(A) { if( A:=1){ return 2;}else{ return fib(1);};} A=fib(3); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n", baos.toString());	
				
		
	}
	
	
	@Test
	public void testComplicatedReturn5() throws ParseException{
		initialiseInput("double fib(A) { if( A:=1){ return 2;}else{ return fib(A-1);};} A=fib(7); print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n", baos.toString());	
				
		
	}
	
	
	
}
