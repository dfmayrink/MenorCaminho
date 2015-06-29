package menorcaminho;

import org.springframework.data.annotation.Id;

import java.util.HashMap;

/**
 * Created by MayrinDF on 29/06/2015.
 */
public class Vertice {
    @Id
    private String id;

    private String nome;
    private HashMap<String, Double> adjacencias;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashMap<String, Double> getAdjacencias() {
        return adjacencias;
    }

    public void setAdjacencias(HashMap<String, Double> adjacencias) {
        this.adjacencias = adjacencias;
    }

    public Vertice(String nome, HashMap<String, Double> adjacencias) {
        this.nome = nome;
        this.adjacencias = adjacencias;
    }

    public Vertice() {
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", adjacencias=" + adjacencias +
                '}';
    }
}
