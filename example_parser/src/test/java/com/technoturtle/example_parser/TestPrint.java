package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestPrint extends ExampleGrammarTest {
	
	
	
	@Test
	public void testPrint() throws ParseException {
		initialiseInput("A=2; print(A);@");
	
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n", baos.toString());
				
	}

}
