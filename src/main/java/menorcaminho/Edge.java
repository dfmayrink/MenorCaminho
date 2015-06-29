package menorcaminho;

import org.springframework.data.annotation.Id;

/**
 * Created by MayrinDF on 29/06/2015.
 */
public class Edge {
    @Id
    private String id;

    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}
