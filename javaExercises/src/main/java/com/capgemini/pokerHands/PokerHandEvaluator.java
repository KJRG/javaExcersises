package com.capgemini.pokerHands;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PokerHandEvaluator {
	public static int findWinner(List<Card> handP1, List<Card> handP2) {
		
		// ranks of players
		int rankP1 = 0,
			rankP2 = 0;
		
		// create histograms for hands of both players
		// key is the value of card, value is the quantity of this card in the hand of player
		Map<Integer, Integer>	histogramP1 = createHistogram(handP1),
								histogramP2 = createHistogram(handP2);
		
		// sort the histograms descending: first by quantity, then by the value of card
		TreeSet<ValueThenKeyComparator>	sortedHistogramP1 = new TreeSet<ValueThenKeyComparator>(Collections.reverseOrder()),
										sortedHistogramP2 = new TreeSet<ValueThenKeyComparator>(Collections.reverseOrder());
		
		for(Integer key : histogramP1.keySet()) {
			sortedHistogramP1.add(new ValueThenKeyComparator(key, histogramP1.get(key)));
		}

		for(Integer key : histogramP2.keySet()) {
			sortedHistogramP2.add(new ValueThenKeyComparator(key, histogramP2.get(key)));
		}
		
		rankP1 = getHandRank(sortedHistogramP1, handP1);
		rankP2 = getHandRank(sortedHistogramP2, handP2);
		
		// evaluate the histograms and return winner (1 for player 1, 2 for player 2) or draw (0)
		if(rankP1 > rankP2 || (rankP1 == rankP2 && HigherCard(sortedHistogramP1, sortedHistogramP2) == 1)) {
			return 1;
		}
				
		return 0;
	}
		
	static Map<Integer, Integer> createHistogram(List<Card> hand) {
		Map<Integer, Integer> histogram = new HashMap<Integer, Integer>();
		Integer cardValue	= 0,
				quantity	= 0;
		
		for(Card c : hand) {
			cardValue = c.getValue();
			
			if(histogram.containsKey(cardValue)) {
				quantity = histogram.get(cardValue);
				histogram.put(cardValue, quantity + 1);
				continue;
			}
			
			histogram.put(cardValue, 1);
		}
		
		return histogram;
	}
	
	static int getHandRank(TreeSet<ValueThenKeyComparator> sortedHistogram, List<Card> hand) {
		
		int rank = 0;
		boolean isFlush = true;
		char color;
		
		// Convert tree set to array
		ValueThenKeyComparator[] hArray = sortedHistogram.toArray(new ValueThenKeyComparator[sortedHistogram.size()]);
		
		// Evaluate the hand
		
		switch(hArray[0].getValue()) {
		case 1:
			
			// Hand: (1, 1, 1, 1, 1)
			// The histogram is sorted - to check if there is a straight, it's enough to check the result of highest_card - lowest_card - if it's 4, it's straight, otherwise it's high card
			
			if(hArray[0].getKey() - hArray[4].getKey() == 4) {
				
				// straight or royal straight
				rank = Rank.STRAIGHT.getValue();
				break;
			}
			
			rank = Rank.HIGH_CARD.getValue();
			break;
			
		case 2:

			if(hArray[1].getValue() == 1) {
				
				// Hand: (2, 1, 1, 1)
				rank = Rank.ONE_PAIR.getValue();
				break;
			}
			
			// Hand: (2, 2, 1)
			rank = Rank.TWO_PAIRS.getValue();
			break;
			
			
		case 3:
			
			if(hArray[1].getValue() == 1) {
				
				// Hand: (3, 1, 1)
				rank = Rank.THREE.getValue();
				break;
			}
			
			// Hand: (3, 2)
			rank = Rank.FULL_HOUSE.getValue();
			break;
			
		case 4:
			
			// Hand: (4, 1)
			rank = Rank.FOUR.getValue();
			break;
		}
		
		// Check if there's flush or not
		
		color = hand.get(0).getSuit();
		
		for(int i = 1; i < hand.size(); i++) {
			if(hand.get(i).getSuit() != color) {
				isFlush = false;
				break;
			}
		}
		
		if(isFlush) {
			if(rank < Rank.STRAIGHT.getValue()) {
				rank = Rank.FLUSH.getValue();
				return rank;
			}
			
			if(rank == Rank.STRAIGHT.getValue()) {
				rank = Rank.STRAIGHT_FLUSH.getValue();
				
				if(hArray[0].getKey() == CardValue.ACE.getValue()) {
					rank = Rank.ROYAL_FLUSH.getValue();
				}
			}
		}
		
		return rank;
	}
	
	static int HigherCard(TreeSet<ValueThenKeyComparator> sortedHistogramP1, TreeSet<ValueThenKeyComparator> sortedHistogramP2) {
		
		// Convert tree sets to arrays
		ValueThenKeyComparator[] hArrayP1 = sortedHistogramP1.toArray(new ValueThenKeyComparator[sortedHistogramP1.size()]);
		ValueThenKeyComparator[] hArrayP2 = sortedHistogramP2.toArray(new ValueThenKeyComparator[sortedHistogramP2.size()]);
		
		// Compare highest cards of players 
		for(int i = 0; i < hArrayP1.length; i++) {
			if(hArrayP1[i].getKey() != hArrayP2[i].getKey()) {
				return hArrayP1[i].getKey() > hArrayP2[i].getKey() ? 1 : 2;
			}
		}
		
		return 0;
	}
}
