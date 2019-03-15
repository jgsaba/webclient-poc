package atlantico.poc.contentconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentConsumerApplication.class, args);
	}

}
