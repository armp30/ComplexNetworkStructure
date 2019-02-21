package Graph;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private long id;
    private boolean visited;
    private double weight;
    private long community=-1;

    public Vertex(long id) {
        this.id = id;
    }

    public Vertex(long id, double value) {
        this.id = id;
        this.weight = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getCommunity() {
        return community;
    }

    public void setCommunity(long community) {
        this.community = community;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", visited=" + visited +
                ", weight=" + weight +
                ", community=" + community +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return Long.compare(id,o.getId());
    }
}
