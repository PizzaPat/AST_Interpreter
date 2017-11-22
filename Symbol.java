package project3;

public class Symbol {
	
	private int id;
	private String name;
   private boolean isTerminal;
   private Token ref;
	
	public Symbol(int id, String name, boolean t) {
		this.id = id;
		this.name = name;
      isTerminal = t;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
   public boolean getIsTerminal() {
      return isTerminal;
   }
   
   public void setIsTerminal(boolean t) {
      isTerminal = t;
   }
   
   public void setRef(Token t) {
      ref = t;
   }
   
   public Token getRef() {
      return ref;
   }
}