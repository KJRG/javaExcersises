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
		int wins = 0; // number of wins for player 1

		List<Card> player1Cards = new ArrayList<Card>(),	// hand of player 1
				player2Cards = new ArrayList<Card>();		// hand of player 2
		Path fullFilepath = Paths.get(filename);			// full path to file with data

		// create scanner for reading file
		Scanner scanner = null;
		try {
			scanner = new Scanner(fullFilepath);

			// for each hand in file
			for (int i = 0; i < 1000; i++) {

				// Read cards of player 1
				for (int j = 0; j < 5; j++) {
					String card = scanner.next();
					CardValue value = CardValue.fromChar(card.charAt(0));
					player1Cards.add(new Card(value, card.charAt(1)));
				}

				// Read cards of player 2
				for (int j = 0; j < 5; j++) {
					String card = scanner.next();
					CardValue value = CardValue.fromChar(card.charAt(0));
					player2Cards.add(new Card(value, card.charAt(1)));
				}
				
				Hand handPlayer1 = new Hand(player1Cards);
				Hand handPlayer2 = new Hand(player2Cards);

				if (handPlayer1.compareTo(handPlayer2) >= 0) {
					wins++;
				}

				// Clear the lists of cards
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