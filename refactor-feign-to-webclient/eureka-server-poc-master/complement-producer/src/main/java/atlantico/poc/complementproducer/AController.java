package atlantico.poc.complementproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    private String[] complements = {"an awesome boat", "an old minivan", "a wood-fresh board"};

    @GetMapping("/")
    public @ResponseBody String getAComplement(){

        int indexPicked = (int)Math.round(Math.random() * (complements.length - 1));
        return complements[indexPicked];
    }
}
