package menorcaminho;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by MayrinDF on 29/06/2015.
 */
public class Vertex implements Comparable<Vertex> {
    @Id
    private String id;

    public final String name;
    public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}
