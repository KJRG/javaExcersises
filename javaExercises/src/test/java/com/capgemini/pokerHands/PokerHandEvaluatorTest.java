package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class PokerHandEvaluatorTest {

	@Test
	public void shouldReturn0For2H_4D_7C_TS_KH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.FOUR, 'D'),
				new Card(CardValue.SEVEN, 'C'), new Card(CardValue.TEN, 'S'), new Card(CardValue.KING, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(0, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn1For2H_2S_3D_8H_JS() {
		List<Card> hand = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.TWO, 'S'),
				new Card(CardValue.THREE, 'D'), new Card(CardValue.EIGHT, 'H'), new Card(CardValue.JACK, 'S'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}
		
		assertEquals(1, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn2For5D_5C_8H_8S_AS() {
		List<Card> hand = Arrays.asList(new Card(CardValue.FIVE, 'D'), new Card(CardValue.FIVE, 'C'),
				new Card(CardValue.EIGHT, 'H'), new Card(CardValue.EIGHT, 'S'), new Card(CardValue.ACE, 'S'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(2, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn3For7C_7S_7H_TD_JH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.SEVEN, 'C'), new Card(CardValue.SEVEN, 'S'),
				new Card(CardValue.SEVEN, 'H'), new Card(CardValue.TEN, 'D'), new Card(CardValue.JACK, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(3, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn4For3C_4S_5D_6H_7H() {
		List<Card> hand = Arrays.asList(new Card(CardValue.THREE, 'C'), new Card(CardValue.FOUR, 'S'),
				new Card(CardValue.FIVE, 'D'), new Card(CardValue.SIX, 'H'), new Card(CardValue.SEVEN, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(4, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn5For2H_4H_7H_9H_KH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.FOUR, 'H'),
				new Card(CardValue.SEVEN, 'H'), new Card(CardValue.NINE, 'H'), new Card(CardValue.KING, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(5, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn6For9H_9C_9D_TS_TH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.NINE, 'H'), new Card(CardValue.NINE, 'C'),
				new Card(CardValue.NINE, 'D'), new Card(CardValue.TEN, 'S'), new Card(CardValue.TEN, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(6, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn7For2H_2C_2D_2S_QH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.TWO, 'H'), new Card(CardValue.TWO, 'C'),
				new Card(CardValue.TWO, 'D'), new Card(CardValue.TWO, 'S'), new Card(CardValue.QUEEN, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(7, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn8For7S_8S_9S_TS_JS() {
		List<Card> hand = Arrays.asList(new Card(CardValue.SEVEN, 'S'), new Card(CardValue.EIGHT, 'S'),
				new Card(CardValue.NINE, 'S'), new Card(CardValue.TEN, 'S'), new Card(CardValue.JACK, 'S'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());
		
		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(8, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

	@Test
	public void shouldReturn9ForTH_JH_QH_KH_AH() {
		List<Card> hand = Arrays.asList(new Card(CardValue.TEN, 'H'), new Card(CardValue.JACK, 'H'),
				new Card(CardValue.QUEEN, 'H'), new Card(CardValue.KING, 'H'), new Card(CardValue.ACE, 'H'));

		Map<Integer, Integer> histogram = PokerHandEvaluator.createHistogram(hand);
		TreeSet<CardOccurrenceCounter> sortedHistogram = new TreeSet<CardOccurrenceCounter>(
				Collections.reverseOrder());

		for (Integer key : histogram.keySet()) {
			sortedHistogram.add(new CardOccurrenceCounter(key, histogram.get(key)));
		}

		assertEquals(9, PokerHandEvaluator.getHandRank(sortedHistogram, hand));
	}

}
