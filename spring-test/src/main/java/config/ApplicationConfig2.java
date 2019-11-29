package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:config/applicationContext.xml"})
public class ApplicationConfig2 {

}
