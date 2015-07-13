package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PokerHandsTest {

	@Test
	public void shouldReturn376ForFilePokertxt() {
		PokerHands ph = new PokerHands();
		int w = 0;

		try {
			w = ph.PlayerOneWins(
					"C:\\Users\\kgalka\\git\\javaExcersises\\javaExercises\\src\\main\\java\\com\\capgemini\\pokerHands\\poker.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(w, 376);
	}

}
