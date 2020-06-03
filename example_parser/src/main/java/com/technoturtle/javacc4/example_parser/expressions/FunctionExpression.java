package com.technoturtle.javacc4.example_parser.expressions;
import java.util.*;
 
public class FunctionExpression implements Expression {
	public String methodName;
	public String returnedType;
	public List<String> parameterNames;
	public List<Expression> parameterValues;
	public BlockExpression blockExpression;
	
	
	public FunctionExpression(String returnedType, String methodName, List<String> parameters, BlockExpression blockExpression) {
		this.returnedType = returnedType;
		this.methodName = methodName;
		this.parameterNames = parameters;
		this.blockExpression = blockExpression;
	}
	
	public void setInputValues(List<Expression> parameterValues) {
		this.parameterValues = parameterValues;
	}
	
	public double evaluate(Context context) {
	
		return 1.0;
		
	}
	
	

}
