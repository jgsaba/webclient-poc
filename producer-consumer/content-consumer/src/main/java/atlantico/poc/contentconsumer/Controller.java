package atlantico.poc.contentconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactivefeign.webclient.WebReactiveFeign;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;

@RestController
public class Controller {

    private WebClient webClient;

    private ProducerClient producerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Controller() {
        webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .build();
    }

    @GetMapping("/send")
    public Mono<Payload> sendAndReceive() {

        Payload payload = new Payload();

        payload.setTitle("New title");
        payload.setContent("New content");
        payload.setCreated(new Date());

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        ProducerClient producerClient = WebReactiveFeign.<ProducerClient>builder().target(ProducerClient.class, uri.toString());

        return producerClient.sendAndGetOneBack(payload);
    }

    @GetMapping("/single")
    public Mono<Payload> getASingleOne() {

        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        ProducerClient producerClient = WebReactiveFeign.<ProducerClient>builder().target(ProducerClient.class, uri.toString());

        return producerClient.getSingle();

    }

    @GetMapping("/multiples")
    public Flux<Payload> getMultiples() {


        URI uri = discoveryClient.getInstances("producer").get(0).getUri();

        ProducerClient producerClient = WebReactiveFeign.<ProducerClient>builder().target(ProducerClient.class, uri.toString());

        return producerClient.getMultiples();

    }
}
