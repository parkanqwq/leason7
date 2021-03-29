package com.company;

public class Graph {

    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    //private Stack stack = new Stack(MAX_VERTS);

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

//    public void dfs(){ //обхода в глубину.
//        vertexList[0].wasVisited = true;
//        displayVertex(0);
//        stack.push(0);
//        while (!stack.isEmpty()){
//            int v = getAdjUnvisitedVertex(stack.peek());
//            if (v == -1){
//                stack.pop();
//            } else {
//                vertexList[v].wasVisited = true;
//                displayVertex(v);
//                stack.push(v);
//            }
//        }
//
//        for (int i = 0; i < size; i++) {
//            vertexList[i].wasVisited = false;
//        }
//    }

    public void dfs2(int v){ // обхода в ширину
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;

        vertexList[0].wasVisited = true;
        queue[qT++] = v;

        displayVertex(0);

        int v2;
        while (qH < qT){
            v = queue[qH++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].wasVisited && v2 != -1){
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void dfs(int f){ //обхода в глубину.
        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1){
                fullDisplayVertex(f, v);
                dfs(i);
            }
        }
    }

    private void fullDisplayVertex(int vertex, int vertex2) {
        System.out.println("Вершина " + vertexList[vertex].label + "-" + vertexList[vertex2].label);
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
}
