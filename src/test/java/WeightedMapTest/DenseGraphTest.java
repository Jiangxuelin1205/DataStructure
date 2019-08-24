package WeightedMapTest;

import WeightedGraph.DenseGraph;
import WeightedGraph.Edge;
import WeightedGraph.WeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DenseGraphTest {

    @Test
    public void add_edge() {
        //given
        WeightedGraph graph = new DenseGraph(4, false);
        //when
        graph.addEdge(new Edge(0, 2, 0.25));
        //then
        Assert.assertEquals(graph.edgeCount(), 1);
    }

    @Test
    public void read_graph() throws IOException {
        WeightedGraph graph = new DenseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.edgeCount(), 16);
        Assert.assertEquals(graph.pointCount(), 8);
    }

    @Test
    public void prim() throws IOException {
        WeightedGraph graph = new DenseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.getPrimTree(), 1.81, 0.01);
    }

    @Test
    public void kruscal() throws IOException {
        WeightedGraph graph = new DenseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        Assert.assertEquals(graph.Kruscal(), 1.81, 0.01);
    }

    @Test
    public void dijkstra() throws IOException {
        WeightedGraph graph=new DenseGraph("./src/main/java/WeightedMap/graphProperties.txt");
        graph.Dijkstra();
    }
}
