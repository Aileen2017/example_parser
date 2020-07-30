package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestWhileLoopExpression extends ExampleGrammarTest {
	
	
	@Test
	public void testWhileLoop1() throws ParseException{
		
		initialiseInput("A=3; while (A>0) { print( A ); A = A-1;};@");		//"print(" "else{"
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("3.0\n2.0\n1.0\n", baos.toString());
		
	}
	
	@Test
	public void testWhileLoop2() throws ParseException{
		
		initialiseInput("A=1;B=1; index = 25; temp = 2; result = 0; while ( temp < index) { result = A+B; A=B ; B= result;temp=temp+1;"
				+ "    }; print(result); @");		//"print(" "else{"
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("75025.0\n", baos.toString());
		
	}
	
	@Test
	public void testWhileLoop3() throws ParseException{
		
		initialiseInput("A=1;B=1; index =25; temp= 2; result = 0; double fb() { if(temp < index){ result = A+B;A=B;B=result; temp = temp+1; return fb();} else{ return result;}; }  result = fb(); print(result);@");		//"print(" "else{"
		List<Expression> expressions = testParser.multiple_lines(); 
		for(Expression l : expressions) 
		{
			l.evaluate(context); 

		}
		printout();
		assertEquals("75025.0\n", baos.toString());
		
	}
	
	//To do:
	
	

	
	
	
	
	
	
	

}
