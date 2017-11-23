package project3;

import java.util.*;

public class Node {
	
   private Symbol symbol;
   private Node[] kids;
   private boolean isEOF; // is it "$"
	
	public Node(Symbol s, boolean eof){
	   
      // create copy of symbol passed in
      Symbol newSymbol = new Symbol(s.getId(), s.getName(), s.getIsTerminal());
      
      symbol = newSymbol;
      isEOF = eof;
      kids = new Node[10];
	}
   
   public Node(boolean eof) {
      isEOF = eof;
      kids = new Node[10];
   }

   public String toString() {
       return this.getSymbol().getName();
   }
   
   public void addKid(Node k) {

      for (int i = 0; i < kids.length; i++) {
         if (getKids()[i] == null) {
            getKids()[i] = k;
            return;
         }
      }
   }
   
   public Symbol getSymbol() {
      return symbol;
   }
   
   public void setToken(Token t) {
      this.symbol.setRef(t);
   }
   
   public Node[] getKids() {
      return kids;
   }
   
   public boolean getIsEOF() {
      return isEOF;
   }
}