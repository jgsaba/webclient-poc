package atlantico.poc.verbproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VerbProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerbProducerApplication.class, args);
	}

}
