package aads.term_paper.prim_algorithm;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(10);
        Random rand = new Random();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int j = i + 1; j < graph.getNumVertices(); j++) {
                int weight = rand.nextInt(10) + 1; // случайный вес ребра от 1 до 10
                graph.addEdge(i, j, weight);
            }
        }

        /* Вывод матрицы смежности */
        System.out.println("Матрица смежности графа:");
        graph.displayMatrix();

        /* Запуск алгоритма Прима. */
        long startTime = System.nanoTime();

        Prim primsAlgorithm = new Prim(graph);
        List<Edge> mst = primsAlgorithm.getMinimumSpanningTree();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        /* Вывод ребер минимального остовного дерева. */
        System.out.println("\nРебра минимального остовного дерева:");
        for (Edge edge : mst) {
            System.out.println(edge.getSource() + " - " + edge.getDestination() + " : " + edge.getWeight());
        }

        /* Вывод матрицы смежности с отмеченными ребрами минимального остовного дерева. */
        System.out.println("\nМатрица смежности графа с отмеченными ребрами минимального остовного дерева:");
        int[][] mstMatrix = new int[graph.getNumVertices()][graph.getNumVertices()];
        for (Edge edge : mst) {
            mstMatrix[edge.getSource()][edge.getDestination()] = edge.getWeight();
            mstMatrix[edge.getDestination()][edge.getSource()] = edge.getWeight();
        }
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int j = 0; j < graph.getNumVertices(); j++) {
                System.out.print(mstMatrix[i][j] + " ");
            }
            System.out.println();
        }

        /* Вывод времени работы алгоритма. */
        System.out.println("\nВремя работы алгоритма: " + duration + " наносекунд");
        /* Время работы алгоритма Прима сохраняется в переменные startTime и endTime в наносекундах.
         * Разница между этими значениями дает общее время работы алгоритма. */
    }
}