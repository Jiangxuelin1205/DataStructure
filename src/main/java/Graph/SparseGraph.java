package Graph;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SparseGraph {

    private int edgeCount;
    private int pointCount;
    private final boolean isDirected;
    private List<List<Integer>> graph;

    public SparseGraph(int pointCount, boolean isDirected) {
        this.pointCount = pointCount;
        this.isDirected = isDirected;
        this.edgeCount = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public int pointCount() {
        return pointCount;
    }

    public int edgeCount() {
        return edgeCount;
    }

    public void addEdge(int startPoint, int endPoint) throws SparseGraphException {
        if (!legal(startPoint, endPoint)) {
            throw new SparseGraphException("节点坐标不合法");
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

    public void traverse(){
        for(int i=0;i<graph.size();i++){
            if(graph.get(i).size()==0){
                continue;
            }
            System.out.print(i+":");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
