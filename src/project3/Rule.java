package project3;

public class Rule {
	
	private Token LHS;
	private Token[] RHS;
   int id;
   
   public Rule(Token lhs, Token[] rhs, int id) {
      LHS = lhs;
      RHS = rhs;
      this.id = id;
   }
	
}