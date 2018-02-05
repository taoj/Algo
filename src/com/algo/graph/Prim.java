package com.algo.graph;

import com.algo.Starter;

/**
 * Prim‘s 是一种在无向图 有权重的情况下找到 MST的算法。是Greedy 算法的一种。
 * 
 * 基本想法是维持一个集合，所有在次集合中的vertex是已经在MST中。每个vertex会有一个key值，初始无限大。对每个进入集合中的vertex
 * 如果它的某个adjacncy的key值大于当前点到这个点的值时候，即 u-v 大于key，则key =
 * u-v。然后在所有没有在集合中的vertex中选出key值最小的 充分上述操作。直到所有vertex进入set中。
 * 
 * 时间复杂度O(v^2)
 * 
 * @author jingt
 *
 */

public class Prim implements Starter {

	public int findMin(boolean[] inSet, int[] keys) {
		int result = -1;
		int cur = Integer.MAX_VALUE;

		for (int i = 0; i < keys.length; i++) {
			if (!inSet[i] && keys[i] < cur) {
				cur = keys[i];
				result = i;
			}
		}
		return result;
	}

	public void printMST(int[] parents) {
		for (int i = 0; i < parents.length; i++) {
			System.out.println("edge " + parents[i] + " to " + i);
		}
	}

	public void primsFindMST(int[][] graph) {
		int len = graph.length;
		boolean[] inSet = new boolean[len];
		int[] keys = new int[len];
		int[] parents = new int[len];
		for (int i = 0; i < len; i++) {
			keys[i] = Integer.MAX_VALUE;
			parents[i] = -1;
		}
		keys[0] = 0;

		for (int i = 0; i < len; i++) {
			int u = findMin(inSet, keys);

			inSet[u] = true;

			for (int v = 0; v < len; v++) {
				if (graph[u][v] != 0 && !inSet[v] && graph[u][v] < keys[v]) {
					keys[v] = graph[u][v];
					parents[v] = u;
				}
			}
		}

		printMST(parents);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };

		primsFindMST(graph);
	}
}
