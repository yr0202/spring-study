package myApp.boardApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BoardAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardAppApplication.class, args);
	}

}
