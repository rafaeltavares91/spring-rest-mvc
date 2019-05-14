package rest.mvc.example.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		Contact contact = new Contact(
				"Rafael Tavares", 
				"https://github.com/rafaeltavares91", 
				"rafaeltavares91@gmail.com");
		
		return new ApiInfo(
				"Spring Rest MVC",
				"",
				"1.0",
				"",
				contact,
				"Apache License Version 2.0",
				"https:www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<>());
	}
	
}