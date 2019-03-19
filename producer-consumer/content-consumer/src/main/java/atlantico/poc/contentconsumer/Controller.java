package atlantico.poc.contentconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
public class Controller {

    private WebClient webClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Controller(){
        webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .build();
    }

    @GetMapping("/single")
    public @ResponseBody Mono<MirrorPayload> getASingleOne(){

        String resource = "/single";

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        Mono<MirrorPayload> result =  webClient.get().uri(uri + resource)
                .retrieve().bodyToMono(MirrorPayload.class);
        return result;

    }

    @GetMapping("/multiples")
    public @ResponseBody Flux<MirrorPayload> getMultiples(){

        String resource = "/multiples";

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        Flux<MirrorPayload> result =  webClient.get().uri(uri + resource)
                .retrieve().bodyToFlux(MirrorPayload.class);

        return result;

    }
}
