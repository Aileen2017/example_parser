package com.technoturtle.javacc4.example_parser.expressions;

public class CompareExpression implements Expression {

	public Expression left; 
	public Expression right;
	public String compareOperator;
	
	public CompareExpression(Expression left, Expression right, String compareOperator) {
		this.left = left;
		this.right = right;
		this.compareOperator = compareOperator;
		
	}
	
	@Override
	public double evaluate(Context context) {
		// TODO Auto-generated method stub
		switch(compareOperator) {
			case ">":
			{
				if(left.evaluate(context) > right.evaluate(context))
					return 1;
				else
					return 0;
			}
			case "<":
			{
				if(left.evaluate(context) < right.evaluate(context))
					return 1;
				else
					return 0;
				
			}
			case ":=":
			{
				if(left.evaluate(context) == right.evaluate(context))
					return 1;
				else
					return 0;
			}
			default :
				return 0;
		}
		
			
	}

}
