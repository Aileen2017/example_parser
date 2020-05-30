package com.technoturtle.javacc4.example_parser.expressions;

import java.util.*;

public class Context {
	Context parent;

	public Context() {
		this.parent = null;
	}

	public Context(Context parent) {
		this.parent = parent;
	}

	Map<String, Double> map = new HashMap<String, Double>();

	public void assign(String name, Double value) {
		map.put(name, value);
	}

	public double getVariableValue(String name) {
				
		Double result = map.get(name); 
		if(result != null) 
			return result; 
		else
			if(parent != null) 
				return parent.getVariableValue(name); 
			else return 0;
		 

	}

}
