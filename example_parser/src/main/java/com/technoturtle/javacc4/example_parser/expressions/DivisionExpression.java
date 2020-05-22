package com.technoturtle.javacc4.example_parser.expressions;


public class DivisionExpression implements Expression{
	Expression left;
	Expression right;
	public DivisionExpression(Expression _left, Expression _right){
		left = _left;
		right = _right;
	}
	
	public double evaluate(Context c) {
		return left.evaluate(c) / right.evaluate(c);
		
	}
	
}

