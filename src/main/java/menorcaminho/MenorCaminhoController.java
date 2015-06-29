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
public class MenorCaminhoController {

    private static final String template = "%s, %s!";

    @RequestMapping(value = "/menorcaminho", method = RequestMethod.GET)
    public Caminho acharMenorCaminho(
            @RequestParam(value = "origem", required = true) String origem,
            @RequestParam(value = "destino", required = true) String destino,
            @RequestParam(value = "autonomia", required = false, defaultValue = "0") Double autonomia,
            @RequestParam(value = "litro", required =  false, defaultValue = "0") Double litro) {
        return new Caminho(origem, destino, autonomia, litro,
                Dijkstra.acharMenorCaminho(origem, destino));
    }
}
