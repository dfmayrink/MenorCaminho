package menorcaminho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MayrinDF on 26/06/2015.
 */

public class Caminho {

    private final String origem;
    private final String destino;
    private double custoTotal;
    private Double distancia;
    private List<String> caminho;

    public Caminho(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Caminho(String origem, String destino, double autonomia,
                   double custoLitro, Dijkstra.ResultadoMenorCaminho caminho) {
        this.origem = origem;
        this.destino = destino;
        List<String> lista = new ArrayList<>(caminho.vertices.size());
        for(Vertex v: caminho.vertices) {
            lista.add(v.name);
        }
        this.caminho = lista;
        this.distancia = caminho.distancia;
        if(custoLitro != 0 && autonomia != 0)
            this.custoTotal = distancia * (custoLitro / autonomia);
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public List<String> getCaminho() {
        return caminho;
    }

    public Double getDistancia() {
        return distancia;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }
}
