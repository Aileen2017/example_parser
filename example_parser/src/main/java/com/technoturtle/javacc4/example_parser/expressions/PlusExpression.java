package com.technoturtle.javacc4.example_parser.expressions;


public class PlusExpression implements Expression{
	public Expression left;
	public Expression right;
	public PlusExpression (Expression _left, Expression _right){
		left = _left;
		right = _right;
		
	}

	
	public double evaluate(Context context) {
		return left.evaluate(context)+right.evaluate(context);
	}
	
}