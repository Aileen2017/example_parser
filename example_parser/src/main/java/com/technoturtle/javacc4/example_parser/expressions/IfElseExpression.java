package com.technoturtle.javacc4.example_parser.expressions;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class IfElseExpression implements Expression {
	public CompareExpression compareExpression1;
	public CompareExpression compareExpression2;
	public BlockExpression blockExpression1;
	public BlockExpression blockExpression2;
	public BlockExpression blockExpression3 = null;
	public HashMap<CompareExpression, BlockExpression> conditionBlockPairs; 

	public IfElseExpression() {

	}

	public IfElseExpression(CompareExpression compareExpression, BlockExpression blockExpression1, BlockExpression blockExpression2) {
		this.compareExpression1 = compareExpression;
		this.blockExpression1 = blockExpression1;
		this.blockExpression2 = blockExpression3;

	}

	public IfElseExpression(CompareExpression compareExpression1, BlockExpression blockExpression1, 
			CompareExpression compareExpression2, BlockExpression blockExpression2, 
			BlockExpression blockExpression3) {
		this.compareExpression1 = compareExpression1;
		this.blockExpression1 = blockExpression1;
		this.compareExpression2 = compareExpression2;
		this.blockExpression2 = blockExpression2;
		this.blockExpression3 = blockExpression3;

	}

	public IfElseExpression(HashMap<CompareExpression, BlockExpression> conditionBlockPairs, BlockExpression blockExpression )
	{
		this.conditionBlockPairs = conditionBlockPairs;
		this.blockExpression3 = blockExpression; 		

	}

	public IfElseExpression(HashMap<CompareExpression, BlockExpression> conditionBlockPairs)
	{
		this.conditionBlockPairs = conditionBlockPairs;


	}


	/*	@Override
		public double evaluate(Context context) {

			Context subcontext = new Context(context);
			subcontext.parent = context;
			try {
				if(compareExpression1.evaluate(context)==1.0) {
					blockExpression1.evaluate(subcontext);
				}else if(compareExpression2.evaluate(context)==1.0) {
					blockExpression2.evaluate(subcontext);
				}
				else {
					blockExpression3.evaluate(subcontext);
				}
			}catch(Exception exception) {
				throw exception;
			}
			return 1.0;
		}*/


	/*@Override
	public double evaluate(Context context) {

		Context subcontext = new Context(context);
		subcontext.parent = context;
		try {
			if(compareExpression1.evaluate(context)==1.0) {
				blockExpression1.evaluate(subcontext);
			}else if(compareExpression2.evaluate(context)==1.0) {
				blockExpression2.evaluate(subcontext);
			}
			else {
				blockExpression3.evaluate(subcontext);
			}
		}catch(Exception exception) {
			throw exception;
		}
		return 1.0;
	}*/


	@Override
	public double evaluate(Context context) {

		Context subcontext = new Context(context);
		subcontext.parent = context;
		boolean completed = false;
		try {
			for(Entry<CompareExpression, BlockExpression> entry : conditionBlockPairs.entrySet()) {
				if(entry.getKey().evaluate(context) == 1.0) {
					entry.getValue().evaluate(subcontext);
					completed = true;
					break;
				}
			}
			if(!completed && blockExpression3 != null) {
				blockExpression3.evaluate(subcontext);
			}
		}catch(Exception exception) {
			throw exception;
		}
		return 1.0;
	}



}
