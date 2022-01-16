package com.pokerHand.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.pokerHand.constants.Card;
import com.pokerHand.constants.Rank;
import com.pokerHand.constants.Suits;
import com.pokerHand.utility.PokerHandSorterUtility;

public class PokerHandSorterMin {

	
	public static void main(String[] args) throws FileNotFoundException {
		Integer player1WinCount = 0;
		Integer player2WinCount = 0;
		 PokerHandSorterMin instance 
         = new PokerHandSorterMin();

     InputStream inputStream = instance.getFileAsIOStream("poker-hands.txt");
		// File text = new File("C:\\Users\\vajji\\eclipse-workspace\\PokerHandSorter\\src\\com\\pokerHand\\resources\\poker-hands.txt");
				
    
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(inputStream);
     
        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
          //  System.out.println("line " + lineNumber + " :" + line);
              



		//Scanner line  = new Scanner(System.in);
		
		
		List<Card> player1ResultedListOfCards = null;
		List<Card> player2ResultedListOfCards = null;
		
		Rank player1Rank = null;  
		Rank player2Rank = null;
		Suits player1ResultedFlushSuit = null;
		Suits player2ResultedFlushSuit = null;

		StringTokenizer  s = new StringTokenizer(line," ");

		List<String> playerHand1 = new ArrayList<String>(); 
		List<String> playerHand2 = new ArrayList<String>();

		for(int i=0;i<10 && s.hasMoreTokens();i++) {

			if(i<5) {
				playerHand1.add(s.nextToken());
			}else if(i>=5) {
				playerHand2.add(s.nextToken());
			}
		}
		//System.out.println("PlayerHand1:"+playerHand1.toString() +", PlayerHand2:"+playerHand2.toString());

		//High Card of player1
		Card highCardResultPlayer1 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand1);
		if( highCardResultPlayer1 != null) {
			player1Rank  = Rank.HIGH_CARD;
		//	System.out.println("High card of Player1:"+highCardResultPlayer1);
		}
		Card highCardResultPlayer2 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand2);
		if(highCardResultPlayer2 !=null) {
			player2Rank  = Rank.HIGH_CARD;
			//System.out.println("High card of Player2:"+highCardResultPlayer2);
		}

		Map<Character, Long> player1CardsList = PokerHandSorterUtility.countOfDuplicateCards(playerHand1);
				

		//System.out.println("Cards in the player1 hand and their count:"+player1CardsList.toString());

		Map<Character, Long> player2CardsList = PokerHandSorterUtility.countOfDuplicateCards(playerHand2);
				

		//System.out.println("Cards in the player2 hand and their count:"+player2CardsList.toString());

		//Player1 : A Pair or Two Pair
		Map<Rank,List<Character>> pairOrTwoPairResultPlayer1 = PokerHandSorterUtility.checkIfItIsAPairOrTwo(player1CardsList);
		if(pairOrTwoPairResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rank(pairOrTwoPairResultPlayer1);
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResult(pairOrTwoPairResultPlayer1,player1Rank, "Player1");
			
		}

		//Player2: A Pair or Two Pair
		Map<Rank,List<Character>> pairOrTwoPairResultPlayer2 = PokerHandSorterUtility.checkIfItIsAPairOrTwo(player2CardsList);
		if(pairOrTwoPairResultPlayer2 != null) {
			player2Rank =  PokerHandSorterUtility.rank(pairOrTwoPairResultPlayer2);
			player2ResultedListOfCards = PokerHandSorterUtility.displayResult(pairOrTwoPairResultPlayer2,player2Rank, "Player2");
			 
		}

		//Player1: Three of a Kind
		Map<Rank,List<Character>> threeOfAKindResultPlayer1 = PokerHandSorterUtility.checkIfItIsThreeOfAKind(player1CardsList);
		if(threeOfAKindResultPlayer1 != null) {
			player1Rank =  PokerHandSorterUtility.rank(threeOfAKindResultPlayer1);
			player1ResultedListOfCards = PokerHandSorterUtility.displayResult(threeOfAKindResultPlayer1,player1Rank, "Player1");
			 
		}

		//Player2: Three of a Kind
		Map<Rank,List<Character>> threeOfAKindResultPlayer2 = PokerHandSorterUtility.checkIfItIsThreeOfAKind(player2CardsList);
		if(threeOfAKindResultPlayer2 != null) {
			player2Rank =  PokerHandSorterUtility.rank(threeOfAKindResultPlayer2);
			player2ResultedListOfCards = PokerHandSorterUtility.displayResult(threeOfAKindResultPlayer2,player2Rank, "Player2");
			 
		}

		//Player1: Four of a Kind
		Map<Rank,List<Character>> fourOfAKindResultPlayer1 = PokerHandSorterUtility.checkIfItIsFourOfAKind(player1CardsList);
		if(fourOfAKindResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rank(fourOfAKindResultPlayer1);
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResult(fourOfAKindResultPlayer1,player1Rank, "Player1");
			
		}

		//Player2: Four of a Kind
		Map<Rank,List<Character>> fourOfAKindResultPlayer2 = PokerHandSorterUtility.checkIfItIsFourOfAKind(player2CardsList);
		if(fourOfAKindResultPlayer2 != null) {
			 player2Rank =  PokerHandSorterUtility.rank(fourOfAKindResultPlayer2);
			 player2ResultedListOfCards = PokerHandSorterUtility.displayResult(fourOfAKindResultPlayer2,player2Rank, "Player2"); 
		}

		//Player1: Full House
		Map<Rank,List<Character>> fullHouseResultPlayer1 = PokerHandSorterUtility.checkIfItIsFullHouse(player1CardsList);
		if(fullHouseResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rank(fullHouseResultPlayer1);	
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResult(fullHouseResultPlayer1,player1Rank, "Player1"); 
			
		}

		//Player2: Full House
		Map<Rank,List<Character>> fullHouseResultPlayer2 = PokerHandSorterUtility.checkIfItIsFullHouse(player2CardsList);
		if(fullHouseResultPlayer2 != null) {
			 player2Rank =  PokerHandSorterUtility.rank(fullHouseResultPlayer2);
			 player2ResultedListOfCards = PokerHandSorterUtility.displayResult(fullHouseResultPlayer2,player2Rank, "Player2"); 	
		}


		//Player1: Royal FLush
		Map<Rank,List<Character>> royalFlushResultPlayer1 =  PokerHandSorterUtility.checkIfItIsRoyalFlush(playerHand1);
		if(royalFlushResultPlayer1 != null ) {
			 player1Rank =  PokerHandSorterUtility.rank(royalFlushResultPlayer1);
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResult(royalFlushResultPlayer1,player1Rank, "Player1"); 
			
		}

		//Player2: Royal FLush
		Map<Rank,List<Character>> royalFlushResultPlayer2 =  PokerHandSorterUtility.checkIfItIsRoyalFlush(playerHand2);
		if(royalFlushResultPlayer2 != null ) {
			 player2Rank =  PokerHandSorterUtility.rank(royalFlushResultPlayer2);
			 player2ResultedListOfCards = PokerHandSorterUtility.displayResult(royalFlushResultPlayer2,player2Rank, "Player2"); 
		}

		//Player1: Flush
		Map<Rank,List<Character>> flushResultPlayer1 =PokerHandSorterUtility.checkIfItIsFlush(playerHand1);
		if(flushResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rank(flushResultPlayer1);
			 player1ResultedFlushSuit = PokerHandSorterUtility.displayResultOfFlush(flushResultPlayer1,player1Rank, "Player1"); 
			player1ResultedListOfCards = PokerHandSorterUtility.cardsFromHandCharacters(playerHand1);
			
		}

		//Player2: Flush
		Map<Rank,List<Character>> flushResultPlayer2 =PokerHandSorterUtility.checkIfItIsFlush(playerHand2);
		if(flushResultPlayer2 != null) {
			 player2Rank =  PokerHandSorterUtility.rank(flushResultPlayer2);
			 player2ResultedFlushSuit = PokerHandSorterUtility.displayResultOfFlush(flushResultPlayer2,player2Rank, "Player2"); 
			player2ResultedListOfCards = PokerHandSorterUtility.cardsFromHandCharacters(playerHand2);
		}
	
		//Player1:  Straight
		Map<Rank,List<Card>> straightResultPlayer1 = PokerHandSorterUtility.checkIfItIsStraight(player1CardsList);
		if(straightResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rankForCardLst(straightResultPlayer1);
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResultWithCardLst(straightResultPlayer1,player1Rank, "Player1");
		
			
		}

		//Player2: Straight
		Map<Rank,List<Card>> straightResultPlayer2 = PokerHandSorterUtility.checkIfItIsStraight(player2CardsList);
		if(straightResultPlayer2 != null) {
			 player2Rank =  PokerHandSorterUtility.rankForCardLst(straightResultPlayer2);
			 player2ResultedListOfCards = PokerHandSorterUtility.displayResultWithCardLst(straightResultPlayer2,player2Rank, "Player2");
		}

		//Player1: Straight Flush
		Map<Rank,List<Character>> straightFlushResultPlayer1 =PokerHandSorterUtility.checkIfItIsStraightFlush(playerHand1);
		if(straightFlushResultPlayer1 != null) {
			 player1Rank =  PokerHandSorterUtility.rank(straightFlushResultPlayer1);
			 player1ResultedListOfCards = PokerHandSorterUtility.displayResult(straightFlushResultPlayer1,player1Rank, "Player1"); 	
			 player1ResultedFlushSuit = PokerHandSorterUtility.displayResultOfFlush(straightFlushResultPlayer1,player1Rank, "Player1"); 
		}

		//Player2: Straight Flush
		Map<Rank,List<Character>> straightFlushResultPlayer2 =PokerHandSorterUtility.checkIfItIsStraightFlush(playerHand2);
		if(straightFlushResultPlayer2 != null) {
			 player2Rank =  PokerHandSorterUtility.rank(straightFlushResultPlayer2);
			 player2ResultedListOfCards = PokerHandSorterUtility.displayResult(straightFlushResultPlayer2,player2Rank, "Player2"); 
			 player2ResultedFlushSuit = PokerHandSorterUtility.displayResultOfFlush(straightFlushResultPlayer2,player2Rank, "Player2"); 
		}
		
		//Code to decide the winner
		if(player1Rank.getRankCode() > player2Rank.getRankCode()) {
			 player1WinCount = player1WinCount + 1;
		}else if(player2Rank.getRankCode() > player1Rank.getRankCode()) {
			 player2WinCount = player2WinCount + 1;
		}else if(player1Rank.getRankCode() == player2Rank.getRankCode()) {
			if(highCardResultPlayer1.getCardValue() > highCardResultPlayer2.getCardValue()) {
				 player1WinCount = player1WinCount + 1;
			}else if(highCardResultPlayer1.getCardValue() < highCardResultPlayer2.getCardValue()) {
				 player2WinCount = player2WinCount + 1;
			}else if(highCardResultPlayer1.getCardValue() == highCardResultPlayer2.getCardValue()) {
				for(int i= 0; i < playerHand1.size() ; i++) {
					playerHand1.get(i).equals(highCardResultPlayer1.getCardName());
					playerHand1.remove(i);
				}
				Card nextHighCardResultPlayer1 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand1);
				if( nextHighCardResultPlayer1 != null) {
					player1Rank  = Rank.HIGH_CARD;
				
				}
				for(int i= 0; i < playerHand2.size() ; i++) {
					playerHand2.get(i).equals(highCardResultPlayer2.getCardName());
					playerHand2.remove(i);
				}
				Card nextHighCardResultPlayer2 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand2);
				if(nextHighCardResultPlayer2 !=null) {
					player2Rank  = Rank.HIGH_CARD;
					
				}
				
				if(nextHighCardResultPlayer1.getCardValue() > nextHighCardResultPlayer2.getCardValue()) {
					 player1WinCount = player1WinCount + 1;
				}else if(nextHighCardResultPlayer1.getCardValue() < nextHighCardResultPlayer2.getCardValue()) {
				 player2WinCount = player2WinCount + 1;
				}else if(nextHighCardResultPlayer1.getCardValue() ==  nextHighCardResultPlayer2.getCardValue()) {

					for(int i= 0; i < playerHand1.size() ; i++) {
						playerHand1.get(i).equals(nextHighCardResultPlayer1.getCardName());
						playerHand1.remove(i);
					}
					Card nextSecHighCardResultPlayer1 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand1);
					if( nextSecHighCardResultPlayer1 != null) {
						player1Rank  = Rank.HIGH_CARD;
					
					}
					for(int i= 0; i < playerHand2.size() ; i++) {
						playerHand2.get(i).equals(nextHighCardResultPlayer2.getCardName());
						playerHand2.remove(i);
					}
					Card nextSecHighCardResultPlayer2 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand2);
					if(nextSecHighCardResultPlayer2 !=null) {
						player2Rank  = Rank.HIGH_CARD;
						
					}
					
					if(nextSecHighCardResultPlayer1.getCardValue() > nextSecHighCardResultPlayer2.getCardValue()) {
						 player1WinCount = player1WinCount + 1;
					}else if(nextSecHighCardResultPlayer1.getCardValue() < nextSecHighCardResultPlayer2.getCardValue()) {
					 player2WinCount = player2WinCount + 1;
					}else if(nextSecHighCardResultPlayer1.getCardValue() ==  nextSecHighCardResultPlayer2.getCardValue()) {

						for(int i= 0; i < playerHand1.size() ; i++) {
							playerHand1.get(i).equals(nextSecHighCardResultPlayer1.getCardName());
							playerHand1.remove(i);
						}
						Card nextThirdHighCardResultPlayer1 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand1);
						if( nextThirdHighCardResultPlayer1 != null) {
							player1Rank  = Rank.HIGH_CARD;
						
						}
						for(int i= 0; i < playerHand2.size() ; i++) {
							playerHand2.get(i).equals(nextSecHighCardResultPlayer2.getCardName());
							playerHand2.remove(i);
						}
						Card nextThirdHighCardResultPlayer2 = PokerHandSorterUtility.getHighCardFromCardsOfHand(playerHand2);
						if(nextThirdHighCardResultPlayer2 !=null) {
							player2Rank  = Rank.HIGH_CARD;
							
						}
						
						if(nextThirdHighCardResultPlayer1.getCardValue() > nextThirdHighCardResultPlayer2.getCardValue()) {
							 player1WinCount = player1WinCount + 1;
						}else if(nextThirdHighCardResultPlayer1.getCardValue() < nextThirdHighCardResultPlayer2.getCardValue()) {
						 player2WinCount = player2WinCount + 1;
						}else if(nextThirdHighCardResultPlayer1.getCardValue() ==  nextThirdHighCardResultPlayer2.getCardValue()) {
							 //player1WinCount = player1WinCount + 1;
							 //player2WinCount = player2WinCount + 1;
							}
					
						}
				
					}
			}
			}
		
		lineNumber++;
        }    
		System.out.println("Player 1: "+player1WinCount+" hands" );
		System.out.println("Player 2: "+player2WinCount+" hands" );

	}

	  private InputStream getFileAsIOStream(final String fileName) 
	    {
	        InputStream ioStream = this.getClass()
	            .getClassLoader()
	            .getResourceAsStream(fileName);
	        
	        if (ioStream == null) {
	            throw new IllegalArgumentException(fileName + " is not found");
	        }
	        return ioStream;
	    }


}
