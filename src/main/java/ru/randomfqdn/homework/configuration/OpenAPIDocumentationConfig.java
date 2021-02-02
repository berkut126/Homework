package ru.randomfqdn.homework.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

@Configuration
@EnableOpenApi
public class OpenAPIDocumentationConfig {

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                .build()
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Расписание")
                .description("Расписание")
                .license("BSD-2-Clause")
                .licenseUrl("https://opensource.org/licenses/BSD-2-Clause")
                .version("0.0.2")
                .contact(new Contact("Andrey Ivanov","https://github.com/berkut126/Homework/tree/Java", "berkut126@gmail.com"))
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info()
                .title("Расписание")
                .description("Расписание")
                .version("0.0.2")
                .license(new License()
                        .name("BSD-2-Clause")
                        .url("https://opensource.org/licenses/BSD-2-Clause"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Andrey Ivanov")
                        .url("https://github.com/berkut126/Homework/tree/Java")
                        .email("berkut126@gmail.com")
                )
        );
    }

}
