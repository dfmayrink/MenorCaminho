package menorcaminho; /**
 * Created by MayrinDF on 26/06/2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private VertexRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
            todo Melhoramento para versão 2.0 = criar um método para ser executado
            somente uma vez, durante a instalação
         */
        repository.deleteAll();
        /*salva registros no banco*/
        repository.save(Dijkstra.construirVertices());

        // Pega todos os registros do banco
        System.out.println("Vertices achados com findAll():");
        List<Vertice> todosVertices = repository.findAll();
        for (Vertice vertex : todosVertices) {
            System.out.println(vertex);
        }
        System.out.println("--------------------------------------");

        Dijkstra.vertices = todosVertices;

        System.out.println("--------------------------------------");

    }

}
