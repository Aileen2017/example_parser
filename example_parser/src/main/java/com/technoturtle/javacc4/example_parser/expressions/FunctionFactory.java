
  package com.technoturtle.javacc4.example_parser.expressions; 
  import java.util.*;
  
  public class FunctionFactory implements Expression {
	  static HashMap<String, FunctionExpression> functionMap = new HashMap<String, FunctionExpression>();
	  
	  public static Expression createFunction(String name, List<Expression> parametersList) {
		  if(name.equals("POW") && parametersList.size()==2)
			  return new PowerExpression(parametersList.get(0), parametersList.get(1));
		  else if(functionMap.get(name) != null) {
			  FunctionExpression functionExpression = functionMap.get(name);
			  functionExpression.setInputValues(parametersList);
			  return functionExpression;
		  }
		  else
			  throw new Error("unknown function"+ name);
	  }
	  
	
	  
	  
	  public static void addFunction(FunctionExpression functionDef) {
		  functionMap.put(functionDef.methodName, functionDef);
	  }
	  
	  public double evaluate(Context context) {
		 // functionMap.put(functionDef.methodName, functionDef);
		  return 1.0;
		  
	  }
  

  
  
  }
 