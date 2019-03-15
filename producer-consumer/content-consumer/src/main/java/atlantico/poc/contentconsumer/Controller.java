package atlantico.poc.contentconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class Controller {

    private WebClient webClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/single")
    public MirrorPayload getASingleOne(){

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();
        //Mono<MirrorPayload> mirrorPayloadMono = webClient.get().uri()
    }
}
