package com.algo.sort;

import com.algo.Starter;

/**
 * 时间复杂度 O(nlogn) 空间复杂度 O(n)
 * 
 * @author taojing
 *
 */
public class HeapSort implements Starter {

	public void heapify(int[] array, int size, int root) {

		int left = root * 2 + 1;
		int right = root * 2 + 2;

		int max = root;

		if (left < size && array[left] > array[max]) {
			max = left;
		}

		if (right < size && array[right] > array[max]) {
			max = right;
		}

		if (max != root) {
			int tmp = array[root];
			array[root] = array[max];
			array[max] = tmp;

			// 这一步不能省略，这一步为了保证heap结构。对于heap中的每个节点，都要大于他的左右节点值。
			heapify(array, size, max);
		}

	}

	public void heapSort(int[] array) {
		int start = array.length / 2 - 1;

		// 把一个普通数组变成一个heap。从下到上进行heapify。
		for (int i = start; i >= 0; i--) {
			heapify(array, array.length, i);
		}

		// 逐个取出根的值，并且用最后的节点与之替换。size减一，再次进行heapify操作。
		int len = array.length;
		for (int i = len - 1; i >= 0; i--) {
			int tmp = array[i];
			array[i] = array[0];
			array[0] = tmp;
			len--;
			heapify(array, len, 0);

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		heapSort(arr);

		for (int i : arr) {
			System.out.println(i);
		}

	}

}
