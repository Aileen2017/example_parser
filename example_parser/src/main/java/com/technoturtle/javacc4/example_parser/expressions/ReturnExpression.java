package com.technoturtle.javacc4.example_parser.expressions;

public class ReturnExpression implements Expression{
	
	public Expression calculateExpression;
	public double returnedValue;
	
	public ReturnExpression(Expression expression) {
		calculateExpression = expression;
	}
	
	public double evaluate(Context context) {
		double returnedValue = 0;
		
		returnedValue = calculateExpression.evaluate(context);
		throw new ExceptionReturn(returnedValue);
			
	}
	
	

}

