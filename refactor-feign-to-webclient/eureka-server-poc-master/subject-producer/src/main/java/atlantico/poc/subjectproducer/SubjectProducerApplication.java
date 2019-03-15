package atlantico.poc.subjectproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubjectProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectProducerApplication.class, args);
	}

}
