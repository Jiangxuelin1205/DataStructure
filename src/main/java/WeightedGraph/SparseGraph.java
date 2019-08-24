package WeightedGraph;

import java.io.*;
import java.util.*;

public class SparseGraph extends WeightedGraph {

    private List<List<Edge>> graph;

    public SparseGraph(int pointCount, boolean isDirected) {
        this.pointCount = pointCount;
        this.isDirected = isDirected;
        this.edgeCount = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public SparseGraph(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        parsePointAndEdge(reader);
        parseIsDirected(reader);
        createGraph();
        parseEdges(reader);
    }

    private void createGraph() {
        graph = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    private void parseEdges(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            int startPoint = Integer.valueOf(line.split(" ")[0]);
            int endPoint = Integer.valueOf(line.split(" ")[1]);
            double weight = Double.valueOf(line.split(" ")[2]);
            graph.get(startPoint).add(new Edge(startPoint, endPoint, weight));
            if (!isDirected) {
                graph.get(endPoint).add(new Edge(endPoint, startPoint, weight));
            }
        }
    }

    private void parseIsDirected(BufferedReader reader) throws IOException {
        String line;
        line = reader.readLine();
        this.isDirected = Boolean.parseBoolean(line);
    }

    private void parsePointAndEdge(BufferedReader reader) throws IOException {
        String line;
        line = reader.readLine();
        this.pointCount = Integer.valueOf(line.split(" ")[0]);
        this.edgeCount = Integer.valueOf(line.split(" ")[1]);
    }

    @Override
    public int pointCount() {
        return this.pointCount;
    }

    @Override
    public int edgeCount() {
        return this.edgeCount;
    }

    @Override
    public void addEdge(Edge edge) {
        if (graph.get(edge.startPoint).size() != 0) {
            //遍历
            Edge remove = null;
            for (Edge e : graph.get(edge.startPoint)) {
                if (e.endPoint == edge.endPoint) {
                    remove = e;
                    break;
                }
            }
            if (remove != null) {
                graph.get(edge.startPoint).remove(remove);
                edgeCount--;
            }
        }
        graph.get(edge.startPoint).add(edge);
        if (!isDirected) {
            graph.get(edge.endPoint).add(edge);
        }
        edgeCount++;
    }

    public void visit(int index, PriorityQueue<Edge> q, boolean[] marked) {
        marked[index] = true;
        for (Edge e : graph.get(index)) {
            if (e != null) {
                q.add(e);
            }
        }
    }

    void addQueue(PriorityQueue<Edge> q) {
        for (int row = 0; row < pointCount; row++) {
            q.addAll(graph.get(row));
        }
    }

    @Override
    public void Dijkstra() {
        //存储路径
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        int[] from = new int[pointCount];
        //存储从原点到每个点的权值
        double[] weight = new double[pointCount];
        //记录每个点是否被访问过
        boolean[] isMarked = new boolean[pointCount];
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weight));

        //初始化from,weight,q
        for (int i = 0; i < pointCount; i++) {
            from[i] = -1;
            weight[i] = Integer.MAX_VALUE;
        }
        weight[0] = 0;
        q.add(new Edge(0, 0, 0));
        from[0] = 0;

        while (!q.isEmpty()) {
            //noinspection ConstantConditions
            Edge e = q.poll();
            assert e != null;
            isMarked[e.endPoint] = true;
            for (Edge edge : graph.get(e.endPoint)) {
                if (!isMarked[edge.endPoint]) {
                    if (weight[e.endPoint] + edge.weight < weight[edge.endPoint]) {
                        weight[edge.endPoint] = weight[e.endPoint] + edge.weight;
                        from[e.endPoint] = e.endPoint;
                        if (!q.contains(edge)) {
                            q.add(edge);
                        }
                    }
                }
            }
        }
        for (double aWeight : weight) {
            System.out.println(aWeight);
        }
    }


}
