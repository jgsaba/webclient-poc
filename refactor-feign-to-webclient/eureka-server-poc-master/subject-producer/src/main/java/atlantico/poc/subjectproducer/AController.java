package atlantico.poc.subjectproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    private String[] subjects = {"I", "You", "He", "She", "It"};

    @GetMapping("/")
    public @ResponseBody String getASubject(){

        int indexPicked = (int)Math.round(Math.random() * (subjects.length - 1));
        return subjects[indexPicked];
    }
}
