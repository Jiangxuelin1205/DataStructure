package WeightedMap;

import java.io.*;
import java.util.*;

public class DenseGraph extends WeightedGraph {

    private Edge[][] graph;

    /**
     * 稠密图，矩阵中的每个元素是Edge,数据结构为(startPoint,endPoint,weight),形如（0,1,0.25）
     **/
    public DenseGraph(int pointCount, boolean isDirected) {
        this.edgeCount = 0;
        this.isDirected = isDirected;
        this.pointCount = pointCount;
        graph = new Edge[pointCount][pointCount];
    }

    public DenseGraph(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        parsePointAndEdge(reader);
        parseIsDirected(reader);
        createGraph();
        parseEdges(reader);
    }

    private void parseEdges(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            int startPoint = Integer.valueOf(line.split(" ")[0]);
            int endPoint = Integer.valueOf(line.split(" ")[1]);
            double weight = Double.valueOf(line.split(" ")[2]);
            graph[startPoint][endPoint] = new Edge(startPoint, endPoint, weight);
            if (!isDirected) {
                graph[endPoint][startPoint] = new Edge(endPoint, startPoint, weight);
            }
        }
    }

    private void createGraph() {
        graph = new Edge[pointCount][pointCount];
    }

    private void parseIsDirected(BufferedReader reader) throws IOException {
        String line;//parse isDirected
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
        return pointCount;
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public void addEdge(Edge edge) {
        graph[edge.startPoint][edge.endPoint] = edge;
        edgeCount++;
    }

    public void visit(int index, PriorityQueue<Edge> q, boolean[] marked) {
        marked[index] = true;
        //遍历该节点的所有连接点，并且入队
        for (int i = 0; i < pointCount; i++) {
            if (graph[index][i] != null) {
                q.add(graph[index][i]);
            }
        }
    }

    void addQueue(PriorityQueue<Edge> q) {
        for (int row = 0; row < pointCount; row++) {
            for (int column = 0; column < pointCount; column++) {
                if (row < column && graph[row][column] != null) {
                    q.add(graph[row][column]);
                }
            }
        }
    }

    //Dijkstra算法,打印0节点到各个节点的最短路径
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
            if (graph[0][i] != null) {
                weight[i] = Integer.MAX_VALUE;
                from[i] = 0;
            } else {
                weight[i] = Integer.MAX_VALUE;
                from[i] = -1;
            }
        }
        weight[0] = 0;
        q.add(new Edge(0, 0, 0));
        from[0] = 0;
        while (!q.isEmpty()) {
            //noinspection ConstantConditions
            Edge e = q.poll();
            assert e != null;
            isMarked[e.endPoint] = true;
            for (int i = 0; i < pointCount; i++) {
                if (graph[e.endPoint][i] != null && !isMarked[i]) {//有边
                    if (weight[e.endPoint] + graph[e.endPoint][i].weight < weight[i]) {
                        weight[i] = weight[e.endPoint] + graph[e.endPoint][i].weight;
                        from[i] = e.endPoint;
                        if (!q.contains(graph[e.endPoint][i])) {
                            q.add(graph[e.endPoint][i]);
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
