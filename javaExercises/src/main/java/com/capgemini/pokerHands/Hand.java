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
	
	TreeSet<CardOccurrenceCounter> createHistogram(List<Card> hand) {
		Map<CardValue, Integer> histogram = new HashMap<CardValue, Integer>();
		CardValue cardValue;
		Integer quantity = 0;

		for (Card c : hand) {
			cardValue = c.getValue();

			if (histogram.containsKey(cardValue)) {
				quantity = histogram.get(cardValue);
				histogram.put(cardValue, quantity + 1);
				continue;
			}

			histogram.put(cardValue, 1);
		}

		
		/*
		 * sort the histograms descending:
		 * first by quantity, then by the value of card
		 */
		TreeSet<CardOccurrenceCounter>	sortedHistogram = new TreeSet<CardOccurrenceCounter>(Collections.reverseOrder());
		for (CardValue key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}
		
		return sortedHistogram;
	}
	
	Rank getHandRank(TreeSet<CardOccurrenceCounter> sortedHistogram, List<Card> hand) {

		Rank rank = Rank.HIGH_CARD;
		boolean isFlush = true;
		CardSuit suit;

		// Convert tree set to list
		List<CardOccurrenceCounter> hList = new ArrayList<CardOccurrenceCounter> (sortedHistogram);
		
		// Evaluate the hand
		switch (hList.get(0).getNumOfOccurrences()) {
		case 1:

			/*
			 * Hand: (1, 1, 1, 1, 1)
			 * The histogram is sorted - to check if there is a straight,
			 * it's enough to check the result of highest_card - lowest_card
			 * - if it's 4, it's straight, otherwise it's high card
			 */
			
			if (hList.get(0).getCardValue().getValue() - hList.get(4).getCardValue().getValue() == 4) {

				/* straight or royal straight */
				rank = Rank.STRAIGHT;
				break;
			}

			rank = Rank.HIGH_CARD;
			break;

		case 2:

			if (hList.get(1).getNumOfOccurrences() == 1) {

				/* Hand: (2, 1, 1, 1) */
				rank = Rank.ONE_PAIR;
				break;
			}

			/* Hand: (2, 2, 1) */
			rank = Rank.TWO_PAIRS;
			break;

		case 3:

			if (hList.get(1).getNumOfOccurrences() == 1) {

				/* Hand: (3, 1, 1) */
				rank = Rank.THREE;
				break;
			}

			/* Hand: (3, 2) */
			rank = Rank.FULL_HOUSE;
			break;

		case 4:

			/* Hand: (4, 1) */
			rank = Rank.FOUR;
			break;
		}

		// Check if there's flush or not
		suit = hand.get(0).getSuit();

		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(i).getSuit() != suit) {
				isFlush = false;
				break;
			}
		}

		if (isFlush) {
			if (rank.getValue() < Rank.STRAIGHT.getValue()) {
				rank = Rank.FLUSH;
				return rank;
			}

			if (rank.getValue() == Rank.STRAIGHT.getValue()) {
				rank = Rank.STRAIGHT_FLUSH;

				if (hList.get(0).getCardValue() == CardValue.ACE) {
					rank = Rank.ROYAL_FLUSH;
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
				return hListP1.get(i).getCardValue().getValue() > hListP2.get(i).getCardValue().getValue() ? 1 : -1;
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
		TreeSet<CardOccurrenceCounter>	histogramP1 = createHistogram(this.getCards()),
										histogramP2 = createHistogram(o.getCards());

		Rank rankP1 = getHandRank(histogramP1, this.getCards()),
			 rankP2 = getHandRank(histogramP2, o.getCards());
		
		return rankP1 == rankP2 ? HigherCard(histogramP1, histogramP2) : (rankP1.getValue() - rankP2.getValue());
	}
}
