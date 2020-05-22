package com.technoturtle.javacc4.example_parser.expressions;
import java.util.*;
public class Context {
	
	static Map<String, Double> map = new HashMap<String, Double>();
	
	public static void assign(String name, Double value) {
		map.put(name, value);
	}
	
	public static double getVariableValue(String name) {
		return map.get(name);
	}
	
	
	
	

}
