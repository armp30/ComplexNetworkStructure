package Graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphSaver {
    public static void writeDat(Graph graph, File dst, String... delimiter) {
        String separator;
        if (delimiter.length != 1)
            separator = " ";
        else
            separator = delimiter[0];

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {

            for (Vertex v : graph.getVertices().values()) {
                writer.write(v.getId() + separator + v.getValue() + "\n");
            }

            for (Edge e : graph.getEdges()) {
                writer.write(e.getSrc().getId() + separator + e.getDst().getId());
                if (graph.isWeighted())
                    writer.write(separator + e.getWeight());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
