package kladionicaii.kladionica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//(access) http://localhost:8080/api/operaters/7
//(specific page) http://localhost:8080/api/operaters?page=3
//(sorting asc(default), desc) http://localhost:8080/api/operaters?sort=nazivOperater,desc
//(sorting) http://localhost:8080/api/operaters?sort=nazivOperater,idOperater,desc

//composed of @EnableAutoConfiguration, @ComponentScan & @Configuration
@SpringBootApplication
@EnableScheduling
public class KladionicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KladionicaApplication.class, args);
	}
	
	// global CORS configuration
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// allow all origins & all method by default ?
				registry
	               .addMapping("*")
	               .allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE")
	               .allowedOrigins("*")
	               .allowedHeaders("*");
			}
		};
	}

}
