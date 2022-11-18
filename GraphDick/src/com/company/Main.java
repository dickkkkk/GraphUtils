package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Graph gr = new Graph();

        /*gr.addEdge(1, 2);
        gr.addEdge(1, 3);
        gr.addEdge(2, 3);
        gr.addEdge(2, 4);
        gr.addEdge(2, 4);
        gr.addEdge(3, 4);
        */

        gr.printGraph();
        System.out.println();
        System.out.println("Введите начальную вершину для обходов: ");
        int i0 = scn().nextInt();

        System.out.println("Обход dfs: ");
        List<Integer> l = gr.dfs(i0);
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();
        System.out.println("Обход bfs: ");
        List<Integer> l2 = gr.bfs(i0);
        Iterator it = l2.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    public static Scanner scn(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
