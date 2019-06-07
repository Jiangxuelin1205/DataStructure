package GraphTest;

import Graph.DenseGraph;
import Graph.DenseGraphException;
import org.junit.Assert;
import org.junit.Test;

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
    public void add_edge() throws DenseGraphException {
        DenseGraph denseGraph=new DenseGraph(3,false);
        denseGraph.addEdge(1,2);
        Assert.assertEquals(denseGraph.edgeCount(),1);
    }

    @Test
    public void traverse() throws DenseGraphException {
        DenseGraph denseGraph=new DenseGraph(3,false);
        denseGraph.addEdge(1,2);
        denseGraph.addEdge(0,1);
        denseGraph.traverse();
    }
}
