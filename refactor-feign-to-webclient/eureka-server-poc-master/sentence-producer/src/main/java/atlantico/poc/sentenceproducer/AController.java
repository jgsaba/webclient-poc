package atlantico.poc.sentenceproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@RestController
public class AController {

    @Autowired
    private DiscoveryClient client;

    private WebClient webClient;

    public AController(){
        this.webClient = WebClient.create();
    }

    @GetMapping("/sentence")
    public @ResponseBody String getASentence(){

        StringBuilder sentence = new StringBuilder();

        sentence.append(getAWord("subject-producer")).append(" ");
        sentence.append(getAWord("verb-producer")).append(" ");
        sentence.append(getAWord("complement-producer"));

        return sentence.toString();

    }

    private String getAWord(String serviceName){

        List<ServiceInstance> list = client.getInstances(serviceName);
        if(list != null && list.size() > 0){
            URI uri = list.get(0).getUri();
            if(uri != null)
                return webClient.get().uri(uri).retrieve().bodyToMono(String.class).block();
        }
        return null;
    }
}
