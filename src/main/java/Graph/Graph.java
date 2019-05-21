package Graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<Long,Vertex> vertices;
    private List<Edge> edges;
    private boolean directed;
    private boolean weighted;


    public Graph(boolean directed, boolean weighted) {
        this.directed = directed;
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

    public boolean isDirected() {
        return directed;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public Set<Vertex> getOutNeighbors(Vertex v){
        return edges.stream().filter(x->x.getSrc().equals(v)).map(x->x.getDst()).collect(Collectors.toSet());
    }
    public Set<Vertex> getInNeighbors(Vertex v){
        return edges.stream().filter(x->x.getDst().equals(v)).map(x->x.getSrc()).collect(Collectors.toSet());
    }

    public Set<Vertex> getNeighbors(Vertex v){
       Set<Vertex> neighbours = new HashSet<>();
       neighbours.addAll(getInNeighbors(v));
       neighbours.addAll(getOutNeighbors(v));
        return neighbours;
    }

    public List<Vertex> getNeighboursList(Vertex v){
        return new ArrayList<Vertex>(getNeighbors(v));
    }




    public void addEdge(Vertex src, Vertex dst){
        edges.add(new Edge(src,dst));
        if (!directed)
            edges.add(new Edge(dst,src));
    }
    public void addEdge(Vertex src, Vertex dst, double weight){
        edges.add(new Edge(src, dst, weight));
        if (!directed)
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

    public Set<Vertex> getChildVertices(){
        return vertices.values().stream().filter(x->this.getNeighbors(x).size()==1).collect(Collectors.toSet());

    }

}
