package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class HandTest {
	@Test
	public void shouldReturnHighCardFor2H_4D_7C_TS_KH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, CardSuit.HEARTS), new Card(CardValue.FOUR, CardSuit.DIAMONDS),
				new Card(CardValue.SEVEN, CardSuit.CLUBS), new Card(CardValue.TEN, CardSuit.SPADES), new Card(CardValue.KING, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.HIGH_CARD, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnOnePairFor2H_2S_3D_8H_JS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, CardSuit.HEARTS), new Card(CardValue.TWO, CardSuit.SPADES),
				new Card(CardValue.THREE, CardSuit.DIAMONDS), new Card(CardValue.EIGHT, CardSuit.HEARTS), new Card(CardValue.JACK, CardSuit.SPADES));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.ONE_PAIR, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnTwoPairsFor5D_5C_8H_8S_AS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.FIVE, CardSuit.DIAMONDS), new Card(CardValue.FIVE, CardSuit.CLUBS),
				new Card(CardValue.EIGHT, CardSuit.HEARTS), new Card(CardValue.EIGHT, CardSuit.SPADES), new Card(CardValue.ACE, CardSuit.SPADES));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.TWO_PAIRS, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnThreeFor7C_7S_7H_TD_JH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.SEVEN, CardSuit.CLUBS), new Card(CardValue.SEVEN, CardSuit.SPADES),
				new Card(CardValue.SEVEN, CardSuit.HEARTS), new Card(CardValue.TEN, CardSuit.DIAMONDS), new Card(CardValue.JACK, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.THREE, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnStraightFor3C_4S_5D_6H_7H() {
		List<Card> cards = Arrays.asList(new Card(CardValue.THREE, CardSuit.CLUBS), new Card(CardValue.FOUR, CardSuit.SPADES),
				new Card(CardValue.FIVE, CardSuit.DIAMONDS), new Card(CardValue.SIX, CardSuit.HEARTS), new Card(CardValue.SEVEN, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.STRAIGHT, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFlushFor2H_4H_7H_9H_KH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, CardSuit.HEARTS), new Card(CardValue.FOUR, CardSuit.HEARTS),
				new Card(CardValue.SEVEN, CardSuit.HEARTS), new Card(CardValue.NINE, CardSuit.HEARTS), new Card(CardValue.KING, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FLUSH, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFullHouseFor9H_9C_9D_TS_TH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.NINE, CardSuit.HEARTS), new Card(CardValue.NINE, CardSuit.CLUBS),
				new Card(CardValue.NINE, CardSuit.DIAMONDS), new Card(CardValue.TEN, CardSuit.SPADES), new Card(CardValue.TEN, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FULL_HOUSE, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFourFor2H_2C_2D_2S_QH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, CardSuit.HEARTS), new Card(CardValue.TWO, CardSuit.CLUBS),
				new Card(CardValue.TWO, CardSuit.DIAMONDS), new Card(CardValue.TWO, CardSuit.SPADES), new Card(CardValue.QUEEN, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FOUR, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnStraightFlushFor7S_8S_9S_TS_JS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.SEVEN, CardSuit.SPADES), new Card(CardValue.EIGHT, CardSuit.SPADES),
				new Card(CardValue.NINE, CardSuit.SPADES), new Card(CardValue.TEN, CardSuit.SPADES), new Card(CardValue.JACK, CardSuit.SPADES));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.STRAIGHT_FLUSH, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnRoyalFlushForTH_JH_QH_KH_AH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TEN, CardSuit.HEARTS), new Card(CardValue.JACK, CardSuit.HEARTS),
				new Card(CardValue.QUEEN, CardSuit.HEARTS), new Card(CardValue.KING, CardSuit.HEARTS), new Card(CardValue.ACE, CardSuit.HEARTS));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.ROYAL_FLUSH, hand.getHandRank(histogram, cards));
	}

}
