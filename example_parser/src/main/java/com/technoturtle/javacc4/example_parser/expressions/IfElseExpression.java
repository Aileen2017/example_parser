package com.technoturtle.javacc4.example_parser.expressions;

public class IfElseExpression implements Expression {
	public CompareExpression compareExpression;
	public BlockExpression blockExpression;
	
	
	public IfElseExpression(CompareExpression compareExpression, BlockExpression blockExpression ) {
		this.compareExpression = compareExpression;
		this.blockExpression = blockExpression;
		
	}
	
	@Override
	public double evaluate(Context context) {
		// TODO Auto-generated method stub
		if(compareExpression.evaluate(context)==1.0) {
			blockExpression.evaluate(context);
		}
		return 1.0;
	}

}
