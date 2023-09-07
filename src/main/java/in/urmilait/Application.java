package in.urmilait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.out.println("main method started 1");
		System.out.println("main method started 2");
		System.out.println("main method started 3");
	}

}
