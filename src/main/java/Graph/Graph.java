package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {
    private Map<Long,Vertex> vertices;
    private List<Edge> edges;
    private boolean direct;
    private boolean weighted;

    public Graph(boolean direct, boolean weighted) {
        this.direct = direct;
        this.weighted = weighted;
        vertices = new HashMap<>();
        edges = new ArrayList<>();
    }

    public Map<Long,Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean isDirect() {
        return direct;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public List<Vertex> getOutNeighbors(Vertex v){
        return (List<Vertex>) edges.stream().filter(x->x.getSrc()==v).map(x->x.getDst()).collect(Collectors.toList());
    }
    public List<Vertex> getInNeighbors(Vertex v){
        return (List<Vertex>) edges.stream().filter(x->x.getDst()==v).map(x->x.getSrc()).collect(Collectors.toList());
    }

    public List<Vertex> getNeighbors(Vertex v){
        List<Vertex> list = new ArrayList<Vertex>(getInNeighbors(v));
        list.addAll(getInNeighbors(v));
        return list;
    }




    public void addEdge(Vertex src, Vertex dst){
        edges.add(new Edge(src,dst));
        if (!direct)
            edges.add(new Edge(dst,src));
    }
    public void addEdge(Vertex src, Vertex dst, double weight){
        edges.add(new Edge(src, dst, weight));
        if (!direct)
            edges.add(new Edge(dst, src, weight));
    }

    public Vertex addVertex(long id){
        Vertex v;
        if(vertices.containsKey(id))
            v = vertices.get(id);
        else {
            v = new Vertex(id);
            vertices.put(id,v);
        }
        return v;
    }
    public Vertex addVertex(long id, double value){
        Vertex v;
        if(vertices.containsKey(id))
            v = vertices.get(id);
        else {
            v = new Vertex(id,value);
            vertices.put(id,v);
        }
        return v;
    }

    public void addVertex(Vertex v){
        if(vertices.containsKey(v.getId())) {
            double w = v.getWeight();
            v = vertices.get(v.getId());
            v.setWeight(w);
        }
        else {
            vertices.put(v.getId(),v);
        }
    }

    public List<Vertex> getChildVertices(){
        return vertices.values().stream().filter(x->this.getOutNeighbors(x).size()==0).collect(Collectors.toList());
    }

}
