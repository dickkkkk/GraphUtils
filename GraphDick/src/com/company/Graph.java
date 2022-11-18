package com.company;

import java.util.*;

public class Graph {

    private final int maxVershin;
    private int[][] arr;
    private final String vidGraph;

    Graph(){
        maxVershin = getRandomNumber(8, 12);
        arr = new int[maxVershin][maxVershin];
        vidGraph = getRandomVid();
        createRandomGraph();
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private String getRandomVid() {
        String[] str = new String[]{"orGraph", "Graph"};
        return str[getRandomNumber(0, 2)];
    }

    private void addEdge(int first, int second) {
        if (vidGraph.equals("orGraph")) {
            arr[first][second] = 1;
        } else {
            arr[first][second] = 1;
            arr[second][first] = 1;
        }
    }

    public void printGraph() {
        if (vidGraph.equals("orGraph")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 1) {
                        System.out.println(i + "-->" + j);
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 1) {
                        System.out.println(i + "--" + j);
                    }
                }
            }
        }

    }

    private void createRandomGraph() {
        for (int i = 0; i < maxVershin; i++) {
            addEdge(getRandomNumber(0, maxVershin), getRandomNumber(0, maxVershin));
        }
    }

    public List<Integer> dfs(int i0) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[maxVershin];
        visited[i0] = true;
        dfs.add(i0);
        class dfss {
            Integer dfsss(int j) {
                int v = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[j][i] == 1) {
                        if (!visited[i]) {
                            visited[i] = true;
                            v = i;
                            dfs.add(v);
                            dfsss(i);
                        }
                    }
                }
                return v;
            }
        }
        new dfss().dfsss(i0);
        return dfs;
    }

    public List<Integer> bfs(int i0) {
        Queue<Integer> bfsQueue = new ArrayDeque<>();
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[maxVershin];
        bfs.add(i0);

        class bfss {
            void bfsss(int j) {
                for (int i = 0; i < arr.length; i++) {
                    if (!visited[j]) {
                        visited[j] = true;
                    }
                    if (arr[j][i] == 1 && !visited[i]) {
                        bfsQueue.add(i);
                    }
                }
                if (!bfsQueue.isEmpty()) {
                    Integer v = bfsQueue.remove();
                    bfs.add(v);
                    bfsss(v);
                }
            }
        }
        new bfss().bfsss(i0);
        return bfs;
    }
}

// Графы - насилие над животными :(
