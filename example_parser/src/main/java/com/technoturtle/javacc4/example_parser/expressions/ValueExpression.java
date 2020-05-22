package com.technoturtle.javacc4.example_parser.expressions;
//import expressions.yishu.com.*;


public class ValueExpression  implements Expression{
	
	double operand;
	public ValueExpression(double _value){
		operand = _value;
	}
	public double evaluate(Context context) {
		return operand;
	}
	
}
