package com.capgemini.pokerHands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerHands {
	public int PlayerOneWins(String filename) throws IOException {
		int wins = 0;

		List<Card> player1Cards = new ArrayList<Card>(), player2Cards = new ArrayList<Card>();
		Path fullFilepath = Paths.get(filename);

		Scanner scanner = null;
		try {
			scanner = new Scanner(fullFilepath);

			// for each hand in file
			for (int i = 0; i < 1000; i++) {

				// Read cards of player 1
				for (int j = 0; j < 5; j++) {
					String card = scanner.next();
					CardValue value = CardValue.fromChar(card.charAt(0));
					CardSuit suit = CardSuit.fromChar(card.charAt(1));
					player1Cards.add(new Card(value, suit));
				}

				// Read cards of player 2
				for (int j = 0; j < 5; j++) {
					String card = scanner.next();
					CardValue value = CardValue.fromChar(card.charAt(0));
					CardSuit suit = CardSuit.fromChar(card.charAt(1));
					player2Cards.add(new Card(value, suit));
				}

				Hand handPlayer1 = new Hand(player1Cards), handPlayer2 = new Hand(player2Cards);

				if (handPlayer1.compareTo(handPlayer2) >= 0) {
					wins++;
				}

				player1Cards.clear();
				player2Cards.clear();
			}

		} catch (FileNotFoundException ex) {
			throw ex;
		} finally {
			scanner.close();
		}

		return wins;
	}
}