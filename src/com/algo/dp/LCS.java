package com.algo.dp;

import com.algo.Starter;

public class LCS implements Starter {

	public int longestCommonSubsequence(String str1, String str2) {

		int[][] map = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					map[i][j] = map[i - 1][j] > map[i][j - 1] ? map[i - 1][j] : map[i][j - 1];
				} else {
					map[i][j] = map[i - 1][j - 1] + 1;
				}
			}
		}

		return map[str1.length()][str2.length()];
	}

	@Override
	public void run() {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		System.out.println("Longest Common Subsequence: " + longestCommonSubsequence(s1, s2));

	}

}
