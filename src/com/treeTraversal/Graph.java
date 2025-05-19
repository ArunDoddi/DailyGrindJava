package com.treeTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private static final int MAX = 7;
    private Vertex[] lstVertices;
    private int[][] adjMatrix;
    private int vertexCount;

    public Graph(){
        lstVertices = new Vertex[MAX];
        adjMatrix = new int[MAX][MAX];
        vertexCount = 0;
    }

    private void addVertex(char label){
        Vertex vertex = new Vertex(label);
        lstVertices[vertexCount++] = vertex;
    }

    private void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    private void displayVertex(int vertexIndex){
        System.out.print(lstVertices[vertexIndex].label + " ");
    }

    private int getAdjUnvisitedVertex(int vertexIndex){
        for (int i = 0; i < vertexCount; i++) {
            if(adjMatrix[vertexIndex][i] == 1 && !lstVertices[i].visited){
                return i;
            }
        }
        return -1;
    }

    private void breadthFirstSearch() {
        lstVertices[0].visited = true;

        displayVertex(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int tempVertex = queue.poll();
            int unvisitedVertex;
            while ((unvisitedVertex = getAdjUnvisitedVertex(tempVertex)) != -1){
                lstVertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                queue.add(unvisitedVertex);
            }
        }

        for (int i = 0; i < vertexCount; i++) {
            lstVertices[i].visited = false;
        }
        System.out.println();
    }

    private void depthFirstSearch() {
        lstVertices[0].visited = true;

        displayVertex(0);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()){
            int unvisitedVertex = getAdjUnvisitedVertex(stack.peek());

            if(unvisitedVertex == -1) {
                stack.pop();
            }else {
                lstVertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                stack.push(unvisitedVertex);
            }
        }

        for (int i = 0; i < vertexCount; i++) {
            lstVertices[i].visited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        //Adding vertices
        graph.addVertex('S');
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');


        //Adding edges
        graph.addEdge(0, 1);    // S - A
        graph.addEdge(0, 2);    // S - B
        graph.addEdge(0, 3);    // S - C
        graph.addEdge(3 ,4);    // C - D
        graph.addEdge(3, 5);    // C - E
        graph.addEdge(3, 6);    // C - F

        System.out.println("Breadth First Search");
        graph.breadthFirstSearch();
        System.out.println("Depth First Search");
        graph.depthFirstSearch();
    }
}
