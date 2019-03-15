package atlantico.poc.contentproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentProducerApplication.class, args);
	}

}
