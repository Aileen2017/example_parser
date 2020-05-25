package com.technoturtle.javacc4.example_parser.expressions;

public class PrintExpression implements Expression{
	VariableExpression variableExpression;
	
	public PrintExpression(VariableExpression variableExpression) {
		this.variableExpression = variableExpression;
	}
	
	public double evaluate(Context context) {
		System.out.println(variableExpression.evaluate(context));
		return 1.0;
	}

}
