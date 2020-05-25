package com.technoturtle.javacc4.example_parser.expressions;

public class WhileLoopExpression implements Expression {
	
	Expression conditionalExpression;
	BlockExpression blockExpression;
	
	public WhileLoopExpression(Expression conditionalExpression, BlockExpression blockExpression) {
		this.conditionalExpression = conditionalExpression;
		this.blockExpression = blockExpression;
		
	}
	
	
	@Override
	public double evaluate(Context context) {
		
		try {
			while(conditionalExpression.evaluate(context)==1.0) {
				blockExpression.evaluate(context);
			}
		}catch(Error e)
		{
			return 0.0;
		}
		return 1.0;
	}

}
