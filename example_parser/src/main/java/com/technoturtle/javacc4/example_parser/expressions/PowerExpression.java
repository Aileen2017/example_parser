package com.technoturtle.javacc4.example_parser.expressions;

public class PowerExpression implements Expression{
	Expression left, right;
	
	public PowerExpression(Expression _left, Expression _right) {
		left = _left;
		right = _right;
		
	}
	
	@Override
	public double evaluate(Context context) {
		// TODO Auto-generated method stub
		return Math.pow(left.evaluate(context), right.evaluate(context));
	}

}
