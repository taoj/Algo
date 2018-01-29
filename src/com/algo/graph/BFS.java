package com.algo.graph;

import com.algo.Starter;

import java.util.LinkedList;

public class BFS extends Graph implements Starter{

    public BFS(){
    }

    public void init(int num){
        n = num;
        adj = new LinkedList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void bfs(int first){

        boolean[] visit = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        //初始状态
        visit[first] = true;
        queue.offer(first);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println("process node "+cur);

            for(int next : adj[cur]){
                if(!visit[next]){
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }

    }

    @Override
    public void run() {
        init(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        bfs(2);
    }
}
