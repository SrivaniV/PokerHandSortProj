package com.pokerHand.constants;

public enum Card {

	TWO("2",2),
	THREE("3",3),
	FOUR("4",4),
	FIVE("5",5),
	SIX("6",6),
	SEVEN("7",7),
	EIGHT("8",8),
	NINE("9",9),
	T("T",10),
	J("J",11),
	Q("Q",12),
	K("K",13),
	A("A",14);

	private String cardName;
	private Integer cardValue;

	public String getCardName() {
		return cardName;
	}

	public Integer getCardValue() {
		return cardValue;
	}


	Card(String cardName, Integer cardValue) { 
		this.cardName = cardName;
		this.cardValue = cardValue; }

	

}
