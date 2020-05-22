package com.technoturtle.javacc4.example_parser.expressions;

public class VariableExpression implements Expression {
	public String variableName;
	public double variableValue;
	
	public VariableExpression(String variableName) {
		this.variableName = variableName;
	}
	
	@Override
	public double evaluate(Context context) {
		
		return context.getVariableValue(variableName);
	}

}
