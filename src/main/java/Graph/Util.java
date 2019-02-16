package Graph;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Util {

    public static Graph graphToDag(Graph src) {
        Graph dst = new Graph(true,false);
        Collection<Vertex> list = src.getVertices().values();
        Iterator it = list.iterator();
        for (int i = 0; i < new Random().nextInt(list.size())-1; i++) {
            it.next();
        }
        Vertex v = (Vertex) it.next();
        goDeep(src,dst,v);
        System.out.println("finished");
        return dst;
    }

    private static void goDeep(Graph src, Graph dst, Vertex vt){
        Vertex s = dst.addVertex(vt.getId());
        Vertex d;
        for (Vertex v : src.getOutNeighbors(vt)) {
            if(!v.isVisited()){
                v.setVisited(true);
                d = dst.addVertex(v.getId());
                dst.addEdge(s,d);
                goDeep(src, dst, v);
            }
        }

    }
}
