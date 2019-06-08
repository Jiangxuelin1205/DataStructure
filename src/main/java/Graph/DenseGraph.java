package Graph;

import java.util.*;

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
                dfs(i, isVisited);
                component++;
            }
        }
        return component;
    }

    private void dfs(int i, boolean[] isVisited) {
        isVisited[i] = true;
        id[i] = component;
        for (int index = 0; index < pointCount; index++) {
            if (graph[i][index] && !isVisited[index]) {
                dfs(index, isVisited);
            }
        }
    }

    @Override
    public List<Integer> path(int startPoint, int endPoint) {
        int[] from = new int[pointCount];
        boolean[] isVisited = new boolean[pointCount];
        for (int i = 0; i < pointCount; i++) {
            from[i] = -1;
        }
        isVisited[startPoint] = true;
        findPath(startPoint, from, isVisited);
        if (hasPath(from, endPoint)) {
            return null;
        }
        Stack<Integer> stk = new Stack<>();
        int i = endPoint;
        while (from[i] != -1) {
            stk.push(from[i]);
            i = from[i];
        }
        List<Integer> path = new ArrayList<>();
        while (!stk.isEmpty()) {
            path.add(stk.peek());
            stk.pop();
        }
        return path;
    }

    private boolean hasPath(int[] from, int endPoint) {
        return from[endPoint] == -1;
    }

    private void findPath(int i, int[] from, boolean[] isVisited) {
        for (int index = 0; index < pointCount; index++) {
            if (graph[i][index] && from[index] == -1 && !isVisited[index]) {
                from[index] = i;
                isVisited[index] = true;
                findPath(index, from, isVisited);
            }
        }
    }

    @Override
    public void bfs() {
        boolean[] isVisited = new boolean[pointCount];
        int[] from = new int[pointCount];
        for(int i=0;i<from.length;i++){
            from[i]=-1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < pointCount; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited, from, q);
            }
        }
    }

    private void bfs(int startPoint, boolean[] isVisited, int[] from, Queue<Integer> q) {
        isVisited[startPoint] = true;
        q.offer(startPoint);
        while (!q.isEmpty()) {
            @SuppressWarnings("ConstantConditions")
            int i = q.poll();
            for (int index = 0; index < pointCount; index++)
                if (graph[i][index] && !isVisited[index]) {
                    q.offer(index);
                    isVisited[index] = true;
                    from[index] = i;
                }
        }
    }


}
