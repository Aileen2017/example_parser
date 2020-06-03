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


public class TestFunctionCallExpression extends ExampleGrammarTest {
	

	@Test
	public void testFunctionCallExpression_In() throws ParseException {
		initialiseInput("double fp(A) {print(A);} double fp2(B) { fp(5) ;} fp(2); fp2(3);@");		
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n5.0\n", baos.toString());	
		
	}

}
