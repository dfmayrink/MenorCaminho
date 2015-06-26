 /**
 * baseado na fonte: http://spring.io/guides/gs/accessing-data-mongodb/
 * Created by MayrinDF on 26/06/2015.
 */
package mongo;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.Id;

public class Customer {

        @Id
        private String id;

        private String firstName;
        private String lastName;

        public Customer() {}

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return String.format(
                    "mongo.Customer[id=%s, firstName='%s', lastName='%s']",
                    id, firstName, lastName);
        }


}
