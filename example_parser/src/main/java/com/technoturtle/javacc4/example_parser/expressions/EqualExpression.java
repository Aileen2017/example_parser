package com.technoturtle.javacc4.example_parser.expressions;

public class EqualExpression implements Expression {
	
	public Expression left, right; 
	
	public EqualExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	public double evaluate(Context context) {
		if(left.evaluate(context)== right.evaluate(context))
			return 1.0;
		else
			return 0.0;
		
	}

}
