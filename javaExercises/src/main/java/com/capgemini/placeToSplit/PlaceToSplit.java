package com.capgemini.placeToSplit;

import java.lang.reflect.Array;

//@formatter:off
/**
 * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * Example:
 * {{{
 * canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false
 * canBalance({10, 10}) → true
 * }}}
 */
//@formatter:on
public final class PlaceToSplit {
	private PlaceToSplit() {
	}

	public static boolean canBalance(int[] nums) {

		/*
		 * if the size of array is less then 2, it is not possible to get 2
		 * parts with equal sums of elements
		 */
		if (Array.getLength(nums) < 2) {
			return false;
		}

		int left = 0, right = 0;

		/*
		 * first, calculate the sum of all elements - the initial value of the
		 * right part
		 */
		for (int i = 0; i < Array.getLength(nums); i++) {
			right += nums[i];
		}

		/*
		 * for each element of array, check if it can be the last element of
		 * left part
		 */
		for (int i = 0; i < Array.getLength(nums); i++) {
			left += nums[i];
			right -= nums[i];

			if (left == right) {
				return true;
			}
		}

		return false;
	}

}
