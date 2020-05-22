package com.technoturtle.javacc4.example_parser.expressions;


public class MinusExpression implements Expression{
	Expression left;
	Expression right;
	public MinusExpression(Expression _left, Expression _right){
		left = _left;
		right = _right;
	}
	
	public double evaluate(Context context) {
		return left.evaluate(context) - right.evaluate(context);
		
	}
	
}