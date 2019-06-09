package WeightedMap;

import java.util.Comparator;
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

    public double getPrimTree() {
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight < o2.weight ? -1 : 1);
        double sum = 0;
        Set<Edge> result = new HashSet<>();
        boolean[] marked = new boolean[pointCount];
        visit(0, q, marked);

        while (!q.isEmpty()) {
            Edge e = q.poll();
            assert e != null;
            if (marked[e.startPoint] == marked[e.endPoint]) {

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

    public abstract void visit(int index, PriorityQueue<Edge> q, boolean[] marked);

    public double Kruscal(){
        //首先遍历图，将图中的边加入最小队列
        //最小队列中的节点，每次取出最小队列堆顶的元素，查看是否有环，如果没有形成环，则将该元素加入结果集
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));
        double sum = 0;
        boolean[] isVisited = new boolean[pointCount];
        Set<Edge> result = new HashSet<>();
        UnionFind unionFind = new UnionFind(pointCount);
        addQueue(q);

        while (!q.isEmpty()) {
            Edge e = q.poll();
            assert e != null;
            if (!unionFind.isConnected(e.startPoint, e.endPoint)) {
                unionFind.connect(e.startPoint, e.endPoint);
                result.add(e);
                if (!isVisited[e.startPoint]) {
                    isVisited[e.startPoint] = true;
                }
                if (!isVisited[e.endPoint]) {
                    isVisited[e.endPoint] = true;
                }
            }
        }

        for (Edge e : result) {
            sum += e.weight;
        }
        return sum;
    }

    abstract void addQueue(PriorityQueue<Edge> q);

    class UnionFind {
        int[] union;

        UnionFind(int count) {
            union = new int[count];
            for (int i = 0; i < count; i++) {
                union[i] = i;
            }
        }

        boolean isConnected(int i, int j) {
            return union[i] == union[j];
        }

        void connect(int i, int j) {
            int flag = union[j];
            for (int k = 0; k < union.length; k++) {
                if (union[k] == flag) {
                    union[k] = union[i];
                }
            }
        }
    }
}
