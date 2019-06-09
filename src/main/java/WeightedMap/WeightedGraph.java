package WeightedMap;

public abstract class WeightedGraph {

    int edgeCount;
    int pointCount;
    boolean isDirected;

    public abstract int pointCount();
    public abstract int edgeCount();
    public abstract void addEdge(Edge edge);


}
