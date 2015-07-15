package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class HandTest {
	@Test
	public void shouldReturnHighCardFor2H_4D_7C_TS_KH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.FOUR, 'D'),
				new Card(CardValue.SEVEN, 'C'), new Card(CardValue.TEN, 'S'), new Card(CardValue.KING, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.HIGH_CARD, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnOnePairFor2H_2S_3D_8H_JS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.TWO, 'S'),
				new Card(CardValue.THREE, 'D'), new Card(CardValue.EIGHT, 'H'), new Card(CardValue.JACK, 'S'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.ONE_PAIR, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnTwoPairsFor5D_5C_8H_8S_AS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.FIVE, 'D'), new Card(CardValue.FIVE, 'C'),
				new Card(CardValue.EIGHT, 'H'), new Card(CardValue.EIGHT, 'S'), new Card(CardValue.ACE, 'S'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.TWO_PAIRS, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnThreeFor7C_7S_7H_TD_JH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.SEVEN, 'C'), new Card(CardValue.SEVEN, 'S'),
				new Card(CardValue.SEVEN, 'H'), new Card(CardValue.TEN, 'D'), new Card(CardValue.JACK, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.THREE, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnStraightFor3C_4S_5D_6H_7H() {
		List<Card> cards = Arrays.asList(new Card(CardValue.THREE, 'C'), new Card(CardValue.FOUR, 'S'),
				new Card(CardValue.FIVE, 'D'), new Card(CardValue.SIX, 'H'), new Card(CardValue.SEVEN, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.STRAIGHT, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFlushFor2H_4H_7H_9H_KH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.FOUR, 'H'),
				new Card(CardValue.SEVEN, 'H'), new Card(CardValue.NINE, 'H'), new Card(CardValue.KING, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FLUSH, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFullHouseFor9H_9C_9D_TS_TH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.NINE, 'H'), new Card(CardValue.NINE, 'C'),
				new Card(CardValue.NINE, 'D'), new Card(CardValue.TEN, 'S'), new Card(CardValue.TEN, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FULL_HOUSE, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnFourFor2H_2C_2D_2S_QH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.TWO, 'C'),
				new Card(CardValue.TWO, 'D'), new Card(CardValue.TWO, 'S'), new Card(CardValue.QUEEN, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.FOUR, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnStraightFlushFor7S_8S_9S_TS_JS() {
		List<Card> cards = Arrays.asList(new Card(CardValue.SEVEN, 'S'), new Card(CardValue.EIGHT, 'S'),
				new Card(CardValue.NINE, 'S'), new Card(CardValue.TEN, 'S'), new Card(CardValue.JACK, 'S'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.STRAIGHT_FLUSH, hand.getHandRank(histogram, cards));
	}

	@Test
	public void shouldReturnRoyalFlushForTH_JH_QH_KH_AH() {
		List<Card> cards = Arrays.asList(new Card(CardValue.TEN, 'H'), new Card(CardValue.JACK, 'H'),
				new Card(CardValue.QUEEN, 'H'), new Card(CardValue.KING, 'H'), new Card(CardValue.ACE, 'H'));
		Hand hand = new Hand(cards);

		TreeSet<CardOccurrenceCounter> histogram = hand.createHistogram(cards);

		assertEquals(Rank.ROYAL_FLUSH, hand.getHandRank(histogram, cards));
	}

}
