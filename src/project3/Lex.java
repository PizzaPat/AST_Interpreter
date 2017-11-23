package project3;
import java.util.*;

/*
	Project #1: Lexer
	this program transforms an A2 high-level program into a list of tokens
	@author Patrapee Pongtana
	@author Chanon Chantaduly 
	@author David Van
	@author Anthony Lopez
*/
public class Lex{
	private Token[] tokenArray;
	private int index;
	private	String terminal;
	private Deque<String> q;
	//Add-on: 10/24/2017
	private Deque<Integer> tokenStack;
	private Deque<String> tokenString;
	//------------------
	private int lineNum;
	private int tokenIndex;
	

	/*
	Class declaraction
	*/
	public Lex(){
		this.index = 0;
		this.terminal = "";
		this.q = new LinkedList<String>();
		this.tokenStack = new LinkedList<Integer>();
		this.tokenString = new LinkedList<String>();
		this.lineNum = 1;
		this.tokenArray = new Token[30];
		this.tokenIndex = 0;
	}


	//Sets the current string in the object
	public String setTerminal(String s){
		terminal = s;
		return s;
	}

	//Increments line
	public void incLine(){
		lineNum++;
	}

	//Gets current line number
	public int getNumLine(){
		return lineNum;
	}

	//Increments the index
	public void advance(){
		index++;
	}

	//Looks at value of next index
	public char peek(){
		return terminal.charAt(current()+1);
	}

	//Returns the current index
	public int current(){
		return index;
	}

	//Checks if the brackets are enclosed properly
	public boolean popBrack(String t, Lex l, Stack<String> s){
		if(t.charAt(l.current())=='{')
			s.push("{");
		if(t.charAt(l.current())=='}'){
			s.pop();
			if(s.empty())
				return true;
		}
		return false;
	}

	//Check if the line contains comment
	public boolean commentCheck(String t, Lex l){
		if(t.charAt(l.current())=='/'){
			try{
				if(l.peek()=='/')
					return true;
			}
			catch(Exception e){
				System.out.println("OFB");
			}
		}
		return false;
	}

	//Checks for character tokens
	public int checkCategory(String s, char type){
		int tmpCur=0;
		if(type == 's'){// Type is string
			return 5;
		}
		else{
			if(s.length() > 1){
				//possible multiple char
				switch(s){
					case "prog":
						return 10;
					case "main":
						return 11;
					case "fcn":
						return 12;
					case "class":
						return 13;
					case "float":
						return 15;
					case "int":
						return 16;
					case "string":
						return 17;
					case "if":
						return 18;
					case "elseif":
						return 19;
					case "else":
						return 20;
					case "while":
						return 21;
					case "input":
						return 22;
					case "print":
						return 23;
					case "new":
						return 24;
					case "return":
						return 25;
					case "->":
						return 51;
					case "==":
						return 52;
					case "!=":
						return 53;
					case "<=":
						return 54;
					case ">=":
						return 55;
					case "<<":
						return 56;
					case ">>":
						return 57;
					default:
						break;
				}
			}
			else{ //single char
				switch(s.charAt(0)){
					case ',':
						return 6;
					case ';':
						return 7;
					case '<':
						return 31;
					case '>':
						return 32;
					case '{':
						return 33;
					case '}':
						return 34;
					case '[':
						return 35;
					case ']':
						return 36;
					case '(':
						return 37;
					case ')':
						return 38;
					case '*':
						return 41;
					case '^':
						return 42;
					case ':':
						return 43;
					case '.':
						return 44;
					case '=':
						return 45;
					case '-':
						return 46;
					case '+':
						return 47;
					case '/':
						return 48;
					default:
						break;			
					}
				}
			}

		//If it reached this point, the string is not matched with
			//any of reserve keyword, thus, continue to classify
		if((s.matches("[a-zA-Z]+") || s.matches("_") || !(Character.isDigit(s.charAt(0)))) 
		&& !s.contains(".")){
			return 2;
		}

		if(s.charAt(0)=='-' || s.matches("[0-9]+") || s.contains(".")){
			if(!(s.contains("."))){
				return 3;
			}
			else{
				return 4;
			}
		}
		
		return 99;
	}

	//Add-on: 10/24/2017

	//Prints output from queue
	public void printOutput(int tokenNum, int line, String s){
		if(tokenNum==3){
			q.add("(Tok: "+tokenNum+" line "+line+ " str=\""+s+"\" int = "+s+")");
			tokenStack.add(tokenNum);
			tokenString.addLast(s);
			//TOKEN CLASS//
			Token T = new Token(tokenNum,s,"int");
			tokenArray[this.tokenIndex] = T;
			this.tokenIndex++;
		}
		else if(tokenNum==4){
			q.add("(Tok: "+tokenNum+" line "+line+ " str=\""+s+"\" float = "+s+")");
			tokenStack.add(tokenNum);
			tokenString.addLast(s);
			//TOKEN CLASS//
			Token T = new Token(tokenNum,s,"float");
			tokenArray[this.tokenIndex] = T;
			this.tokenIndex++;
		}
		else{
			q.add("(Tok: "+tokenNum+" line "+line+ " str=\""+s+"\")");
			tokenStack.add(tokenNum);
			tokenString.addLast(s);
			//TOKEN CLASS//
			Token T = new Token(tokenNum,s,"-");
			tokenArray[this.tokenIndex] = T;
			this.tokenIndex++;
		}
	}

	public Token[] getTokenArray(){
		Lex lexer = new Lex();
		boolean finish=false;
		boolean comment=false;
		Scanner get = new Scanner(System.in);
		String lineString;
		String tmpString;
		int token;
		Stack<String> s = new Stack<String>();

		while(!finish){
			System.out.print(">>>");
			lineString = lexer.setTerminal(get.nextLine());
			lexer.index=0;
			comment = false;
			token = 0;
			tmpString = "";
			while(lexer.current() < lineString.length() && comment == false){				
				if(lineString.charAt(lexer.current()) ==' '){
					//See white space, skip
					lexer.advance();
				}
				else if(lineString.charAt(lexer.current()) =='('){ // Catch '(' char
					tmpString = "(";
					token = lexer.checkCategory(tmpString,'n');
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					finish = lexer.popBrack(lineString,lexer,s);						
					tmpString = "";
					lexer.advance();
				}
				else if(lineString.charAt(lexer.current()) ==','){ // Catch ',' char
					tmpString = ",";
					token = lexer.checkCategory(tmpString,'n');
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					finish = lexer.popBrack(lineString,lexer,s);						
					tmpString = "";
					lexer.advance();
				}
				else if(lineString.charAt(lexer.current()) ==';'){ // Catch ';' char
					tmpString = ";";
					token = lexer.checkCategory(tmpString,'n');
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					finish = lexer.popBrack(lineString,lexer,s);						
					tmpString = "";
					lexer.advance();
				}
				else if(lineString.charAt(lexer.current()) =='{'){ // Catch '{' char
					tmpString = "{";
					token = lexer.checkCategory(tmpString,'n');
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					finish = lexer.popBrack(lineString,lexer,s);						
					tmpString = "";
					lexer.advance();
				}
				else if(lineString.charAt(lexer.current()) =='\"'){// Catch '"' char
					//Treat as string
					try{
						lexer.advance();
						while(lexer.peek() != '\"'){
							tmpString = tmpString + lineString.charAt(lexer.current());
							finish = lexer.popBrack(lineString,lexer,s);
							lexer.advance();
						}
						tmpString = tmpString + lineString.charAt(lexer.current());
						finish = lexer.popBrack(lineString,lexer,s);
						lexer.advance();
					}
					catch(Exception e){
						tmpString = tmpString + lineString.charAt(lexer.current());
						finish = lexer.popBrack(lineString,lexer,s);
						lexer.advance();
					}
					token = lexer.checkCategory(tmpString,'s');					
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					lexer.advance();
					tmpString = "";
				}
				else{
					if(lexer.commentCheck(lineString, lexer)){
						//Break while loop once see comment //
						break;
					}
					try{
						while(lexer.peek() != ' ' && lexer.peek() != '(' && lexer.peek() != ')'
							&& lexer.peek() != ',' && lexer.peek() != ';' && lexer.peek() != '{'){
							tmpString = tmpString + lineString.charAt(lexer.current());
							finish = lexer.popBrack(lineString,lexer,s);
							lexer.advance();
						}
						tmpString = tmpString + lineString.charAt(lexer.current());
						finish = lexer.popBrack(lineString,lexer,s);
						lexer.advance();
					}
					catch(Exception e){
						tmpString = tmpString + lineString.charAt(lexer.current());
						finish = lexer.popBrack(lineString,lexer,s);
						lexer.advance();
					}
					token = lexer.checkCategory(tmpString,'n');
					lexer.printOutput(token,lexer.getNumLine(),tmpString);
					tmpString = "";
				}
			}
			lexer.incLine();
		}
		//terminating
		lexer.printOutput(0,lexer.getNumLine()-1,"");
		System.out.println("------------  OUTPUT ------------");
		Iterator iterator = lexer.q.iterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        System.out.println("--------------------->>>>");
        
        Iterator iterator2 = lexer.tokenStack.iterator();
        while (iterator2.hasNext()){
        	System.out.println("\t" + iterator2.next());
        }
        
        System.out.println("--------------------->>>>");
        
        Iterator iterator3 = lexer.tokenString.iterator();
        while (iterator3.hasNext()){
        	System.out.println("\t" + iterator3.next());
        }
        System.out.println("--------------");
        //System.out.println(lexer.tokenArray[0].getId());
     	//System.out.println(lexer.tokenArray[0].getCharacter());
        //System.out.println(lexer.tokenArray[0].getType());
        for(int i=0; i < lexer.tokenIndex; i++){
        	System.out.print(lexer.tokenArray[i].getId());
        	System.out.print(lexer.tokenArray[i].getName());
        	System.out.print(lexer.tokenArray[i].getType());
        	System.out.println();
        }
        return tokenArray;
	}
}