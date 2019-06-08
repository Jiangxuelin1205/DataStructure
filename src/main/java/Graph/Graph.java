package Graph;

import java.io.*;
import java.util.List;

abstract class Graph {

    int edgeCount;
    int pointCount;
    boolean isDirected;
    int component;
    int[] id;

    public abstract int pointCount();

    public abstract int edgeCount();

    public abstract void addEdge(int startPoint, int endPoint) throws GraphException;

    public abstract void traverse();

    public abstract void createGraph();

    public void readGraph(String path) throws IOException, GraphException {
        InputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        parsePointAndEdge(reader);
        createGraph();
        parseIsDirected(reader);
        parseEdge(reader);
    }

    private void parseIsDirected(BufferedReader reader) throws IOException {
        String line;
        line = reader.readLine();
        isDirected = Boolean.parseBoolean(line);
    }

    private void parsePointAndEdge(BufferedReader reader) throws IOException {
        String line;
        line = reader.readLine();
        pointCount = Integer.valueOf(line.split(" ")[0]);
        edgeCount = Integer.valueOf(line.split(" ")[1]);
        id = new int[pointCount];
    }

    private void parseEdge(BufferedReader reader) throws IOException, GraphException {
        String line;
        while ((line = reader.readLine()) != null) {
            int startPoint = Integer.valueOf(line.split(" ")[0]);
            int endPoint = Integer.valueOf(line.split(" ")[1]);
            addEdge(startPoint, endPoint);
        }
    }

    public abstract int dfs();

    public boolean isConnected(int point1, int point2) {
        return id[point1] == id[point2];
    }

    public abstract List<Integer> path(int startPoint, int endPoint);
}
