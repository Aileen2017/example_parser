package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestCalculate extends ExampleGrammarTest {
	
	@Test
	public void testSimpleCalculate() throws ParseException {
		initialiseInput("2+3;@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(5.0, l.evaluate(context)); 

		}
		printout();
		assertEquals("", baos.toString());
	}
	
	@Test
	public void testCalculateWithFunction() throws ParseException {
		initialiseInput("POW(2,3)+1;@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(9.0, l.evaluate(context)); 

		}
		printout();
		assertEquals("", baos.toString());
	}
	
	
	@Test
	public void testPowerFunctionExpression_print_statements() throws ParseException {
		initialiseInput("A=POW(2,3);print(A);@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("8.0\n", baos.toString());
				
	}
	
	

}
