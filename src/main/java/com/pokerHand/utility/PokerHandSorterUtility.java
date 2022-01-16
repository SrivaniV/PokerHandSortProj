package com.pokerHand.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pokerHand.constants.Card;
import com.pokerHand.constants.Rank;
import com.pokerHand.constants.Suits;

public abstract class PokerHandSorterUtility {
	

	public static Card getHighCardFromCardsOfHand(List<String> handCardsList) {

		Card result = null;
		//the below condition will take each list elements character and verify if it matches with the given String in contains method.
		if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.A.toString()))) {
			//System.out.println(Card.A.getCardName());
			result = Card.A;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.K.toString()))) {
			//System.out.println(Card.K.getCardName());
			result = Card.K;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.Q.toString()))) {
			//System.out.println(Card.Q.getCardName());
			result = Card.Q;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.J.toString()))) {
			//System.out.println(Card.J.getCardName());
			result = Card.J;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.T.toString()))) {
			//System.out.println(Card.T);
			result = Card.T;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.NINE.getCardName()))) {
		//	System.out.println(Card.NINE);
			result = Card.NINE;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.EIGHT.getCardName()))) {
		//	System.out.println(Card.EIGHT);
			result = Card.EIGHT;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.SEVEN.getCardName()))) {
			//System.out.println(Card.SEVEN);
			result = Card.SEVEN;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.SIX.getCardName()))) {
			//System.out.println(Card.SIX);
			result = Card.SIX;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.FIVE.getCardName()))) {
			//System.out.println(Card.FIVE);
			result = Card.FIVE;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.FOUR.getCardName()))) {
			//System.out.println(Card.FOUR);
			result = Card.FOUR;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.THREE.getCardName()))) {
		//	System.out.println(Card.THREE);
			result = Card.THREE;
		}else if(handCardsList.stream().anyMatch(n -> n.toString().contains(Card.TWO.getCardName()))) {
			//System.out.println(Card.TWO);
			result = Card.TWO;

		}


		return result;
	}

	public static Map<Character, Long> countOfDuplicateCards(List<String> handCardsList){

		//We are iterating over the list, putting the element as the Map key, and all its occurrences in the Map value.
		Map<Character, Long> elementCountMap =
				handCardsList.stream().map(n ->n.charAt(0)).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));


		return elementCountMap;
	}

	public static Map<Rank,List<Character>> checkIfItIsAPairOrTwo( Map<Character, Long> elementCountMap ) {
		Map<Rank,List<Character>> result = null;

		List<Character> cardLst = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 2)       // if map value == 2, means a pair of card exists 
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if(cardLst !=null && !cardLst.isEmpty()) {
			result = new HashMap<Rank, List<Character>>();
			if(cardLst.size()==1) {
				result.put(Rank.PAIR,cardLst) ;
			}else if(cardLst.size() == 2) {
				result.put(Rank.TWO_PAIRS,cardLst) ;
			}
		}

		return result;
	}

	public static Map<Rank,List<Character>> checkIfItIsThreeOfAKind( Map<Character, Long> elementCountMap ) {
		Map<Rank,List<Character>> result = null;

		List<Character> cardLst = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 3)       // if map value == 3, means a Three cards with the same cardName exists
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if(cardLst !=null && !cardLst.isEmpty()) {
			result = new HashMap<Rank,List<Character>>();

			result.put(Rank.THREE_OF_A_KIND,cardLst) ;

		}

		return result;
	}

	public static Map<Rank,List<Character>> checkIfItIsFourOfAKind( Map<Character, Long> elementCountMap ) {
		Map<Rank,List<Character>> result = null;

		List<Character> cardLst = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 4)       // if map value == 3, means a Four cards with the same cardName exists
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if(cardLst !=null && !cardLst.isEmpty()) {
			result = new HashMap<Rank,List<Character>>();

			result.put(Rank.FOUR_OF_A_KIND,cardLst) ;

		}

		return result;
	}

	public static Map<Rank,List<Character>> checkIfItIsFullHouse( Map<Character, Long> elementCountMap ) {
		Map<Rank,List<Character>> result = null;


		List<Character> cardLst1 = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 3)       // if map value == 3, means a Three cards with the same cardName exists
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		List<Character> cardLst2 = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 2)       // if map value == 2, means a pair of card exists 
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if ((cardLst1 != null  && !cardLst1.isEmpty() ) && (cardLst2 != null  && !cardLst2.isEmpty() )) {
			result = new HashMap<Rank,List<Character>>();
			for(int i=0; i<cardLst2.size();i++) {
				cardLst1.add(cardLst2.get(i));
			}
			result.put(Rank.FULL_HOUSE,cardLst1) ;

		}

		return result;
	}

	public static  Map<Rank,List<Character>> checkIfItIsRoyalFlush(List<String> handCardsList) {
		Map<Rank,List<Character>> result = null;


		Map<Character, Long> elementCountMap =	 handCardsList.stream().map(n ->n.charAt(1)).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

		List<Character> cardLst = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 5)       // if map value == 5, means a Five cards with the same suit exists
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if(((handCardsList.stream().anyMatch(n -> n.toString().contains(Card.A.toString())))
				&& (handCardsList.stream().anyMatch(n -> n.toString().contains(Card.K.toString())))
				&& (handCardsList.stream().anyMatch(n -> n.toString().contains(Card.Q.toString())))
				&& (handCardsList.stream().anyMatch(n -> n.toString().contains(Card.J.toString())))
				&& (handCardsList.stream().anyMatch(n -> n.toString().contains(Card.T.toString()))))
				&& (cardLst != null  && !cardLst.isEmpty() ) ) {

			result = new HashMap<Rank,List<Character>>();
			result.put( Rank.ROYAL_FLUSH,cardLst) ;
		}
		return result;

	}

	public static  Map<Rank,List<Character>> checkIfItIsFlush(List<String> handCardsList) {
		Map<Rank,List<Character>> result = null;


		Map<Character, Long> elementCountMap =	 handCardsList.stream().map(n ->n.charAt(1)).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

		List<Character> suitLst = elementCountMap.entrySet().stream()                 // Map -> Stream
				.filter(m -> m.getValue() == 5)       // if map value == 5, means a Five cards with the same suit exists
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		if(suitLst != null  && !suitLst.isEmpty()  ) {

			result = new HashMap<Rank,List<Character>>();
			result.put( Rank.FLUSH,suitLst) ;
		}
		return result;

	}

	public static Map<Rank,List<Card>> checkIfItIsStraight( Map<Character, Long> elementCountMap ) {

		Map<Rank,List<Card>> result=  null;
		List<Integer> straightList =  new ArrayList<Integer>();
		List<Card> cardLst = new ArrayList<Card>(); 
		//check if map consists of ten,jack, queen, king and Ace if so replace their characters with respective numbers and then 
		if(elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.A.toString()))) {
			straightList.add(14);
			cardLst.add(Card.A);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.K.toString()))) {
			straightList.add(13);
			cardLst.add(Card.K);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.Q.toString()))) {
			straightList.add(12);
			cardLst.add(Card.Q);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.J.toString()))) {
			straightList.add(11);
			cardLst.add(Card.J);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.T.toString()))) {
			straightList.add(10);
			cardLst.add(Card.T);
		}
		if(elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.NINE.getCardName()))) {
			straightList.add(9);
			cardLst.add(Card.NINE);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.EIGHT.getCardName()))) {
			straightList.add(8);
			cardLst.add(Card.EIGHT);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.SEVEN.getCardName()))) {
			straightList.add(7);
			cardLst.add(Card.SEVEN);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.SIX.getCardName()))) {
			straightList.add(6);
			cardLst.add(Card.SIX);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.FIVE.getCardName()))) {
			straightList.add(5);
			cardLst.add(Card.FIVE);
		}
		if(elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.FOUR.getCardName()))) {
			straightList.add(4);
			cardLst.add(Card.FOUR);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.THREE.getCardName()))) {
			straightList.add(3);
			cardLst.add(Card.THREE);
		}
		if( elementCountMap.entrySet().stream().anyMatch(n -> n.toString().contains(Card.TWO.getCardName()))) {
			straightList.add(2);
			cardLst.add(Card.TWO);
		}
		
		straightList = straightList.stream().distinct().collect(Collectors.toList());
		
		if(straightList.size() == 5) {
			
			int minNum = getMinNumInList(straightList, 5);
			int maxNum = getMaxNumInList(straightList, 5);
			
			if((maxNum - minNum +1 == 5) ) {
				boolean flag = false;
				for(int i = 0; i<5; i++) {
					if((straightList.get(i) != minNum) && (straightList.get(i) != maxNum) && (straightList.get(i) > minNum && straightList.get(i) < maxNum)) {
						flag = true;
					}else {
						flag = false;
					}
					
				}
				
				if(flag == true) {
					result = new HashMap<Rank,List<Card>>();
					result.put( Rank.STRAIGHT,cardLst) ;
					
				}
			}
		}
		
		return result;
		
		
	}
	
	public static int getMinNumInList(List<Integer> straightList, int totalNumbers)
    {
        int minNum = straightList.get(0);
        for (int i = 1; i < totalNumbers; i++)
        {
            if (straightList.get(i) < minNum)
            	minNum = straightList.get(i);
        }
        return minNum;
    }
	
	public static int getMaxNumInList(List<Integer> straightList, int totalNumbers)
    {
        int maxNum = straightList.get(0);
        for (int i = 1; i < totalNumbers; i++)
        {
            if (straightList.get(i) > maxNum)
            	maxNum = straightList.get(i);
        }
        return maxNum;
    }

	public static Map<Rank,List<Character>> checkIfItIsStraightFlush(List<String> handCardsList) {

		 Map<Rank,List<Character>> result = null;
		
		Map<Character, Long> cardsList =	 handCardsList.stream().map(n ->n.charAt(0)).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		
		Map<Rank,List<Card>> isStraightCardLstMap  = checkIfItIsStraight(cardsList);
		Map<Rank,List<Character>> isFLush   = checkIfItIsFlush(handCardsList);
		
		if((isStraightCardLstMap != null) && (isFLush != null)) {
			List<Character> resultCharacter = isStraightCardLstMap.get(Rank.STRAIGHT).stream().map(m -> m.toString().charAt(0)).collect(Collectors.toList());
			resultCharacter.add(isFLush.get(Rank.FLUSH).get(0));
			result = new HashMap<Rank,List<Character>>();
			result.put( Rank.STRAIGHT_FLUSH,resultCharacter) ;
		}
		
		return result;
	}
	
	public static Rank rank(Map<Rank,List<Character>> resultLst){
		List<Rank> resultRank =  resultLst.keySet().stream().map(m -> m).collect(Collectors.toList());
		Rank resultedRank  = null;
		   if(resultRank != null) {
			   for(Rank rr: resultRank) {
				   resultedRank = rr;
			   }
		   }
		   return resultedRank;
	}
	public static Rank rankForCardLst(Map<Rank,List<Card>> resultLst){
		List<Rank> resultRank =  resultLst.keySet().stream().map(m -> m).collect(Collectors.toList());
		Rank resultedRank  = null;
		   if(resultRank != null) {
			   for(Rank rr: resultRank) {
				   resultedRank = rr;
			   }
		   }
		   return resultedRank;
	}

	public static List<Card> displayResult(Map<Rank,List<Character>> resultLst, Rank resultedRank,String player) {
		  
		List<Character> charLst =  resultLst.get(resultedRank).stream().collect(Collectors.toList());
		List<Card> cardLst = null;
		if(charLst != null) {
			cardLst= new ArrayList<Card>();  
			for(Character c : charLst){
				if(c.equals("2".charAt(0))) {
					cardLst.add(Card.TWO);
				}else if(c.equals("3".charAt(0))) {
					cardLst.add(Card.THREE);
				}else if(c.equals("4".charAt(0))) {
					cardLst.add(Card.FOUR);
				}else if(c.equals("5".charAt(0))) {
					cardLst.add(Card.FIVE);
				}else if(c.equals("6".charAt(0))) {
					cardLst.add(Card.SIX);
				}else if(c.equals("7".charAt(0))) {
					cardLst.add(Card.SEVEN);
				}else if(c.equals("8".charAt(0))) {
					cardLst.add(Card.EIGHT);
				}else if(c.equals("9".charAt(0))) {
					cardLst.add(Card.NINE);
				}else if(c.equals("T".charAt(0))) {
					cardLst.add(Card.T);
				}else if(c.equals("J".charAt(0))) {
					cardLst.add(Card.J);
				}else if(c.equals("Q".charAt(0))) {
					cardLst.add(Card.Q);
				}else if(c.equals("K".charAt(0))) {
					cardLst.add(Card.K);
				}else if(c.equals("A".charAt(0))) {
					cardLst.add(Card.A);
				}
				
			}
		}
		
	//	System.out.println(player +": "+resultedRank +" of "+cardLst.toString());
		
		return cardLst;
	}
	
	public static List<Card> displayResultWithCardLst(Map<Rank,List<Card>> resultLst,  Rank resultedRank,String player) {
		  
		List<Card> cardLst =  resultLst.get(resultedRank);
		
		//System.out.println(player +": "+resultedRank +" of "+cardLst.toString()); 
		return cardLst;
	}
	
	public static Suits displayResultOfFlush(Map<Rank,List<Character>> resultLst,Rank resultedRank, String player) {
		  
		Character suit =  resultLst.get(resultedRank).get(0);
		
		//System.out.println(player +": "+resultedRank +" of "+Suits.valueOf(suit.toString()));
		
		return Suits.valueOf(suit.toString());
	}
	
	public static List<Card> cardsFromHandCharacters(List<String> handCharacters){
		
		List<Card> cardLst =  handCharacters.stream().map(n ->n.charAt(0)).collect(Collectors.toList()).stream().map(m -> Card.valueOf(m.toString())).collect(Collectors.toList());
		
		return cardLst;
	}
	
	
}
