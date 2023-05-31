package aads.term_paper.prim_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* Класс Prim для нахождения минимального остовного дерева в неориентированном взвешенном графе. */
public class Prim {
    private Graph graph;
    private List<Edge> edgesInMst;

    /* Конструктор Prim принимает объект Graph и сохраняет его в качестве поля graph. */
    /* Также создается пустой список edgesInMst, в котором будут храниться ребра минимального остовного дерева. */
    public Prim(Graph graph) {
        this.graph = graph;
        edgesInMst = new ArrayList<>();
    }
    /* Метод getMinimumSpanningTree реализует алгоритм Прима.
    /* Сначала создается массив visited для отслеживания посещенных вершин, и вершина 0 помечается как посещенная.
    /* Затем создается приоритетная очередь priorityQueue для хранения ребер, отсортированных по весу. */
    public List<Edge> getMinimumSpanningTree() {
        boolean[] visited = new boolean[graph.getNumVertices()];
        visited[0] = true;

        /* Далее, начиная с вершины 0, добавляются все ребра, выходящие из нее, в приоритетную очередь.
        /* Затем извлекается ребро с минимальным весом из очереди, и если его конечная вершина еще не была посещена,
        /* то она помечается как посещенная, ребро добавляется в список edgesInMst и количество посещенных вершин увеличивается. */

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < graph.getNumVertices(); i++) {
            if (graph.getAdjacencyMatrix()[0][i] != 0) {
                priorityQueue.add(new Edge(0, i, graph.getAdjacencyMatrix()[0][i]));
            }
        }

        int visitedVertices = 1;
        int iterationCount = 0; // Для измерния количества итераций

        while (!priorityQueue.isEmpty() && visitedVertices != graph.getNumVertices()) {
            Edge edge = priorityQueue.remove();
            iterationCount++; // увеличиваем количество итераций


            if (visited[edge.getDestination()]) {
                continue;
            }

          /* Затем для каждой вершины, связанной с конечной вершиной извлеченного ребра,
          /* и которая еще не была посещена, добавляются все ее ребра в приоритетную очередь. */

            visited[edge.getDestination()] = true;
            edgesInMst.add(edge);
            visitedVertices++;

            /* Этот процесс продолжается до тех пор, пока приоритетная очередь не станет пустой или все вершины не будут посещены.
            /* Наконец, метод возвращает список edgesInMst, содержащий ребра минимального остовного дерева. */

            for (int i = 0; i < graph.getNumVertices(); i++) {
                if (graph.getAdjacencyMatrix()[edge.getDestination()][i] != 0 && !visited[i]) {
                    priorityQueue.add(new Edge(edge.getDestination(), i,
                            graph.getAdjacencyMatrix()[edge.getDestination()][i]));
                }
            }
        }
        System.out.println("Количество итераций: " + iterationCount); // выводим количество итераций
        return edgesInMst;
    }
}