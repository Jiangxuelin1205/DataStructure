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
}
