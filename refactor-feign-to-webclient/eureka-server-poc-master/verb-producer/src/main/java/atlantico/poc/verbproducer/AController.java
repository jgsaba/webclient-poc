package atlantico.poc.verbproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    private String[] verbs = {"ran", "saw", "bought", "knew"};

    @GetMapping("/")
    public @ResponseBody
    String getAVerb(){

        int indexPicked = (int)Math.round(Math.random() * (verbs.length - 1));
        return verbs[indexPicked];
    }
}
