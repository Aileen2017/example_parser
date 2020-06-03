package com.technoturtle.javacc4.example_parser.expressions;

public class ExceptionReturn extends RuntimeException {
	
	double returnedValue;
	
	public ExceptionReturn(double returnedValue) {
		this.returnedValue = returnedValue;
	}

}
