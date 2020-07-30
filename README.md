# example_parser
Steps to run the parser
1. Go to your_folder and run Git clone https://github.c/Aileen2017/example_parser.git

2. Go to your_folder/example_parser/example_parser, run mvn compile

3: then run mvn exec:java, user prompt should appear: Reading from standard input...

4: enter the following code written in this customised language
 
double fib(n) { if( n :=1){ return 1;}else if( n :=2){ return 1;}else{ return fib(n-1)+fib(n-2);}; } A=fib(25); print(A);@

5: enter the following code written in this customised language
A=1;B=1; index = 25; temp = 2; result = 0; while ( temp < index) { result = A+B; A=B ; B= result;temp=temp+1;}; print(result); @




