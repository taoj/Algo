package com.algo.dp;

import com.algo.Starter;

/*
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * 
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 */

public class EditDistance implements Starter {

	private int min(int a, int b, int c) {
		int tmp = a < b ? a : b;
		return c < tmp ? c : tmp;
	}

	int shortestEditDistance(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					// characters are equals
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						int update = dp[i - 1][j - 1];
						int insert = dp[i][j - 1];
						int delete = dp[i - 1][j];

						dp[i][j] = min(update, insert, delete) + 1;
					}
				}
			}
		}

		return dp[m][n];

	}

	@Override
	public void run() {
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println("Shortest edit distance " + shortestEditDistance(str1, str2));

	}
}
