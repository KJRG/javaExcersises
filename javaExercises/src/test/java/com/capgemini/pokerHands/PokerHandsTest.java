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
			w = ph.playerOneWins("src/main/resources/poker.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(376, w);
	}

}
