package aads.term_paper.prim_algorithm;

/* Graph (граф) класс который представляет неориентированный взвешенный граф в виде матрицы смежности. */
public class Graph {
    private int[][] adjacencyMatrix; // представляет матрицу смежности графа
    private int numVertices; // количество вершин в графе

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    /* Метод addEdge добавляет ребро между двумя вершинами start и end с заданным весом,
     обновляя соответствующие элементы матрицы смежности. */
    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
        adjacencyMatrix[end][start] = weight;
    }

    /* Метод displayMatrix выводит матрицу смежности на экран. */
    public void displayMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    /* Методы getAdjacencyMatrix и getNumVertices возвращают соответствующие поля объекта Graph. */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
    public int getNumVertices() {
        return numVertices;
    }
}
