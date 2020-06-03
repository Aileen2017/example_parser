package com.technoturtle.example_parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestContext extends ExampleGrammarTest {


	public void testScope() throws ParseException {
		
		initialiseInput("A=1;B=3;if( A<B){c=10; print(c);}else{print(B);};print(c);@");
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("10.0\n0.0\n", baos.toString());


	}

}
