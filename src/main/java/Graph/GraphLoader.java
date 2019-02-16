package Graph;

import java.io.*;

public class GraphLoader {
    public static Graph edgeList(File srcFile, String delimiter, boolean directed, boolean weighted){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(srcFile));
            String line;
            Graph graph = new Graph(directed, weighted);

            while ((line=reader.readLine()) != null) {
                String[] s;
                try {
                    s = line.split(delimiter);
                    Vertex src = graph.addVertex(Long.parseLong(s[0]));
                    Vertex dst = graph.addVertex(Long.parseLong(s[1]));
                    if(weighted) {
                        double weight = Double.parseDouble(s[2]);
                        graph.addEdge(src,dst,weight);
                    }
                    else
                        graph.addEdge(src,dst);
                } catch (Exception e) {
                    System.out.println("Exception has occurred");
                }
            }
            reader.close();
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
