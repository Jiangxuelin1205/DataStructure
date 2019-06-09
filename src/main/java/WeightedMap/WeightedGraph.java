package WeightedMap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public abstract class WeightedGraph {

    int edgeCount;
    int pointCount;
    boolean isDirected;

    public abstract int pointCount();
    public abstract int edgeCount();
    public abstract void addEdge(Edge edge);

    public double getPrimTree(){
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight < o2.weight ? -1 : 1);
        double sum = 0;
        Set<Edge> result = new HashSet<>();
        boolean[] marked = new boolean[pointCount];
        visit(0, q, marked);

        while (!q.isEmpty()) {
            Edge e = q.peek();
            assert e != null;
            if (marked[e.startPoint] == marked[e.endPoint]) {
                q.poll();
                continue;
            }
            if (!marked[e.startPoint]) {
                result.add(e);
                visit(e.startPoint, q, marked);
            } else {
                result.add(e);
                visit(e.endPoint, q, marked);
            }
        }
        for (Edge edge : result) {
            sum += edge.weight;
        }
        return sum;
    }
    public abstract void visit(int index,PriorityQueue<Edge> q,boolean[] marked);
}
