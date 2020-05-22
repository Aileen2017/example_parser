
package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream; 
import java.io.InputStream; 
import java.nio.charset.Charset; 
import java.util.List; 
import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.*;


public class ExampleGrammarTest {

	@Test 
	void test() throws ParseException 
	{ 
		String input = "1+5;@"; 
		InputStream inputStream = new
		ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));

		ExampleGrammar exampleGrammar = new ExampleGrammar(inputStream); 
		Context context = new Context(); 
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			System.out.println(l.evaluate(context)); 
			assertEquals(6, l.evaluate(context), "Expected to be 6");

		}
	}
}
