package com.algo.dp;

import com.algo.Starter;

/**
 * https://www.youtube.com/watch?v=ASsN8qNHFXI
 * 
 * @author jingt
 *
 */

public class MatrixChainMultiplication implements Starter {

	public int MatrixChainOrder(int[] input) {
		if (input.length <= 2) {
			return 0;
		}

		int lastSecond = 0;
		if (input.length > 3) {
			lastSecond = input[0] * input[1] * input[3];
		}

		int last = input[0] * input[1] * input[2];

		int start = input[0];

		for (int i = 3; i < input.length; i++) {
			int tmp = lastSecond;
			lastSecond = last;

			int takeTwo = tmp + input[i - 2] * input[i - 1] * input[i];
			int takeOne = last + start * input[i - 1] * input[i];
			last = Math.min(takeOne, takeTwo);
		}

		return last;
	}

	@Override
	public void run() {
		int arr[] = new int[] { 1, 2, 3, 4 };

		System.out.println("Matrix Chain Multiplication: " + MatrixChainOrder(arr));

	}

}
