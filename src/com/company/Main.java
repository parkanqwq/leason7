package com.company;

public class Main {

    /*
    Задание 7.1
    Примером графа будет метро. Там есть вершины, это станции, а ребра будут железнодородные линии.
    */

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);

        long a = System.nanoTime();
        graph.dfs(0); // обхода в глубину.
        System.out.println("обход в глубино заняло " + (System.nanoTime() - a) + " нана секунд");
        System.out.println();

        Graph graph2 = new Graph();

        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');
        graph2.addVertex('E');
        graph2.addVertex('G');

        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(0, 5);

        long b = System.nanoTime();
        graph2.dfs2(0); // обхода в ширину
        System.out.println("обход в ширину заняло " + (System.nanoTime() - b) + " нана секунд");

    }
}
