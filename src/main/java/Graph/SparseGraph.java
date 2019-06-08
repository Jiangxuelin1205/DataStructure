package Graph;

import java.util.*;

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

    @Override
    public List<Integer> path(int startPoint, int endPoint) {
        int[] from = new int[pointCount];
        for (int i = 0; i < pointCount; i++) {
            from[i] = -1;
        }
        boolean[] isVisited = new boolean[pointCount];
        isVisited[startPoint] = true;
        findPath(startPoint, from, isVisited);
        if (from[endPoint] == -1) {
            return null;
        }
        Stack<Integer> stk = new Stack<>();
        int i = endPoint;
        while (from[i] != -1) {
            stk.push(from[i]);
            i = from[i];
        }
        List<Integer> result = new ArrayList<>();
        while (!stk.isEmpty()) {
            result.add(stk.peek());
            stk.pop();
        }
        return result;
    }

    private void findPath(int startPoint, int[] from, boolean[] isVisited) {
        if (graph.get(startPoint).size() == 0) {
            return;
        }
        for (Integer index : graph.get(startPoint)) {
            if (!isVisited[index] && from[index] == -1) {
                from[index] = startPoint;
                isVisited[startPoint] = true;
                findPath(index, from, isVisited);
            }
        }
    }

    /**
     * @Description 打印路径
     **/
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

        for (int i = 0; i < from.length; i++) {
            System.out.println(from[i]);
        }
    }

    private void bfs(int startPoint, boolean[] isVisited, int[] from, Queue<Integer> q) {
        isVisited[startPoint] = true;
        q.offer(startPoint);
        while (!q.isEmpty()) {
            int i = q.poll();
            for (Integer point : graph.get(i)) {
                if (!isVisited[point]) {
                    isVisited[point] = true;
                    from[point] = i;
                    q.offer(point);
                }
            }
        }
    }


}
