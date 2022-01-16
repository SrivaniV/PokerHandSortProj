package com.pokerHand.constants;

public enum Rank {
	HIGH_CARD(1, "HIGH CARD"), 
	PAIR(2, "PAIR"), 
	TWO_PAIRS(3, "TWO PAIRS"), 
	THREE_OF_A_KIND(4, "THREE OF A KIND"), 
	STRAIGHT(5,	"STRAIGHT"), 
	FLUSH(6, "FLUSH"), 
	FULL_HOUSE(7, "FULL HOUSE"), 
	FOUR_OF_A_KIND(	8, "FOUR OF A KIND"), 
	STRAIGHT_FLUSH(9, "STRAIGHT FLUSH"), 
	ROYAL_FLUSH(10, "ROYAL FLUSH");

	private int rankCode;
	private String rankDesc;
	
	private Rank(int rankCode, String rankDesc) {
		this.rankCode = rankCode;
		this.rankDesc = rankDesc;
	}

	public int getRankCode() {
		return rankCode;
	}

	public String getRankDesc() {
		return rankDesc;
	}	

}
