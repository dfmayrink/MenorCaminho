package menorcaminho;

/**
 * Created by MayrinDF on 26/06/2015.
 */

import java.util.*;


/***
 * Código baseado na fonte: http://www.algolist.com/code/java/Dijkstra's_algorithm
 *
 */
public class Dijkstra {

    public static class ResultadoMenorCaminho {
        public double distancia;
        public List<Vertex> vertices;

        public ResultadoMenorCaminho(double distancia, List<Vertex> vertices) {
            this.distancia = distancia;
            this.vertices = vertices;
        }
    }

    public static List<Vertice> vertices;

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    /**
     * Método que constrói a lista inicial com as cidades e  ligações que serão inseridos
     * no banco
     * @return uma lista com as cidades e suas ligações
     */
    public static List<Vertice> construirVertices() {
        ArrayList<Vertice> listaVertices = new ArrayList<>();

        HashMap<String, Double> vertices = new HashMap<>();
        vertices.put("B", 10d);
        vertices.put("C", 15d);
        listaVertices.add(new Vertice("A", vertices));

        vertices = new HashMap<>();
        vertices.put("A", 10d);
        vertices.put("C", 3d);
        vertices.put("D", 20d);
        listaVertices.add(new Vertice("B", vertices));

        vertices = new HashMap<>();
        vertices.put("A", 15d);
        vertices.put("B", 3d);
        vertices.put("D", 15d);
        vertices.put("E", 30d);
        listaVertices.add(new Vertice("C", vertices));

        vertices = new HashMap<>();
        vertices.put("B", 20d);
        vertices.put("C", 15d);
        vertices.put("E", 10d);
        listaVertices.add(new Vertice("D", vertices));

        vertices = new HashMap<>();
        vertices.put("C", 30d);
        vertices.put("D", 10d);
        listaVertices.add(new Vertice("E", vertices));

        return listaVertices;
    }

    public static LinkedHashMap<String, Vertex> montarEstrutura(List<Vertice> vertices) {
        LinkedHashMap<String, Vertex> mapaVertices = new LinkedHashMap<>();
        //cria os vértices principais
        for(Vertice v: vertices) {
            mapaVertices.put(v.getNome(), new Vertex(v.getNome()));
        }
        for(Vertice v: vertices) {
            Vertex vertex = mapaVertices.get(v.getNome());
            List<Edge> edges = new ArrayList<>();
            for( Map.Entry<String, Double> adj: v.getAdjacencias().entrySet()) {
                edges.add(new Edge(mapaVertices.get(adj.getKey()), adj.getValue()));
            }
            vertex.adjacencies = edges;
        }
        return mapaVertices;
    }

    public static ResultadoMenorCaminho acharMenorCaminho(String origem, String destino) {
        LinkedHashMap<String, Vertex> mapaVertices =  montarEstrutura(vertices);
        /*Calcula as distâncias do ponto de origem*/
        computePaths(mapaVertices.get(origem));
        /*Pega o ponto destino*/
        Vertex v  = mapaVertices.get(destino);

        System.out.println("Distância de " + v + ": " + v.minDistance);
        List<Vertex> path = getShortestPathTo(v);
        System.out.println("Caminho: " + path);
        return new ResultadoMenorCaminho(v.minDistance, path);
    }
}
