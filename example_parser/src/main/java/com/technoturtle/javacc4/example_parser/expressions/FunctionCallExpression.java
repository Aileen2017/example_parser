package com.technoturtle.javacc4.example_parser.expressions;
import java.util.*;

public class FunctionCallExpression implements Expression {
	FunctionExpression functionExpression;
	List<Expression> parameterValues;
	String functionName;
	
	/*public FunctionCallExpression(FunctionExpression functionExpression, List<Expression> parameterValues) {
		this.functionExpression = functionExpression;
		this.parameterValues = parameterValues;
				
	}*/
	
	public FunctionCallExpression(String functionName, List<Expression> parameterValues) {
		
		this.functionName = functionName;
		this.parameterValues = parameterValues;
				
	}
	
	public double evaluate(Context context) {
		FunctionExpression functionExpression = FunctionFactory.functionMap.get(functionName);
		Context subContext = new Context();
		subContext.parent = context;
		for(int i=0; i< functionExpression.parameterNames.size();i++)
			subContext.map.put(functionExpression.parameterNames.get(i), parameterValues.get(i).evaluate(subContext));	
		double returnedValue;
		try {
			returnedValue = functionExpression.blockExpression.evaluate(subContext);
		}
		catch(Exception e) {
			returnedValue = ((ExceptionReturn)e).returnedValue;
		}
		
		//context.assign(methodName+"1", 0);
		return returnedValue;
		
	}

}
