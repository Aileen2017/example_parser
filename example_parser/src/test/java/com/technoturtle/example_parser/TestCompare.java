package com.technoturtle.example_parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestCompare extends ExampleGrammarTest  {
	
	@Test
	public void testSimpleCompare() throws ParseException {
		initialiseInput("1<3;@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		
	}
	
	@Test
	public void testCompoundedCompare1() throws ParseException {
		initialiseInput("A=1<3; print(A);@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		
	}
	
	@Test
	public void testCompoundedCompare2() throws ParseException {
		initialiseInput("A=1<3; print(A);@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		
	}

	
	@Test
	public void testCompoundedCompare3() throws ParseException {
		initialiseInput("(1<3)+5;@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(6.0, l.evaluate(context)); 

		}
		printout();
		
	}
	
	
	@Test
	public void testCompoundedCompare4() throws ParseException {
		initialiseInput("1<3+5;@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		
	}
	
	@Test
	public void testCompoundedCompare5() throws ParseException {
		initialiseInput("1>3;@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(0.0, l.evaluate(context)); 

		}
		printout();
		
	}
	
	
	//if( 1 := 2){ 1+2;} else{ 3+2;};@
	//if(1 := 2){1+2;} else{3+2;};@
	
	@Test
	public void testEqualCompare() throws ParseException{
		initialiseInput("if( 1 := 2){ 1+2;}else{ A=3+2; print(A);};@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(1.0, l.evaluate(context)); 

		}
		printout();
		
		
	}
	
	
	

}
