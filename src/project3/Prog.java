package project3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prog{
	public static void main(String[] args){
		Token[] input = {new Token(0, "kprog", "-"), new Token(1, "{", "-"), new Token(16, "int", "7"), new Token(34, "}", "-")};
		Parser LLparser = new Parser();
		System.out.println("kprog { int }\n\n\n");
		LLparser.createPST(input);
	}
}