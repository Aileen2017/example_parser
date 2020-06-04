package com.technoturtle.example_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.technoturtle.javacc4.example_parser.ExampleGrammar;
import com.technoturtle.javacc4.example_parser.ParseException;
import com.technoturtle.javacc4.example_parser.expressions.Expression;

public class TestFunctionExpression extends ExampleGrammarTest {

	@Test
	public void testPowerFunctionExpression_print_statements() throws ParseException {
		initialiseInput("A=POW(2,3);print(A);@");
		List<Expression> expressions = ExampleGrammar.multiple_lines();
		for (Expression l : expressions) {
			l.evaluate(context);

		}
		printout();
		assertEquals("8.0\n", baos.toString());

	}

	@Test
	public void testCustomisedFunctionExpression() throws ParseException {
		initialiseInput("double fp() { A=2; print(A);} fp();@");
		List<Expression> expressions = ExampleGrammar.multiple_lines();
		for (Expression l : expressions) {
			l.evaluate(context);

		}
		printout();
		assertEquals("2.0\n", baos.toString());

	}

}
