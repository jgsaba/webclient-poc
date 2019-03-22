package atlantico.poc.contentconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@RestController
public class Controller {

    private WebClient webClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Controller(WebClient.Builder webClientBuilder){
        webClient = webClientBuilder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .build();
    }

    @GetMapping("/send")
    public Mono<Payload> sendAndReceive(){

        Payload payload = new Payload();

        payload.setTitle("New title");
        payload.setContent("New content");
        payload.setCreated(new Date());

        String resource = "/single";
        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        Mono<Payload> result = webClient.post()
                .uri(uri + resource)
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(payload)
                .retrieve()
                .bodyToMono(Payload.class);

        return result;
    }

    @GetMapping("/single")
    public Payload getASingleOne(){

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        String resource = "/single";

        String completeUri = uri.toString() + resource;

        Payload result =

                webClient.get()
                .uri(completeUri)
                .retrieve()
                .bodyToMono(Payload.class)
                .block();

        return result;

    }

    @GetMapping("/multiples")
    public Flux<Payload> getMultiples(){

        String resource = "/multiples";

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        Flux<Payload> result =

                webClient.get()
                .uri(uri + resource)
                .retrieve()
                .bodyToFlux(Payload.class);

        return result;

    }
}
