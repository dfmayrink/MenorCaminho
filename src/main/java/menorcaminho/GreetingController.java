package menorcaminho;

/**
 * Created by MayrinDF on 26/06/2015.
 */


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(
            @RequestParam(value="origem", required = true) String origem,
            @RequestParam(value="destino", required = true) String destino) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, origem, destino));
    }
}
