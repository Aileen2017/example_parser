package com.technoturtle.javacc4.example_parser.expressions;

public class AssignmentExpression implements Expression {
	public String variableName;
	public Expression value;
	
	public AssignmentExpression(String variableName, Expression value)
	{
		this.variableName = variableName;
		this.value = value;
	}
	
	@Override
	public double evaluate(Context c) 
	{
		double v = value.evaluate(c);
		
		c.assign(variableName, v);
		
		return v;
	}

	
}
