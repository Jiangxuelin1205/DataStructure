package WeightedMapTest;

import WeightedMap.DenseGraph;
import WeightedMap.Edge;
import WeightedMap.WeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
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
        Assert.assertEquals(graph.edgeCount(), 6);
        Assert.assertEquals(graph.pointCount(), 6);
    }


}
