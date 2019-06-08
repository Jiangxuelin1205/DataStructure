package Graph;

public class DenseGraph extends Graph {

    private boolean[][] graph;

    public DenseGraph() {

    }

    public DenseGraph(int pointCount, boolean isDirected) {
        this.edgeCount = 0;
        this.isDirected = isDirected;
        this.pointCount = pointCount;
        this.component = 0;
        this.id = new int[pointCount];
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
        graph[startPoint][endPoint] = true;
        if (!isDirected) {
            graph[endPoint][startPoint] = true;
        }
        edgeCount++;
    }

    private boolean legal(int startPoint, int endPoint) {
        return startPoint >= 0 && startPoint < pointCount &&
                endPoint >= 0 && endPoint < pointCount;
    }

    private boolean hasEdge(int startPoint, int endPoint) {
        return graph[startPoint][endPoint];
    }

    public void traverse() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ":");
            DenseGraphIterator iterator = new DenseGraphIterator(graph[i]);
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void createGraph() {
        graph = new boolean[pointCount][pointCount];
    }

    private class DenseGraphIterator {

        private int index;
        private boolean[] row;

        DenseGraphIterator(boolean[] row) {
            this.index = 0;
            this.row = row;
        }

        boolean hasNext() {
            while (index < row.length && !row[index]) {
                index++;
            }
            return index < row.length;
        }

        int next() {
            return index++;
        }
    }

    @Override
    public int dfs() {
        boolean[] isVisited = new boolean[pointCount];
        for (int i = 0; i < pointCount; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                id[i] = component;
                dfs(i, isVisited);
                component++;
            }
        }
        return component;
    }

    private void dfs(int i, boolean[] isVisited) {
        for (int index = 0; index < pointCount; index++) {
            if (graph[i][index] && !isVisited[index]) {
                isVisited[index] = true;
                id[index] = component;
                dfs(index, isVisited);
            }
        }
    }
}
