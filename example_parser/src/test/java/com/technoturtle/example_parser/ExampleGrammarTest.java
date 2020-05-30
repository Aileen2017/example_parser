
package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;
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
	public void test() throws ParseException 
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
	
	
	@Test
	public void testPrint() throws ParseException {
		//String input = "A=1;if(A==1){print(A)}else{print(A)};@";
		String input = "A=2; print(A);@";
		InputStream inputStream = new
		ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newPs = new PrintStream(baos);
		PrintStream oldPs = System.out;
		System.setOut(newPs);

		ExampleGrammar exampleGrammar = new ExampleGrammar(inputStream); 
		Context context = new Context(); 
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		System.out.flush();
		System.setOut(oldPs);
		System.out.println(baos.toString());
		assertEquals("2.0\n", baos.toString());
				
	}
	
	@Test
	public void testIfElse() throws ParseException {
		String input = "A=1;B=3;if(A>B){print(A);}else{print(B);};@";
		InputStream inputStream = new
		ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newPs = new PrintStream(baos);
		PrintStream oldPs = System.out;
		System.setOut(newPs);

		ExampleGrammar exampleGrammar = new ExampleGrammar(inputStream); 
		Context context = new Context(); 
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		System.out.flush();
		System.setOut(oldPs);
		System.out.println(baos.toString());
		assertEquals("3.0\n", baos.toString());
				
	}
	
	@Test
	public void testIfElseScope() throws ParseException {
		String input = "A=1;B=3;if(A<B){c=10; print(c);}else{print(B);};print(c);@";
		InputStream inputStream = new
		ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newPs = new PrintStream(baos);
		PrintStream oldPs = System.out;
		System.setOut(newPs);

		ExampleGrammar exampleGrammar = new ExampleGrammar(inputStream); 
		Context context = new Context(); 
		List<Expression> expressions = ExampleGrammar.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		System.out.flush();
		System.setOut(oldPs);
		System.out.println(baos.toString());
		assertEquals("10.0\n0.0\n", baos.toString());
				
	}
	
	//String input = "def f() { print(100)}; call f();@";
	
	
	
	
}
