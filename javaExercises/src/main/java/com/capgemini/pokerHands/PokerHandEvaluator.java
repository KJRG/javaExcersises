package com.capgemini.pokerHands;

import java.util.List;

public class PokerHandEvaluator {
	public static int findWinner(List<Card> handP1, List<Card> handP2) {

		// Hands of players
		Hand handPlayer1 = new Hand(handP1), handPlayer2 = new Hand(handP2);

		return handPlayer1.compareTo(handPlayer2);
	}

}
