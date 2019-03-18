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

        List<ServiceInstance> list = discoveryClient.getInstances("producer");
        if(list != null && list.size() > 0){
            URI uri = list.get(0).getUri();
            if(uri != null){
                Mono<MirrorPayload> result =  webClient.get().uri(uri.toString()+"/single").accept(MediaType.APPLICATION_JSON)
                        .retrieve().bodyToMono(MirrorPayload.class);
                return result;
            }
        }
        return null;
    }
}
