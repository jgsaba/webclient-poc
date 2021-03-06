package atlantico.poc.contentproducer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/single")
    public Payload getJustOne( ){

        Payload payload = new Payload("My title", "My content", new Date());
        return payload;
    }

    @PostMapping("/single")
    public Payload postJustOne(@RequestBody Payload streamPayload){

        Payload payload = new Payload("Your title is: " + streamPayload.getTitle(),
                "Your content is: " + streamPayload.getContent(), new Date());
        return payload;
    }

    @GetMapping("/multiples")
    public List<Payload> getMultiples(){

        Payload payload1 = new Payload("My title 1", "My content 1", new Date());
        Payload payload2 = new Payload("My title 2", "My content 2", new Date());
        Payload payload3 = new Payload("My title 3", "My content 3", new Date());

        List<Payload> payloads = new ArrayList<>();
        payloads.addAll(Arrays.asList(payload1, payload2, payload3));

        return payloads;
    }
}
