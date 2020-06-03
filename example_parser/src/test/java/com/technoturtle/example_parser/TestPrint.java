package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Context;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestPrint extends ExampleGrammarTest {
	
	
	
	@Test
	public void testPrint() throws ParseException {
		//String input = "A=1;if(A==1){print(A)}else{print(A)};@";
		initialiseInput("A=2; print(A);@");
		/*input = "A=2; print(A);@";
		inputStream = new
				ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
		exampleGrammar = new ExampleGrammar(inputStream); */
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("2.0\n", baos.toString());
				
	}

}
