package GraphTest;

import Graph.DenseGraph;
import Graph.GraphException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DenseGraphTest {

    @Test
    public void get_point_count(){
        DenseGraph denseGraph=new DenseGraph(3,false);
        Assert.assertEquals(denseGraph.pointCount(),3);
    }

    @Test
    public void get_edge_count(){
        DenseGraph denseGraph=new DenseGraph(3,false);
        Assert.assertEquals(denseGraph.edgeCount(),0);
    }

    @Test
    public void add_edge() throws GraphException {
        DenseGraph denseGraph=new DenseGraph(3,false);
        denseGraph.addEdge(1,2);
        Assert.assertEquals(denseGraph.edgeCount(),1);
    }

    @Test
    public void traverse() throws GraphException {
        DenseGraph denseGraph=new DenseGraph(3,false);
        denseGraph.addEdge(1,2);
        denseGraph.addEdge(0,1);
        denseGraph.traverse();
    }

    @Test
    public void read_graph_test() throws IOException, GraphException {
        DenseGraph graph=new DenseGraph();
        graph.readGraph("./src/main/java/Graph/graphProperties");
        graph.traverse();
    }
}
