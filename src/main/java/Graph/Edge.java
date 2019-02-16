package Graph;

public class Edge {
    private Vertex src;
    private Vertex dst;
    private double weight;

    public Edge(Vertex src, Vertex dst) {
        this.src = src;
        this.dst = dst;
        weight = 1;
    }

    public Edge(Vertex src, Vertex dst, double weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }

    public Vertex getDst() {
        return dst;
    }

    public void setDst(Vertex dst) {
        this.dst = dst;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dst=" + dst +
                ", weight=" + weight +
                '}';
    }
}
