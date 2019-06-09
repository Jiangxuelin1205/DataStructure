package WeightedMap;

import java.io.*;

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
        //parse point and edge
        String line;
        line = reader.readLine();
        this.pointCount = Integer.valueOf(line.split(" ")[0]);
        this.edgeCount = Integer.valueOf(line.split(" ")[1]);

        //parse isDirected
        line = reader.readLine();
        this.isDirected = Boolean.parseBoolean(line);

        //create graph
        graph = new Edge[pointCount][pointCount];

        //parse edges
        while ((line = reader.readLine()) != null) {
            int startPoint = Integer.valueOf(line.split(" ")[0]);
            int endPoint = Integer.valueOf(line.split(" ")[1]);
            double weight = Double.valueOf(line.split(" ")[2]);
            Edge e = new Edge(startPoint, endPoint, weight);
            graph[startPoint][endPoint] = e;
        }
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

}
