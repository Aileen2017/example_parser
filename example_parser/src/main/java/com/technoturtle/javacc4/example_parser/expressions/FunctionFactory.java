
  package com.technoturtle.javacc4.example_parser.expressions; 
  import java.util.*;
  
  public class FunctionFactory {
	  public static HashMap<String, FunctionExpression> functionMap = new HashMap<String, FunctionExpression>();  
	  
	  public static Expression createFunctionCallExpression(String name, List<Expression> parametersList) {
		  if(name.equals("POW") && parametersList.size()==2)
			  return new PowerExpression(parametersList.get(0), parametersList.get(1));
		  else{ 
			  FunctionCallExpression functionCallExpression = new FunctionCallExpression(name, parametersList);	  
			  return functionCallExpression;
		  }
		 
		  
	  }
	  
	
	  
	  
	  public static void addFunction(FunctionExpression functionDef) {
		  functionMap.put(functionDef.methodName, functionDef);
	  }
	  
	  
	
  

  
  
  }
 