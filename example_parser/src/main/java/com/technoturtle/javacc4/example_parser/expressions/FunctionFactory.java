
  package com.technoturtle.javacc4.example_parser.expressions; import java.util.*;
  
  public class FunctionFactory {
  
	  public static Expression createFunction(String name, List<Expression> parametersList) {
		  if(name.equals("POW") && parametersList.size()==2)
			  return new PowerExpression(parametersList.get(0), parametersList.get(1));
		  else
			  throw new Error("unknown function"+ name);
	  }
  

  
  
  }
 