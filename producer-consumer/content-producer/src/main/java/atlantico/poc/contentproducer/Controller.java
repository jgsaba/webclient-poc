package atlantico.poc.contentproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/single")
    public @ResponseBody
    Payload getJustOnePayload(){

        Payload payload = new Payload("My title", "My content", new Date());
        return payload;
    }

    @GetMapping("/multiple")
    public @ResponseBody List<Payload> getMultiplePayloads(){

        Payload payload1 = new Payload("My title 1", "My content 2", new Date());
        Payload payload2 = new Payload("My title 2", "My content 2", new Date());
        Payload payload3 = new Payload("My title 3", "My content 2", new Date());

        List<Payload> payloads = new ArrayList<>();
        payloads.addAll(Arrays.asList(payload1, payload2, payload3));

        return payloads;
    }
}
