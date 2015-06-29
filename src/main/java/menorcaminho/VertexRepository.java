 /**
 * baseado na fonte: http://spring.io/guides/gs/accessing-data-mongodb/
 * Created by MayrinDF on 26/06/2015.
 */

package menorcaminho;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VertexRepository extends MongoRepository<Vertice, String> {

    public Vertex findByName(String name);

}
