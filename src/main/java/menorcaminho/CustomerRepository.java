 /**
 * baseado na fonte: http://spring.io/guides/gs/accessing-data-mongodb/
 * Created by MayrinDF on 26/06/2015.
 */

package menorcaminho;

import java.util.List;

import mongo.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
