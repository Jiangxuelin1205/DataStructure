package Graph;

public class DenseGraph {

    private int edgeCount;
    private int pointCount;
    private boolean isDirected;
    private boolean[][] graph;

    public DenseGraph(int pointCount) {
        this.edgeCount = 0;
        this.isDirected = false;
        this.pointCount = pointCount;
        graph = new boolean[pointCount][pointCount];
    }

    public int pointCount() {
        return pointCount;
    }

    public int edgeCount() {
        return edgeCount;
    }

    public void addEdge(int startPoint, int endPoint) throws DenseGraphException {
        if (illegal(startPoint, endPoint)) {
            throw new DenseGraphException("节点坐标不合法");
        }
        if (hasEdge(startPoint, endPoint)) {
            return;
        }
        graph[startPoint][endPoint] = true;
        if (!isDirected) {
            graph[endPoint][startPoint] = true;
        }
        edgeCount++;
    }

    private boolean illegal(int startPoint, int endPoint) {
        return startPoint >= 0 && startPoint < pointCount &&
                endPoint >= 0 && endPoint < pointCount;
    }

    private boolean hasEdge(int startPoint, int endPoint) {
        return graph[startPoint][endPoint];
    }

}
