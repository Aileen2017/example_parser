package com.technoturtle.javacc4.example_parser.expressions;

public class StatementAssignment {
	public String variableName;
	public double assignedValue;
	
	public StatementAssignment(String _variableName, double _assignedValue) {
		variableName = _variableName;
		assignedValue = _assignedValue;
	}
	
	public void execute() {
		System.out.println(variableName +" " + assignedValue);
	}
	
	

}
