package project3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parser {
   
   /**
    * Creates the LLtable by placing in the rule numbers in the appropriate slot.
    * 
    * @return two dimensional array of the LL table
    */
   public int[][] createLLTable() {
      int[][] LLTable = new int[50][50];
      LLTable[0][0] = 1;
      LLTable[1][1] = 2;
      LLTable[2][2] = 47;
      LLTable[2][3] = 3;
      LLTable[2][10] = 47;
      LLTable[2][12] = 47;
      LLTable[2][13] = 47;
      LLTable[2][26] = 47;
      LLTable[3][4] = 4;
      LLTable[4][2] = 48;
      LLTable[4][7] = 5;
      LLTable[4][8] = 5;
      LLTable[4][9] = 5;
      LLTable[4][26] = 48;
      LLTable[5][7] = 6;
      LLTable[5][8] = 6;
      LLTable[5][9] = 6;
      LLTable[6][7] = 7;
      LLTable[6][8] = 8;
      LLTable[6][9] = 9;
      LLTable[7][10] = 10;
      LLTable[8][2] = 46;
      LLTable[8][10] = 9;
      LLTable[8][12] = 9;
      LLTable[8][13] = 9;
      LLTable[8][26] = 46;
      LLTable[9][10] = 12;
      LLTable[9][12] = 13;
      LLTable[9][13] = 14;
      LLTable[10][10] = 15;
      LLTable[11][12] = 16;
      LLTable[12][13] = 17;
      LLTable[13][4] = 18;
      LLTable[14][4] = 19;
      LLTable[15][4] = 20;
      LLTable[15][7] = 20;
      LLTable[15][8] = 20;
      LLTable[15][9] = 20;
      LLTable[15][10] = 20;
      LLTable[16][2] = 49;
      LLTable[16][14] = 21;
      LLTable[16][26] = 49;
      LLTable[17][15] = 22;
      LLTable[17][16] = 22;
      LLTable[17][17] = 22;
      LLTable[17][18] = 22;
      LLTable[17][19] = 22;
      LLTable[17][20] = 22;
      LLTable[18][4] = 23;
      LLTable[18][7] = 23;
      LLTable[18][8] = 23;
      LLTable[18][9] = 23;
      LLTable[18][10] = 23;
      LLTable[19][21] = 24;
      LLTable[19][22] = 24;
      LLTable[20][4] = 25;
      LLTable[20][7] = 25;
      LLTable[20][8] = 25;
      LLTable[20][9] = 25;
      LLTable[20][10] = 25;
      LLTable[21][23] = 26;
      LLTable[21][24] = 26;
      LLTable[21][25] = 26;
      LLTable[22][4] = 27;
      LLTable[22][7] = 27;
      LLTable[22][8] = 27;
      LLTable[22][9] = 27;
      LLTable[22][10] = 27;
      LLTable[23][4] = 32;
      LLTable[23][7] = 28;
      LLTable[23][8] = 29;
      LLTable[23][9] = 30;
      LLTable[23][10] = 31;
      LLTable[24][0] = 33;
      LLTable[24][0] = 34;
      LLTable[24][0] = 36;
      LLTable[24][0] = 37;
      LLTable[24][0] = 35;
      LLTable[24][0] = 38;
      LLTable[25][19] = 39;
      LLTable[26][20] = 40;
      LLTable[27][21] = 41;
      LLTable[27][22] = 42;
      LLTable[28][23] = 43;
      LLTable[28][24] = 44;
      LLTable[28][25] = 45;
      
      return LLTable;
   }
   
   /**
    * Creates the column of non terminals for the LL table
    * 
    * @return array of symbols for non terminals
    */
   public Symbol[] createNonTerminalTable() {
      // declare arrays and two dimensional array for LL table
	  Symbol[] nonTerminals = new Symbol[50];
      nonTerminals[0] = new Symbol(0, "Pgm", false); 
      nonTerminals[1] = new Symbol(1, "BBlock", false); 
      nonTerminals[2] = new Symbol(2, "Vargroup", false); 
      nonTerminals[3] = new Symbol(3, "PPvarlist", false); 
      nonTerminals[4] = new Symbol(4, "Varlist", false); 
      nonTerminals[5] = new Symbol(5, "Vardecl", false); 
      nonTerminals[6] = new Symbol(6, "Basekind", false); 
      nonTerminals[7] = new Symbol(7, "Varid", false); 
      nonTerminals[8] = new Symbol(8, "Stmts", false); 
      nonTerminals[9] = new Symbol(9, "Stmt", false); 
      nonTerminals[10] = new Symbol(10, "Stasgn", false); 
      nonTerminals[11] = new Symbol(11, "Stprint", false); 
      nonTerminals[12] = new Symbol(12, "Stwhile", false); 
      nonTerminals[13] = new Symbol(13, "PPexprs", false); 
      nonTerminals[14] = new Symbol(14, "PPexpr1", false); 
      nonTerminals[15] = new Symbol(15, "Exprlist", false); 
      nonTerminals[16] = new Symbol(16, "Moreexprs", false); 
      nonTerminals[17] = new Symbol(17, "E", false); 
      nonTerminals[18] = new Symbol(18, "Expr", false); 
      nonTerminals[19] = new Symbol(19, "R", false); 
      nonTerminals[20] = new Symbol(20, "Rterm", false); 
      nonTerminals[21] = new Symbol(21, "T", false); 
      nonTerminals[22] = new Symbol(22, "Term", false); 
      nonTerminals[23] = new Symbol(23, "Fact", false); 
      nonTerminals[24] = new Symbol(24, "Oprel", false); 
      nonTerminals[25] = new Symbol(25, "Lthan", false); 
      nonTerminals[26] = new Symbol(26, "Gthan", false); 
      nonTerminals[27] = new Symbol(27, "Opadd", false); 
      nonTerminals[28] = new Symbol(28, "Opmul", false);

      return nonTerminals;
   }
   
   /**
    * Creates the row of terminals for the LL table
    * 
    * @return the array of symbols for terminals
    */
	public Symbol[] createTerminals(){
		Symbol[] terminals = new Symbol[28];
		terminals[0] = new Symbol(0, "kprog", true);
		terminals[1] = new Symbol(1, "{", true); // brace1
		terminals[2] = new Symbol(2, "}", true); // brace2
		terminals[3] = new Symbol(3, "kvars", true);
		terminals[4] = new Symbol(4, "(", true); // parens1
		terminals[5] = new Symbol(5, ")", true); // parens2
		terminals[6] = new Symbol(6, ";", true); // semi
		terminals[7] = new Symbol(7, "int", true);
		terminals[8] = new Symbol(8, "float", true);
		terminals[9] = new Symbol(9, "string", true);
		terminals[10] = new Symbol(10, "id", true);
		terminals[11] = new Symbol(11, "=", true); // equal
		terminals[12] = new Symbol(12, "kprint", true);
		terminals[13] = new Symbol(13, "kwhile", true);
		terminals[14] = new Symbol(14, "comma", true); // comma
		terminals[15] = new Symbol(15, "opeq", true);
		terminals[16] = new Symbol(16, "opne", true);
		terminals[17] = new Symbol(17, "ople", true);
		terminals[18] = new Symbol(18, "opge", true);
		terminals[19] = new Symbol(19, "angle1", true);
		terminals[20] = new Symbol(20, "angle2", true);
		terminals[21] = new Symbol(21, "+", true); // plus
		terminals[22] = new Symbol(22, "-", true); // -
		terminals[23] = new Symbol(23, "aster", true);
		terminals[24] = new Symbol(24, "slash", true);
		terminals[25] = new Symbol(25, "caret", true);
		terminals[26] = new Symbol(26, "eps", true);
		terminals[27] = new Symbol(27, "$", true);
		return terminals;
	}
   
    /**
     * Creates a map of terminals to their appropriate index in the LL table
     * 
     * @return the index of the terminal in the LL table
     */
    public Map<String, Integer> terminalToIndex() {
        Map<String, Integer> terminalMap = new HashMap<>();
        terminalMap.put("kprog", 0);
        terminalMap.put("{", 1); // brace1
        terminalMap.put("}", 2); // brace2
        terminalMap.put("kvars", 3);
        terminalMap.put("(", 4); // parens1
        terminalMap.put(")", 5); // parens2
        terminalMap.put(";", 6); // semi
        terminalMap.put("int", 7);
        terminalMap.put("float", 8);
        terminalMap.put("string", 9);
        terminalMap.put("id", 10);
        terminalMap.put("equal", 11);
        terminalMap.put("kprint", 12);
        terminalMap.put("kwhile", 13);
        terminalMap.put(",", 14); // comma
        terminalMap.put("opeq", 15);
        terminalMap.put("opne", 16);
        terminalMap.put("ople", 17);
        terminalMap.put("opge", 18);
        terminalMap.put("angle1", 19);
        terminalMap.put("angle2", 20);
        terminalMap.put("+", 21); // plus
        terminalMap.put("-", 22); // minus
        terminalMap.put("*", 23); // aster
        terminalMap.put("slash", 24);
        terminalMap.put("caret", 25);
        terminalMap.put("eps", 26);
        terminalMap.put("$", 27);
        return terminalMap;
    }
   
   /**
    * Creates a map that maps the rule number to it's RHS components
    * 
    * @param terminals the row of terminals in the LL table
    * @param nonTerminals the column of non terminals in the LL table
    * 
    * @return the map of rule numbers to its RHS components
    */
   public Map<Integer, Symbol[]> createGrammarArray(Symbol[] terminals, Symbol[] nonTerminals) {
      Map<Integer,Symbol[]> grammar = new HashMap<>();
      grammar.put(1, new Symbol[]{terminals[0],nonTerminals[1]}); // Pgm = kprog BBlock
      grammar.put(2, new Symbol[]{terminals[1], nonTerminals[2], nonTerminals[8], terminals[2]}); // Bblock = brace1 Vargroup stmts brace2
      grammar.put(3, new Symbol[]{terminals[3], nonTerminals[3]}); // Vargroup = kvars PPvarlist
      grammar.put(4, new Symbol[]{terminals[4], terminals[4], nonTerminals[5]}); // PPvarlist = parens1 Varlist parens2
      grammar.put(5, new Symbol[]{nonTerminals[5], terminals[6], nonTerminals[4]}); // Varlist = Vardecl semi Varlist
      grammar.put(6, new Symbol[]{nonTerminals[6], nonTerminals[7]}); // Vardecl = Basekind Varid 
      grammar.put(7, new Symbol[]{terminals[7]}); // Basekind = 'int' 
      grammar.put(8, new Symbol[]{terminals[8]}); // Basekind = 'float'
      grammar.put(9, new Symbol[]{terminals[9]}); // Basekind = 'string'
      grammar.put(10, new Symbol[]{terminals[10]}); // Varid = id
      grammar.put(11, new Symbol[]{nonTerminals[9], terminals[6], nonTerminals[8]}); // Stmts = Stmt semi Stmts
      grammar.put(12, new Symbol[]{nonTerminals[10]}); // Stmt = Stasgn
      grammar.put(13, new Symbol[]{nonTerminals[11]}); // Stmt = Stprint
      grammar.put(14, new Symbol[]{nonTerminals[12]}); // Stmt = Stwhile
      grammar.put(15, new Symbol[]{nonTerminals[7], terminals[11], nonTerminals[18]}); // Stasgn = Varid equal Expr
      grammar.put(16, new Symbol[]{terminals[12], nonTerminals[13]}); // Stprint = kprint PPexprs
      grammar.put(17, new Symbol[]{terminals[13], nonTerminals[14], nonTerminals[1]}); // Stwhile = kwhile PPexpr1 BBlock
      grammar.put(18, new Symbol[] {terminals[4], nonTerminals[15], terminals[5]}); // PPexpr = parens1 Exprlist parens2
      grammar.put(19, new Symbol[] {terminals[4], nonTerminals[18], terminals[5]}); // PPexpr1 = parens1 Expr parens2
      grammar.put(20, new Symbol[] {nonTerminals[18], nonTerminals[16]}); // Exprlist = Expr Moreexprs
      grammar.put(21, new Symbol[] {terminals[14], nonTerminals[15]}); // Moreexprs = comma Exprlist
      grammar.put(22, new Symbol[] {nonTerminals[18], nonTerminals[24], nonTerminals[20]}); // Expr = Expr Oprel Rterm
      grammar.put(23, new Symbol[] {nonTerminals[20]}); // Expr = Rterm
      grammar.put(24, new Symbol[] {nonTerminals[20], nonTerminals[27], nonTerminals[22]}); // Rterm = Rterm Opadd Term
      grammar.put(25, new Symbol[] {nonTerminals[22]}); // Rterm = Term
      grammar.put(26, new Symbol[] {nonTerminals[22], nonTerminals[28], nonTerminals[23]}); // Term = Term Opmul Fact
      grammar.put(27, new Symbol[] {nonTerminals[23]}); // Term = Fact
      grammar.put(28, new Symbol[] {terminals[7]}); // Fact = int
      grammar.put(29, new Symbol[] {terminals[8]}); // Fact = float
      grammar.put(30, new Symbol[] {terminals[9]}); // Fact = string
      grammar.put(31, new Symbol[] {nonTerminals[7]}); // Fact = Varid
      grammar.put(32, new Symbol[] {nonTerminals[14]}); // Fact = PPexpr1
      grammar.put(33, new Symbol[] {terminals[15]}); // Oprel = opeq
      grammar.put(34, new Symbol[] {terminals[16]}); // Oprel = opne
      grammar.put(35, new Symbol[] {nonTerminals[25]}); // Oprel = Lthan
      grammar.put(36, new Symbol[] {terminals[17]}); // Oprel = ople
      grammar.put(37, new Symbol[] {terminals[18]}); // Oprel = opge
      grammar.put(38, new Symbol[] {nonTerminals[26]}); // Oprel = Gthan
      grammar.put(39, new Symbol[] {terminals[19]}); // Lthan = angle1
      grammar.put(40, new Symbol[] {terminals[20]}); // Gthan = angle2
      grammar.put(41, new Symbol[] {terminals[21]}); // Opadd = plus
      grammar.put(42, new Symbol[] {terminals[22]}); // Opadd = minus
      grammar.put(43, new Symbol[] {terminals[23]}); // Opmul = aster
      grammar.put(44, new Symbol[] {terminals[24]}); // Opmul = slash
      grammar.put(45, new Symbol[] {terminals[25]}); // Opmul = caret
      grammar.put(46, new Symbol[] {terminals[26]}); // Stmts = eps
      grammar.put(47, new Symbol[] {terminals[26]}); // Vargroup = eps
      grammar.put(48, new Symbol[] {terminals[26]}); // Varlist = eps
      grammar.put(49, new Symbol[] {terminals[26]}); // Moreexprs = eps
      grammar.put(50, new Symbol[] {terminals[26]}); // E = eps
      grammar.put(51, new Symbol[] {terminals[26]}); // R = eps
      grammar.put(52, new Symbol[] {terminals[26]}); // T = eps
      return grammar;
   }
   
   /**
    * Creates a PST using the input from the Lexer, the LL table, and the
    * LL parse machine
    * 
    * @param input array of tokens from the Lexer
    */
   public void createPST(Token[] input) {
      
      // create terminal and non terminal array
      Symbol[] nonTerminals = createNonTerminalTable();
      Symbol[] terminals = createTerminals();
      
      // create LL table
	   int[][] LLTable = createLLTable();
      
      // create map to map the rule # to RHS strings
      Map<Integer,Symbol[]> grammar = createGrammarArray(terminals, nonTerminals);
      
      // The front, which holds nodes
      Stack<Node> front = new Stack<>();
      
      // Terminal map for tokens
      Map<String, Integer> tokenIndexMap = terminalToIndex();
      
      // TODO: CREATE TREE then link root node
      Node mRoot;
      // initialize input index
      int index = 0;
      
      /**
       * Create LL parse machine
       */
      
      // M0: SETUP, initialize stack with Nodes Pgm and $
      Node pgm = new Node(nonTerminals[0], false);
      mRoot = pgm;
      front.push(new Node(terminals[27], true)); // push $
      front.push(pgm); // push Pgm
 
      // loop until top $ == front $
      
      while (!(front.peek().getSymbol().getName().equals("$") 
               && input[index].getName().equals("$"))) {
         
         // UNIT TEST: Print each iteration
         printStack(front);
         printInput(input, index);
         System.out.println("top of stack: " + front.peek().getSymbol().getName());
         System.out.println("front of input: " + input[index].getName());
//         System.out.println("Is " + front.peek().getSymbol().getName() 
//          + " a Terminal? " + front.peek().getSymbol().getIsTerminal());
         
         // M1: if top == front, pop the stack, attach symbol and advance input array
         if (front.peek().getSymbol().getName().equals(input[index].getName())) {
            
            // unit testing, print if M1 is chosen
            System.out.println("M1");
            
            // pop the stack
            Node top = front.pop();
            
            // attach Symbol to Node
            top.setToken(input[index]);
            
            // advance input's index
            index++;   
         }

         // M2: if top is a terminal, ERROR
         else if (front.peek().getSymbol().getIsTerminal()) {
            System.out.println("M2 - ERROR. Top is a terminal.");
            return;
         }

         else {
            // Get the rule # from the LLtable
            int topIndex = front.peek().getSymbol().getId();
            //System.out.println("----->"+topIndex);
            System.out.println(input[index].getName());
            
            int frontIndex = tokenIndexMap.get(input[index].getName());
            System.out.println("--->"+frontIndex+"----"+topIndex);
            int rule = LLTable[topIndex][frontIndex];
            
            // UNIT TEST: M4 print out rule
            System.out.println("M4 - Rule: " + rule);
            
            // M3: If rule doesn't exist, ERROR
            if (rule == 0) {
               System.out.println("M3 - ERROR. No rule found.");
               return;
            }

            // M4: Pop stack, link LHS RHS nodes, and push reverse RHS to stack
            
            // pop stack and link LHS nodes to RHS nodes
            Node mom = front.pop();
            
            // create RHS Nodes and push to stack in reverse order
            Symbol[] RHSgrammar = grammar.get(rule);
            
            for (int i = RHSgrammar.length - 1; i >= 0; i--) {
               
               // create new kid
               Node kid = new Node(RHSgrammar[i], false);
               
               // add kid to mom
               mom.addKid(kid);
               
               // push kid to stack
               front.add(kid);
               
               // UNIT TESTING: check created node
               System.out.println(RHSgrammar[i].getName() + " CREATED");
               System.out.println(RHSgrammar[i].getName() + " ADDED TO " + mom.getSymbol().getName());
            }
         }
         
         // UNIT TEST: PRINT TREE
         System.out.println("TREE");
         printTree(mRoot, 0);
         System.out.println();

         //PAT TEST
         

      }
   }
   
   /**
    * unit testing functions to print out top, front, and current PST
    */
   public void printStack(Stack<Node> s) {
      
      System.out.print("Stack: ");
      for (Node n : s) {
         System.out.print(n.getSymbol().getName() + " ");
      }
      System.out.println();
   }
   
   public void printInput(Token[] input, int i) {
      System.out.print("Input: ");
      for (int k = i; k < input.length; k++) {
         if (input[k] == null){
            System.out.println();
            return;
         }
         System.out.print(input[k].getName() + " ");
      }
      System.out.println();
   }
   
   public void printTree(Node n, int level) {
      if (n == null) {
          return;
      }
      for (int i = 0; i < level; i++) {
        System.out.print("..");
      }
      System.out.println(n);
      Node[] kids = n.getKids();
      for (Node kid : kids) {
          printTree(kid, level + 1);
      }
   }
   
}