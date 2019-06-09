package WeightedMapTest;

import WeightedMap.Edge;
import WeightedMap.SparseGraph;
import WeightedMap.WeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SparseGraphTest {

    @Test
    public void add_edge() {
        WeightedGraph graph = new SparseGraph(3, false);
        graph.addEdge(new Edge(0, 2, 0.3));
        Assert.assertEquals(graph.edgeCount(), 1);
        Assert.assertEquals(graph.pointCount(), 3);
    }

    @Test
    public void read_graph() throws IOException {
        WeightedGraph graph = new SparseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.pointCount(), 6);
        Assert.assertEquals(graph.edgeCount(), 6);
    }

    @Test
    public void primGraph() throws IOException {
        WeightedGraph graph=new SparseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.getPrimTree(),1.81,0.01);
    }

    @Test
    public void kruscal() throws IOException {
        WeightedGraph graph = new SparseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.Kruscal(), 1.81, 0.01);
    }
}
