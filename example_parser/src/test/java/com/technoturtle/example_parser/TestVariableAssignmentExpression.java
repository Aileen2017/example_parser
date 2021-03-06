package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;


public class TestVariableAssignmentExpression extends ExampleGrammarTest {
	
	@Test
	public void testVariableAssignment() throws ParseException {
		initialiseInput("A=2;@");
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			assertEquals(2.0, l.evaluate(context)); 
	
		}
		printout();
		
	}

}
