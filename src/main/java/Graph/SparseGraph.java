package Graph;

import java.util.ArrayList;
import java.util.List;

public class SparseGraph extends Graph {

    private List<List<Integer>> graph;

    public SparseGraph() {

    }

    public SparseGraph(int pointCount, boolean isDirected) {
        this.pointCount = pointCount;
        this.isDirected = isDirected;
        this.edgeCount = 0;
        createGraph();
    }

    public int pointCount() {
        return pointCount;
    }

    public int edgeCount() {
        return edgeCount;
    }

    public void addEdge(int startPoint, int endPoint) throws GraphException {
        if (!legal(startPoint, endPoint)) {
            throw new GraphException("节点坐标不合法");
        }
        if (hasEdge(startPoint, endPoint)) {
            return;
        }
        graph.get(startPoint).add(endPoint);
        if (!isDirected) {
            graph.get(endPoint).add(startPoint);
        }
        edgeCount++;
    }

    private boolean hasEdge(int startPoint, int endPoint) {
        if (graph.get(startPoint).size() == 0) {
            return false;
        }
        for (int point : graph.get(startPoint)) {
            if (point == endPoint) {
                return true;
            }
        }
        return false;
    }

    private boolean legal(int startPoint, int endPoint) {
        return startPoint >= 0 && startPoint < pointCount
                && endPoint >= 0 && endPoint < pointCount;
    }

    public void traverse() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + ":");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void createGraph() {
        graph = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    @Override
    public int dfs() {
        boolean[] isVisited = new boolean[pointCount];
        for (int i = 0; i < pointCount; i++) {
            if (!isVisited[i]) {

                dfs(i, isVisited);
                component++;
            }
        }
        return component;
    }

    private void dfs(int i, boolean[] isVisited) {
        isVisited[i] = true;
        id[i] = component;
        if (graph.get(i).size() == 0) {
            return;
        }
        for (Integer index : graph.get(i)) {
            if (!isVisited[index]) {
                dfs(index, isVisited);
            }
        }
    }


}
