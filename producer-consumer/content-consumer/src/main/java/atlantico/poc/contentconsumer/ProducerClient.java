package atlantico.poc.contentconsumer;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Headers({ "Accept: application/json" })
public interface ProducerClient {

    @RequestLine("GET /single")
    Mono<Payload> getSingle();

    @RequestLine("GET /multiples")
    Flux<Payload> getMultiples();

    @RequestLine("POST /single")
    Mono<Payload> sendAndGetOneBack(Payload payload);
}
