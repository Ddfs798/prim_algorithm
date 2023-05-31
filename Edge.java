package aads.term_paper.prim_algorithm;

/* Edge (ребро) класс который представляет ребро в неориентированном взвешенном графе. */
/* Класс реализует интерфейс Comparable, который позволяет упорядочить объекты этого класса на основе их веса. */
public class Edge implements Comparable<Edge> {
    private final int source; // исходная вершина
    private final int destination; // целевая вершина
    private final int weight; // вес ребра

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    /* Метод compareTo() сравнивает два объекта Edge по их весу.
    /* Это используется при сортировке объектов Edge. */

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }

}