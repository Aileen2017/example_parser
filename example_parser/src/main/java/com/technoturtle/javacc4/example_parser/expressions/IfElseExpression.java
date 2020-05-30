package com.technoturtle.javacc4.example_parser.expressions;

public class IfElseExpression implements Expression {
	public CompareExpression compareExpression;
	public BlockExpression blockExpression1;
	public BlockExpression blockExpression2;
	
	
	public IfElseExpression(CompareExpression compareExpression, BlockExpression blockExpression1, BlockExpression blockExpression2) {
		this.compareExpression = compareExpression;
		this.blockExpression1 = blockExpression1;
		this.blockExpression2 = blockExpression2;
		
	}
	
	@Override
	public double evaluate(Context context) {
		// TODO Auto-generated method stub
		
		Context subcontext = new Context(context);
		subcontext.parent = context;
		if(compareExpression.evaluate(context)==1.0) {
			blockExpression1.evaluate(subcontext);
		}else {
			blockExpression2.evaluate(subcontext);
		}
		return 1.0;
	}

}
