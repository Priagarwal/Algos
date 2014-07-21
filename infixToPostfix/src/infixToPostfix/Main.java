package infixToPostfix;

import java.util.HashMap;

public class Main {
	private String infix;
	private String postfix;
	public HashMap<Character, Integer> priorities;
	
	public void setOperatorPriorities() {
		this.priorities = new HashMap<Character, Integer>();
		this.priorities.put('(', 0);
		this.priorities.put('+', 1);
		this.priorities.put('-', 1);
		this.priorities.put('*', 2);
		this.priorities.put('/', 2);
		this.priorities.put('%', 2);
		this.priorities.put(')', 3);
	}
	
	public int getPriority(char c) {
		return(priorities.get(c));
	}
	
	Main(String ex) {
		this.infix = ex;
		this.postfix = null;
	}
	
	boolean isOperand(char c) {
		if ( c == '(' || c == ')' || isOperator(c))
			return false;
		return true;
	}
	
	boolean isOperator(char c) {
		if( c == '+' || c == '-'|| c == '*'|| c == '/'|| c == '%' )
			return true;
		return false;
	}
	
	void inToPost(){
		Stack auxStk = new Stack(infix.length());	
		char[] postfixArray = new char[infix.length()+1];
		char[] infixArray = infix.toCharArray();
		char c;
		int k = 0;
		for (int i = 0; i < infixArray.length; i++) {
			c = infixArray[i];
			//System.out.println(c);
			if(isOperand(c)) {
				postfixArray[k++] = c;
			} else if (c == '(') {
				auxStk.push(c);
			} else if (c == ')'){
				char temp = auxStk.pop();
				while (temp != '(') {
					postfixArray[k++] = temp;
					temp = auxStk.pop();
				}				
			} else  {														// c is a operator
				if(auxStk.isEmpty()) {
					System.out.println("Auxilary stack is empty");
					auxStk.push(c);					
				} else {
					char temp = auxStk.pop();
					System.out.println(temp);
					while (getPriority(temp) >= getPriority(c)) {
						//System.out.println();
						postfixArray[k++] = temp;
						if (auxStk.isEmpty())
							break;
						else
						temp = auxStk.pop();
					}	
					auxStk.push(temp);
					auxStk.push(c);
				}
			}
		}
		while (!auxStk.isEmpty()) {
			System.out.println("Aux stack is not empty");
			postfixArray[k++] = auxStk.pop();
		}
		postfixArray[k]= '\0'; 		
		System.out.println(postfixArray);
		postfix = new String(postfixArray);
		System.out.println(postfix);
	}
	
	public char evaluate() {
		System.out.println("In evaluate, evaluating " + postfix);
		Stack evalStk = new Stack(10);
		char postfixArray[] = postfix.toCharArray();
		System.out.println("Length of the postfix exp is " + postfixArray.length);
		for ( int i = 0; i < postfixArray.length - 1; i++) {
			if (isOperand(postfixArray[i]) ) {
				evalStk.push(postfixArray[i]);
			} else {
				char op = postfixArray[i];
				char b = evalStk.pop();
				char a = evalStk.pop();
				int res = cal(a,b,op);
				System.out.println(res);
				//char toPush = (char) (res + '0');
				char toPush = (char)(((int)'0')+res);
				System.out.println("Charcter to push " + toPush);
				evalStk.push(toPush);
			}
			evalStk.printStk();
		}
		System.out.println("Returning value " + evalStk.getTop());
		return (evalStk.getTop());
	}
	
	int cal(char alpha, char beta, char op) {
		int a = alpha - '0';
		int b = beta - '0';
		System.out.println(a);
		System.out.println(b);
		if (op == '*') {
			return (a*b);
		} else if (op == '+') {
			System.out.println("adding");
			return (a+b);
		} else if (op == '/') {
			return (a/b);
		} else if (op == '-') {
			return (a-b);
		} else if (op == '%') {
			return (a%b);
		}
		
		return 0;
	}
	
	
	public static void main(String args[]) {
		Main myClass = new Main("2+3*5");
		myClass.setOperatorPriorities();
		System.out.println(myClass.infix);
		//System.out.println(myClass.getPriority('+'));
		myClass.inToPost();
		//System.out.println(myClass.postfix);
		char res1 = myClass.evaluate();
		System.out.println(res1);
	}
	
	
}
