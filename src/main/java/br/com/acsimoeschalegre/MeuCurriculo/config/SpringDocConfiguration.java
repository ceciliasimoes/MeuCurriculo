package br.com.acsimoeschalegre.MeuCurriculo.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Configuration
    public static class SpringDocConfigurations {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("MeuCurriculo API")
                            .description("API Rest para criação e consulta de currículos")
                            .contact(new Contact()
                                    .name("Dev BackEnd AC Simões")
                                    .email("acsimoes446@gmail.com"))
                            .license(new License()
                                    .name("Apache 2.0")
                                    .url("http://github.com/cecilia-simoes")));
        }
    }
}

