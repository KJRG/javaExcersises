package com.capgemini.pascalrectangle;

// @formatter:off
/**
 * Created by ldrygala on 2015-01-23.
 * 0                     1
 * 1                   1   1
 * 2                 1   2   1
 * 3               1   3   3   1
 * 4             1   4   6   4   1
 * 5           1   5   10  10   5   1
 * 6         1   6   15  20  15   6   1
 * 7       1   7   21  35  35   21  7   1
 * 8     1   8   28  56  70  56   28  8   1
 * 9   1   9  36   84  126 126  84  36  9   1
 */
// @formatter:on
public class PascalRectangle {
	public long pascal(int c, int r) {
		if (c < 0 || r < 0 || c > r) {
			return 0;
		}

		long value = 1;

		// calculate r! / c!
		for (long i = r; i > c; i--) {
			value *= i;
		}

		// calculate (r - c)!
		long rmcfactorial = 1;
		for (int i = 1; i <= (r - c); i++) {
			rmcfactorial *= i;
		}

		// calculate r! / ( c! * (r - c)! )
		value /= rmcfactorial;

		return value;
	}

	public static void main(String[] args) {
		PascalRectangle pr = new PascalRectangle();
		for (int i = -1; i < 10; i++) {
			for (int j = -1; j <= i; j++) {
				System.out.println("r: " + i + " c: " + j + " value: " + pr.pascal(j, i));
			}
		}
	}
}
