package GraphTest;

import Graph.DenseGraph;
import Graph.DenseGraphException;
import org.junit.Assert;
import org.junit.Test;

public class DenseGraphTest {

    @Test
    public void get_point_count(){
        DenseGraph denseGraph=new DenseGraph(3);
        Assert.assertEquals(denseGraph.pointCount(),3);
    }

    @Test
    public void get_edge_count(){
        DenseGraph denseGraph=new DenseGraph(3);
        Assert.assertEquals(denseGraph.edgeCount(),0);
    }

    @Test
    public void add_edge() throws DenseGraphException {
        DenseGraph denseGraph=new DenseGraph(3);
        denseGraph.addEdge(1,2);
        Assert.assertEquals(denseGraph.edgeCount(),1);
    }
}
