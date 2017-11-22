package project3;

import java.util.*;

public class Token{
	private int id;
	private String name;
	private String type;
	public Token(int id, String name, String type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getType(){
		return this.type;
	}

}