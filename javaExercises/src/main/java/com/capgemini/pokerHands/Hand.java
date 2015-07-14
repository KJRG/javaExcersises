package com.capgemini.pokerHands;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

public class Hand implements Comparable<Hand> {
	private List<Card> cards;
	
	public Hand(List<Card> cards) {
		this.cards = new ArrayList<Card> (cards);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	Map<Integer, Integer> createHistogram(List<Card> hand) {
		Map<Integer, Integer> histogram = new HashMap<Integer, Integer>();
		Integer cardValue = 0, quantity = 0;

		for (Card c : hand) {
			cardValue = c.getValue();

			if (histogram.containsKey(cardValue)) {
				quantity = histogram.get(cardValue);
				histogram.put(cardValue, quantity + 1);
				continue;
			}

			histogram.put(cardValue, 1);
		}

		return histogram;
	}
	
	int getHandRank(TreeSet<CardOccurrenceCounter> sortedHistogram, List<Card> hand) {

		int rank = 0;
		boolean isFlush = true;
		char color;

		// Convert tree set to list
		List<CardOccurrenceCounter> hList = new ArrayList<CardOccurrenceCounter> (sortedHistogram);
		
		// Evaluate the hand

		switch (hList.get(0).getNumOfOccurrences()) {
		case 1:

			// Hand: (1, 1, 1, 1, 1)
			/*
			 * The histogram is sorted - to check if there is a straight,
			 * it's enough to check the result of highest_card - lowest_card
			 * - if it's 4, it's straight, otherwise it's high card
			 */
			
			if (hList.get(0).getCardValue() - hList.get(4).getCardValue() == 4) {

				// straight or royal straight
				rank = Rank.STRAIGHT.getValue();
				break;
			}

			rank = Rank.HIGH_CARD.getValue();
			break;

		case 2:

			if (hList.get(1).getNumOfOccurrences() == 1) {

				// Hand: (2, 1, 1, 1)
				rank = Rank.ONE_PAIR.getValue();
				break;
			}

			// Hand: (2, 2, 1)
			rank = Rank.TWO_PAIRS.getValue();
			break;

		case 3:

			if (hList.get(1).getNumOfOccurrences() == 1) {

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

		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(i).getSuit() != color) {
				isFlush = false;
				break;
			}
		}

		if (isFlush) {
			if (rank < Rank.STRAIGHT.getValue()) {
				rank = Rank.FLUSH.getValue();
				return rank;
			}

			if (rank == Rank.STRAIGHT.getValue()) {
				rank = Rank.STRAIGHT_FLUSH.getValue();

				if (hList.get(0).getCardValue() == CardValue.ACE.getValue()) {
					rank = Rank.ROYAL_FLUSH.getValue();
				}
			}
		}

		return rank;
	}
	
	int HigherCard(TreeSet<CardOccurrenceCounter> sortedHistogramP1,
			TreeSet<CardOccurrenceCounter> sortedHistogramP2) {

		// Convert tree sets to lists
		List<CardOccurrenceCounter> hListP1 = new ArrayList<CardOccurrenceCounter> (sortedHistogramP1),
									hListP2 = new ArrayList<CardOccurrenceCounter> (sortedHistogramP2);

		// Compare highest cards of players
		for (int i = 0; i < hListP1.size(); i++) {
			if (hListP1.get(i).getCardValue() != hListP2.get(i).getCardValue()) {
				return hListP1.get(i).getCardValue() > hListP2.get(i).getCardValue() ? 1 : -1;
			}
		}

		return 0;
	}

	public int compareTo(Hand o) {
	
		/*
		 * create histograms for hands of both players
		 * key is the value of card, value is the quantity
		 * of this card in the hand of player
		 */
		Map<Integer, Integer>	histogramP1 = createHistogram(this.getCards()),
								histogramP2 = createHistogram(o.getCards());
		
		/*
		 * sort the histograms descending:
		 * first by quantity, then by the value of card
		 */
		TreeSet<CardOccurrenceCounter>	sortedHistogramP1 = new TreeSet<CardOccurrenceCounter>(Collections.reverseOrder()),
										sortedHistogramP2 = new TreeSet<CardOccurrenceCounter>(Collections.reverseOrder());

		for (Integer key : histogramP1.keySet()) {
			sortedHistogramP1.add(new CardOccurrenceCounter(key, histogramP1.get(key)));
		}

		for (Integer key : histogramP2.keySet()) {
			sortedHistogramP2.add(new CardOccurrenceCounter(key, histogramP2.get(key)));
		}

		int rankP1 = getHandRank(sortedHistogramP1, this.getCards()),
			rankP2 = getHandRank(sortedHistogramP2, o.getCards());
		
		return rankP1 == rankP2 ? HigherCard(sortedHistogramP1, sortedHistogramP2) : (rankP1 - rankP2);
	}
}
