package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestAddition extends ExampleGrammarTest {


	@Test 
	public void testAddition() throws ParseException 
	{ 
		initialiseInput("1+5;@");	
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			System.out.println(l.evaluate(context)); 
			assertEquals(6, l.evaluate(context), "Expected to be 6");

		}
	}
	

}
