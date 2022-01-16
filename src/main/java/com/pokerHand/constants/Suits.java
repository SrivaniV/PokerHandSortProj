package com.pokerHand.constants;

public enum Suits {

	DIAMONDS("D","Diamonds"),
	HEARTS("H","Hearts"),
	SPADES("S","Spades"),
	CLUBS("C","Clubs");
	
	private String suitCode;
	private String suitDesc;
	
	private Suits(String suitCode, String suitDesc) {
		this.suitCode = suitCode;
		this.suitDesc = suitDesc;
	}
	public String getSuitCode() {
		return suitCode;
	}
	public String getSuitDesc() {
		return suitDesc;
	}
	
	
}
