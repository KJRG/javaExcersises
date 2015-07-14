package com.capgemini.fibonacci;

// @formatter:off
/**
 * Created by ldrygala on 2015-01-23.
 * F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	  F18	F19
 1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597  2584	4181
 */
// @formatter:on
public class Fibonacci {
	public static long fib(int n) {
		if (n < 0) {
			return 0;
		}

		long	a = 0, // F(n)
				b = 1; // F(n + 1)

		for (int i = 0; i < n; i++) {
			
			// for next n (n = n + 1):
			b += a;		// calculate F(n + 1)
			a = b - a;	// calculate F(n)
		}

		return a;
	}

}
