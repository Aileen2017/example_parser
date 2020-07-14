package com.technoturtle.example_parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestIfElse extends ExampleGrammarTest{
	
	
	@Test
	public void testIf() throws ParseException {
		initialiseInput("if(1>3){};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
			
	}
	
	
	@Test
	public void testIfElse() throws ParseException {
		initialiseInput("if(1>3){} else{};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 
			

		}
		printout();
			
	}
	
	
	@Test
	public void testIfElse2() throws ParseException {
		initialiseInput("if( 1>3){A=3; print(A); } else{A=5; print(A); };@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		assertEquals("5.0\n", baos.toString());
		
	}
	
	@Test
	public void testIfElse3() throws ParseException {
		initialiseInput("A=1;B=3;if( A>B){print(A);}else{print(B);};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 
	
		}
		printout();
		assertEquals("3.0\n", baos.toString());
				
	}
	
	@Test
	public void testIfElseIf() throws ParseException{
		initialiseInput("A=2;B=3;C=5;if( A>B){print(B);}else if( A>C){print(C);}else{ print(A);};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 
	
		}
		printout();
		assertEquals("2.0\n", baos.toString());
				
	}
	
	@Test
	public void testIfElseIf2() throws ParseException{
		initialiseInput("A=2;B=3;C=5;if( A>B){print(B);}else if( A>C){print(C);}else if( B<C){print(B);}else{ print(A);};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 
	
		}
		printout();
		assertEquals("3.0\n", baos.toString());
				
	}
	
	
	
	@Test
	public void testEqualCompare() throws ParseException{
		initialiseInput("if( 1 := 2){ 1+2;}else{ A=3+2; print(A);};@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		assertEquals("5.0\n", baos.toString());
		
	}
	
	/*	@Test
		public void testFailedEqualCompare_no_space() throws ParseException{
			initialiseInput("if(1 := 2){1+2;} else{3+2;};@");
			List<Expression> expressions = testParser.multiple_lines(); 
			for(Expression l : expressions) 
			{
				assertEquals(1.0, l.evaluate(context)); 
	
			}
			printout();
			assertEquals("5.0\n", baos.toString());
			
		}*/
	
	
	
	
	
	
	

}
