package GraphTest;

import Graph.SparseGraph;
import Graph.SparseGraphException;
import org.junit.Assert;
import org.junit.Test;

public class SparseGraphTest {

    @Test
    public void get_point(){
        SparseGraph sparseGraph=new SparseGraph(3,false);
        Assert.assertEquals(sparseGraph.pointCount(),3);
    }

    @Test
    public void get_edge_count(){
        SparseGraph sparseGraph=new SparseGraph(3,false);
        Assert.assertEquals(sparseGraph.edgeCount(),0);
    }

    @Test
    public void add_edge() throws SparseGraphException {
        SparseGraph sparseGraph=new SparseGraph(3,false);
        sparseGraph.addEdge(1,2);
        Assert.assertEquals(sparseGraph.edgeCount(),1);
    }

    @Test
    public void traverse() throws SparseGraphException {
        SparseGraph sparseGraph=new SparseGraph(3,false);
        sparseGraph.addEdge(1,2);
        sparseGraph.addEdge(0,2);
        sparseGraph.traverse();
    }
}
