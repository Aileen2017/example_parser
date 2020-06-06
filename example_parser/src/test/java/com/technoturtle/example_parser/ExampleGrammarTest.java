
package com.technoturtle.example_parser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.expressions.Context;

public class ExampleGrammarTest {
	ExampleGrammar testParser ;
	String input;
	InputStream inputStream;
	Context context; 
	ByteArrayOutputStream baos ;
	PrintStream newPs;
	PrintStream oldPs;
	
	@BeforeEach
	void setup() {
			
		context = new Context(); 
		baos = new ByteArrayOutputStream();
		newPs = new PrintStream(baos);
		oldPs = System.out;
		System.setOut(newPs);
		
	}
	
	void initialiseInput(String input) {
		this.input = input;
		inputStream = new
				ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
		testParser = new ExampleGrammar(inputStream); 
	}
	
	void printout() {
		System.out.flush();
		System.setOut(oldPs);
		System.out.println(baos.toString());
	}
	

	

	

	
	
}

