
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

public class ExampleGrammarTest {
	ExampleGrammar exampleGrammar ;
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
		exampleGrammar = new ExampleGrammar(inputStream); 
	}
	
	void printout() {
		System.out.flush();
		System.setOut(oldPs);
		System.out.println(baos.toString());
	}
	
	
	@Test
	public void testSimpleCalculate() throws ParseException {
		//2+3;@
	}
	
	@Test
	public void testCalculateWithFunction() throws ParseException {
		//POW(2,3)+1;@
	}
	
	@Test
	public void testFunctionOnly() throws ParseException {

		//double fib(A) {return 1+2;} @
	}
	

	@Test
	public void testFibonacci() {
		//double fib(a) { if(1 := 2){return 1+2;} else{return 2+2;};} A=fib(2); print(A);@	
		//double fib(a) { if(a := 1){return 1;} else{return 2+2;};} A=fib(2); print(A);@
		//(not working)//double fib(a) { if(1 := 2){return 1+2;} else{return 2+2;};return fib(a-1)+fib(a-2);} A=fib(3); print(A);
		//double fib(a) { if(a := 1){return 1;} else{return 2+2;};} double fib2(b) { return 4;} A=fib(1)+fib2(2); print(A);@
		//double fib(a) { if(a := 1){return 1;} else{return 2+2;};} double fib2(b) { return 4;} A=fib(6)+fib2(2); print(A);@
		
		//not working double fib(a) { if(a := 1){return 1;} else{return 2+2;};} double fib2(b) { return fib(1);} A=fib(6)+fib2(2); print(A);@
		
		//not working //double fib(a) { if(a := 1){return 1;} else{return 2+2;}} double fib2(b) { return fib(1);} A=fib(6)+fib2(2); print(A);@
		//showing method_def can be written inside block(to be improved): if(1:=1){ A=2; double f() { A=2;}  } else{ };@ 
		//double fp(A) {print(A);} double fp2(B) { fp(5) ;} fp(2); fp2(3);@
		
	}
	

	
	
}

