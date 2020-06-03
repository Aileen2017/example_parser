package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Context;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestPowerFunction extends ExampleGrammarTest{
	
	
	
	@Test
	public void testPowerFunctionElement() throws ParseException {
		initialiseInput("POW(2,3);@");		
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(8.0, l.evaluate(context)); 

		}
		printout();
		assertEquals("", baos.toString());		
		
	}
	
	
	@Test
	public void testPowerFunction() throws ParseException {
		initialiseInput("A=POW(2,3)+1;print(A);@");		
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("9.0\n", baos.toString());		
		
	}
	
	@Test
	public void testFunctionExpression() throws ParseException {
		initialiseInput("POW(2,3);@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(8.0, l.evaluate(context)); 

		}
		printout();
		//assertEquals("5.0\n", baos.toString());		
		
	}
	
	

}
